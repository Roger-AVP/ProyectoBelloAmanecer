package belloamanecer.acceso.entities;

public class RolesUsuario {
	private String rol;
	private String usuario;
	public RolesUsuario(String rol, String usuario) {
		super();
		this.rol = rol;
		this.usuario = usuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
