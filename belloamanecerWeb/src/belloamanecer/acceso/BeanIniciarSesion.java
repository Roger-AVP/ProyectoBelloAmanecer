package belloamanecer.acceso;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;

import belloamanecer.acceso.entities.RolesUsuario;
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
	private List<String> listaRolesUsuario =new ArrayList<String>();
	private String rolSeleccionado;
	
	
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
			 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso correcto", correo);
			 FacesContext.getCurrentInstance().addMessage(null, message);
		        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		        List<RolesUsuario> listado = new ArrayList<RolesUsuario>();     
		       listado = managerIS.listarRolesUsuarios(); 
		       this.listaRolesUsuario = new ArrayList<String>();
		        for(RolesUsuario rolUsu:listado) {
		        	if(correo.equals(rolUsu.getUsuario())) {
		        		
		        		this.listaRolesUsuario.add((rolUsu.getRol()));   
		        		 
		        			 System.out.println("USUARIO"+rolUsu.getUsuario()); 
		        			 System.out.println("ROL"+rolUsu.getRol()); 
		        		 
		        	}
		        	
		        }
		        
		     
			 return  "seleccionarRol";
		        } else {
		        	loggedIn = false;
		            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al intentar acceder", "Credenciales incorrectas");
		            FacesContext.getCurrentInstance().addMessage(null, message);
		            PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		         
		            return  "";
		        }	
	}
	
	public List<String> getListaRolesUsuario() { return listaRolesUsuario; } 
	
	public void ir() {
		try{
			if(this.rolSeleccionado.equals("Administrador")) {
				FacesContext contex = FacesContext.getCurrentInstance();
	            contex.getExternalContext().redirect("../administrador/usuarios.xhtml" );
			} else if(this.rolSeleccionado.equals("Recepcionista")) {
				FacesContext contex = FacesContext.getCurrentInstance();
	            contex.getExternalContext().redirect("../recepcionista/reservas.xhtml" );
			}else {
				FacesContext contex = FacesContext.getCurrentInstance();
	            contex.getExternalContext().redirect("bienvenido.xhtml" );
				
			}
            
		}catch(  Exception e ){
			System.out.println( "Me voy al carajo, no funciona esta redireccion" );
		}
	}
	
	public void cerrarSesion() {
		 try{
		 System.out.println( "A CERRA");
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		 FacesContext contex = FacesContext.getCurrentInstance();
         contex.getExternalContext().redirect("iniciarSesion.xhtml");
         System.out.println( "CERRADO");
		}catch(  Exception e ){
			System.out.println( "Me voy al carajo, no funciona esta redireccion" );
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

	public String getRolSeleccionado() {
		return rolSeleccionado;
	}

	public void setRolSeleccionado(String rolSeleccionado) {
		this.rolSeleccionado = rolSeleccionado;
	}   
	
	
}
