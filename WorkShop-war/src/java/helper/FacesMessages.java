package helper;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class FacesMessages implements Serializable {
    
    public void addError(String summary) {
        addError(summary, null);
    }

    public void addInfo(String summary) {
        addInfo(summary, null);
    }
    
    public void addWarn(String summary) {
        addInfo(summary, null);
    }
    
    public void addFatal(String summary) {
        addInfo(summary, null);
    }
    
    public void addError(String summary, String detail) {
        addError(null, summary, detail);
    }

    public void addInfo(String summary, String detail) {
        addInfo(null, summary, detail);
    }
    
    public void addWarn(String summary, String detail) {
        addWarn(null, summary, detail);
    }
    
    public void addFatal(String summary, String detail) {
        addFatal(null, summary, detail);
    }
    
    public void addError(String clientId, String summary, String detail) {
        addMessage(clientId, FacesMessage.SEVERITY_ERROR, summary, detail);
    }

    public void addInfo(String clientId, String summary, String detail) {
        addMessage(clientId, FacesMessage.SEVERITY_INFO, summary, detail);
    }
    
    public void addWarn(String clientId, String summary, String detail) {
        addMessage(clientId, FacesMessage.SEVERITY_WARN, summary, detail);
    }
    
    public void addFatal(String clientId, String summary, String detail) {
        addMessage(clientId, FacesMessage.SEVERITY_FATAL, summary, detail);
    }
    
    private void addMessage(String clientId, FacesMessage.Severity severity, String summary, String detail) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        System.out.println("Context = " + facesContext);
        facesContext.addMessage(clientId, new FacesMessage(severity, summary, detail));
    }
}
