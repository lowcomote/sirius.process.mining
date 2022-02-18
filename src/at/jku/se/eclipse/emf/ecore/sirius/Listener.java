package at.jku.se.eclipse.emf.ecore.sirius;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;

import org.deckfour.xes.extension.std.XConceptExtension;
import org.deckfour.xes.extension.std.XTimeExtension;
import org.deckfour.xes.factory.XFactory;
import org.deckfour.xes.factory.XFactoryRegistry;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;
import org.deckfour.xes.model.impl.XAttributeMapImpl;
import org.deckfour.xes.model.impl.XAttributeTimestampImpl;
import org.deckfour.xes.model.impl.XTraceImpl;
import org.deckfour.xes.out.XesXmlSerializer;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import at.jku.se.eclipse.emf.ecore.change.ChangeDescription;
import at.jku.se.eclipse.emf.ecore.change.util.ChangeRecorder;
import at.jku.se.eclipse.emf.ecore.change.xes.ChangeToXES;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.transaction.impl.InternalTransactionalCommandStack;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionChangeRecorder;
import org.eclipse.sirius.business.api.session.Session;

public class Listener {
	private XLog log;
	private XTrace trace;
	private Session session;
	ResourceSet resourceSet;
	private ChangeRecorder recorder;

	public Listener(Session session) {
		this.session = session;

		log = Util.getFactory().createLog();
		log.getExtensions().add(Util.getConceptExt());
		log.getExtensions().add(Util.getTimeExt());

		trace = Util.getFactory().createTrace();
		resourceSet = session.getTransactionalEditingDomain().getResourceSet();
		recorder = new ChangeRecorder();
		recorder.beginRecording(Collections.singleton(resourceSet));
	}

	public void serializeLog() {
		log.add(trace);
		XesXmlSerializer serializer = new XesXmlSerializer();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm");
		String formattedDateTime = LocalDateTime.now().format(formatter); // "2015-07-07 12.30"
		String sessionId = session.getID().replace("platform:/resource/", "");
		String formattedSessionId = sessionId.replace("/", "-");
		String name = formattedDateTime + " " + formattedSessionId;
		File file = new File(Activator.getPath() + "\\XES\\" + name + ".xes");
		ChangeDescription ch = saveXMI(Activator.getPath() + "\\XMI\\" + name + ".xmi");
		log = recorder.getLog();
		System.out.println(file.getAbsolutePath());
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
			OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			// nested attributes : false
			serializer.serialize(log, out, false);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ChangeDescription saveXMI(String path) {
		ChangeDescription changeDescription = recorder.endRecording();
		recorder.dispose();
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("change", new XMIResourceFactoryImpl());
		URI uri = URI.createURI("file:/" + path);
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(changeDescription);
		try {
			resource.save(null);
			System.out.println("saved to " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return changeDescription;
	}

}