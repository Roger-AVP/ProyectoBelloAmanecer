package belloamanecer.acceso.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import belloamanecer.acceso.entities.Usuario;
import belloamanecer.acceso.entities.RolesUsuario;

import java.util.ArrayList; 
import java.util.List;

/**
 * Session Bean implementation class InciarSesion
 */
@Stateless
@LocalBean
public class ManagerIniciarSesion {

    /**
     * Default constructor. 
     */
    public ManagerIniciarSesion() {
        // TODO Auto-generated constructor stub
    }
    
    public  List<Usuario>  listarUsuarios(){    
		 System.out.println("acaaaa"); 
		 List<Usuario> listaUsuarios=new ArrayList<Usuario>();        
		 Usuario u=new Usuario("Roger","Vaca","ravacap@utn.edu.ec","12345678");        
		 listaUsuarios.add(u);        
		 u=new Usuario("Fabricio","Riascos","fabricio@utn.edu.ec","12345678");        
		 listaUsuarios.add(u);        
		 u=new Usuario("Gissela","Quiña","gissela@utn.edu.ec","12345678");        
		 listaUsuarios.add(u);        
		 u=new Usuario("Yuliza","Vizcaino","yuliza@utn.edu.ec","12345678");        
		 listaUsuarios.add(u);   
		 for(Usuario us:listaUsuarios) {
			 System.out.println(us.getNombres()); 
		 }
		 return listaUsuarios; 
	}
    
    public  List<RolesUsuario>  listarRolesUsuarios(){    
		 System.out.println("acaaaa 2"); 
		 List<RolesUsuario> listaRolesUsuarios=new ArrayList<RolesUsuario>();        
		 RolesUsuario u=new RolesUsuario("Administrador","ravacap@utn.edu.ec");        
		 listaRolesUsuarios.add(u);        
		 u=new RolesUsuario("Gerente","ravacap@utn.edu.ec");        
		 listaRolesUsuarios.add(u);        
		 u=new RolesUsuario("Recepcionista","gissela@utn.edu.ec");        
		 listaRolesUsuarios.add(u);     
		 u=new RolesUsuario("Administrador","gissela@utn.edu.ec");        
		 listaRolesUsuarios.add(u); 
		 u=new RolesUsuario("Cliente","yuliza@utn.edu.ec");        
		 listaRolesUsuarios.add(u);   
		
		 return listaRolesUsuarios; 
	}
}
