package co.edu.uniquindio.banco.bancouq.model;


import java.util.Set;

public abstract class Persona {

	private String nombre;
	private String cedula;

	private String correo;

	private Set<Rol> roles;

	
	
	
	public Persona() {
		
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

}
