package belloamanecer.acceso.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import belloamanecer.acceso.entities.InvUsuario;



/**
 * Session Bean implementation class ManagerAdministrador
 */
@Stateless
@LocalBean
public class ManagerAdministrador {
	@PersistenceContext
	private EntityManager em;
    public ManagerAdministrador() {
        // TODO Auto-generated constructor stub
    }
    
    public List<InvUsuario> findAllInvUsuarios(){
    	String consulta="select f from InvUsuario f";
    	Query q = em.createQuery(consulta, InvUsuario.class);
    	return q.getResultList();
    }

}
