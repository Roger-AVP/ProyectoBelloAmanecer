package belloamanecer.acceso;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;

import org.primefaces.PrimeFaces;
import belloamanecer.acceso.entities.Usuario;
import belloamanecer.acceso.manager.ManagerIniciarSesion;
@Named
@SessionScoped
public class BeanIniciarSesion implements Serializable  {
	
	private static final long serialVersionUID = 1L; 
	@EJB
	
	private ManagerIniciarSesion managerIS;
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
	
	public String verificar() {
		FacesMessage message = null;
        boolean loggedIn = false;
		List<Usuario> listaUsuarios = managerIS.listarUsuarios(); 
		int si = 0;
		for(Usuario us:listaUsuarios) {
			 System.out.println(us.getNombres()); 
			 if(correo != null && correo.equals(us.getCorreo()) && clave != null && clave.equals(us.getClave())) {
					si++;
				}
		 }

		if(si > 0){
		 	loggedIn = true;
			 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", correo);
			 FacesContext.getCurrentInstance().addMessage(null, message);
		        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		     
			 return  "inicio";
		        } else {
		        	loggedIn = false;
		            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		            FacesContext.getCurrentInstance().addMessage(null, message);
		            PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		         
		            return  "";
		        }

		 
		
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
