package belloamanecer.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import belloamanecer.acceso.entities.InvUsuario;
import belloamanecer.acceso.manager.ManagerAdministrador;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanInvUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagerAdministrador managerAdministrador;
	private List<InvUsuario> listarUsuarios;
	
	@PostConstruct
	public void inicializar() {
		listarUsuarios=managerAdministrador.findAllInvUsuarios();
	}

	public List<InvUsuario> getListarUsuarios() {
		return listarUsuarios;
	}

	public void setListarUsuarios(List<InvUsuario> listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}

}
