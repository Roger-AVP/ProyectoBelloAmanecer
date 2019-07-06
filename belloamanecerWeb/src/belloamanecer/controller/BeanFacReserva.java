package belloamanecer.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import belloamanecer.acceso.entities.FacDetalle;
import belloamanecer.acceso.entities.FacReserva;
import belloamanecer.acceso.entities.InvUsuario;
import belloamanecer.acceso.manager.ManagerRecepcionista;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BeanFacReserva implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerRecepcionista managerRecepcionista;
	private List<FacReserva> listaFacReservas;
	private List<FacDetalle> listaFacDetalles;
	private List<InvUsuario> listaInvUsuarios;
	private boolean panelColapso;
	
	@PostConstruct
	public void inicializar() {
		listaFacReservas=managerRecepcionista.findAllFacReservas();
		listaFacDetalles=managerRecepcionista.findAllFacDetalles();
		listaInvUsuarios=managerRecepcionista.findAllInvUsuarios();
	}
	public void actionListenerColapsarPanel() {
		panelColapso=!panelColapso;
	}

	public List<FacReserva> getListaFacReservas() {
		return listaFacReservas;
	}

	public void setListaFacReservas(List<FacReserva> listaFacReservas) {
		this.listaFacReservas = listaFacReservas;
	}

	public List<FacDetalle> getListaFacDetalles() {
		return listaFacDetalles;
	}

	public void setListaFacDetalles(List<FacDetalle> listaFacDetalles) {
		this.listaFacDetalles = listaFacDetalles;
	}

	public List<InvUsuario> getListaInvUsuarios() {
		return listaInvUsuarios;
	}

	public void setListaInvUsuarios(List<InvUsuario> listaInvUsuarios) {
		this.listaInvUsuarios = listaInvUsuarios;
	}

	public boolean isPanelColapso() {
		return panelColapso;
	}

	public void setPanelColapso(boolean panelColapso) {
		this.panelColapso = panelColapso;
	}
	
}
