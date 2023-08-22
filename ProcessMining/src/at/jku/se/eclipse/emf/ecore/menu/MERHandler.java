package at.jku.se.eclipse.emf.ecore.menu;

import java.util.HashMap;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import at.jku.se.eclipse.emf.ecore.sirius.Listener;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchWindow;

public class MERHandler implements IHandler {
	
	HashMap<Session, Listener> listenerMap;
	
	

	public MERHandler() {
		super();
		listenerMap = new HashMap<Session, Listener>();
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
        
        if (activeEditor != null) {
            IEditorSite editorSite = activeEditor.getEditorSite();
            Session siriusSession = getSessionFromEditorSite(editorSite);
            
            if (siriusSession != null) {
                if(listenerMap.containsKey(siriusSession)) {
                	//stop and save recording
                	Listener listener = listenerMap.get(siriusSession);
        			listenerMap.remove(siriusSession);
        			if (listener != null) {
        				String file = listener.serializeLog();
            			showMessage("Saved", "The event log is saved at : " + file, event);
        			}
                }
                else {
                	//start recording
                	Listener listener = new Listener(siriusSession);
        			listenerMap.put(siriusSession, listener);
        			showMessage("Started", "The event log is being recorded", event);
                }
            }
        }
        
        return null;
    }
	
	private void showMessage(String title, String message, ExecutionEvent event) {
		IWorkbenchWindow window;
		try {
			window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			MessageDialog.openInformation(
					window.getShell(),
					title,
					message);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private Session getSessionFromEditorSite(IEditorSite editorSite) {
        SessionEditorInput editorInput = (SessionEditorInput) editorSite.getWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
        return editorInput.getSession();
    }

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
