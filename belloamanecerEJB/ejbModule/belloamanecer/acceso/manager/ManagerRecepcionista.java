package belloamanecer.acceso.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import belloamanecer.acceso.entities.FacDetalle;
import belloamanecer.acceso.entities.FacReserva;
import belloamanecer.acceso.entities.InvUsuario;

/**
 * Session Bean implementation class ManagerRecepcionista
 */
@Stateless
@LocalBean
public class ManagerRecepcionista {
	@PersistenceContext
	private EntityManager em;
    public ManagerRecepcionista() {
        // TODO Auto-generated constructor stub
    }

    public List<FacReserva> findAllFacReservas(){
    	String consulta="select f from FacReserva f";
    	Query q=em.createQuery(consulta,FacReserva.class);
    	return q.getResultList();
    }
    public List<FacDetalle> findAllFacDetalles(){
    	String consulta="select f from FacDetalle f";
    	Query q=em.createQuery(consulta,FacReserva.class);
    	return q.getResultList();
    }
    public List<InvUsuario> findAllInvUsuarios(){
    	String consulta="select f from InvUsuario f";
    	Query q=em.createQuery(consulta,FacReserva.class);
    	return q.getResultList();
    }
}
