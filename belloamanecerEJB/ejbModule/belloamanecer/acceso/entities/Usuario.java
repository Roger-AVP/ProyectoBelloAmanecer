package belloamanecer.acceso.entities;

public class Usuario {
	private String nombres;
	private String apelidos;
	private String correo;
	private String clave;
	
	public Usuario(String nombres, String apelidos, String correo, String clave) {
		super();
		this.nombres = nombres;
		this.apelidos = apelidos;
		this.correo = correo;
		this.clave = clave;
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApelidos() {
		return apelidos;
	}
	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
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
