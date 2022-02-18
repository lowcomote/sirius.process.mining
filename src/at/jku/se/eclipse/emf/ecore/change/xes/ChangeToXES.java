package at.jku.se.eclipse.emf.ecore.change.xes;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

import org.deckfour.xes.extension.std.XConceptExtension;
import org.deckfour.xes.extension.std.XTimeExtension;
import org.deckfour.xes.factory.XFactory;
import org.deckfour.xes.factory.XFactoryBufferedImpl;
import org.deckfour.xes.model.XAttributeTimestamp;
import org.deckfour.xes.model.XEvent;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import at.jku.se.eclipse.emf.ecore.change.ChangeDescription;
import at.jku.se.eclipse.emf.ecore.change.FeatureChange;
import at.jku.se.eclipse.emf.ecore.change.ListChange;
import at.jku.se.eclipse.emf.ecore.change.ResourceChange;

public class ChangeToXES {
	public static XLog changeToXES(ChangeDescription changeDescription) {
		XConceptExtension conceptExt = XConceptExtension.instance();
		XTimeExtension timeExt = XTimeExtension.instance();
		XFactory factory = new XFactoryBufferedImpl();
		XLog log = factory.createLog();
		log.getExtensions().add(conceptExt);
		log.getExtensions().add(timeExt);
		XTrace trace = factory.createTrace();
		TreeSet<XEvent> set = new TreeSet<XEvent>(new Comparator<XEvent>() {

			public int compare(XEvent o1, XEvent o2) {
				// TODO Auto-generated method stub
				return Long.compare(getTimeStamp(o1), getTimeStamp(o2));
			}

		});
		for (Map.Entry<EObject, EList<FeatureChange>> e : changeDescription.getObjectChanges()) {
			for (FeatureChange f : e.getValue()) {
				if (f.getListChanges() != null && !f.getListChanges().isEmpty()) {
					for (ListChange l : f.getListChanges()) {
						set.add(new ObjectListChangeToEvent(l, e.getKey(), f, factory));
					}
				} else {
					set.add(new FeatureChangeToEvent(e.getKey(), f, factory));
				}
			}
		}
		for (ResourceChange r : changeDescription.getResourceChanges()) {
			for (ListChange l : r.getListChanges()) {
				set.add(new ResourceListChangeToEvent(l, r, factory));
			}
		}
		trace.addAll(set);
		log.add(trace);
		return log;
	}

	public static long getTimeStamp(XEvent event) {
		if (event.getAttributes() != null && event.getAttributes().containsKey(XTimeExtension.KEY_TIMESTAMP)) {
			XAttributeTimestamp attr = (XAttributeTimestamp) event.getAttributes().get(XTimeExtension.KEY_TIMESTAMP);
			return attr.getValueMillis();
		}
		return 0;
	}
}
