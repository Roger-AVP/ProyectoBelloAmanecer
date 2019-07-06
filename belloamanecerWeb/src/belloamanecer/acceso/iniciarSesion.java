package belloamanecer.acceso;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
@Named
@SessionScoped
public class iniciarSesion implements Serializable  {
	
	private static final long serialVersionUID = 1L; 
	private String correo;
	private String clave;
	
	public void acceder() {
		FacesMessage message = null;
        boolean loggedIn = false;
          
        if(correo != null && correo.equals("admin") && clave != null && clave.equals("admin123")) {
        	 loggedIn = true;
             message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", correo);
        } else {
        	loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
       
    }

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}   
	
	
}
