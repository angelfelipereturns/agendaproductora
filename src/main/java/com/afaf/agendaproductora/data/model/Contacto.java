package com.afaf.agendaproductora.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Contacto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=3, max=255, message="nombre.size")
	private String nombre;
	
	@NotNull
	@Size(min=3, max=255, message="apellidos.size")
	private String apellidos;
	
	@NotNull
	@Digits(fraction=0, integer=9, message="telefono.size")
	private Long telefono;
	
	@NotNull
	@Email(message="email.valid")
	@Size(min=6, max=255)
	private String email;
	
	public Contacto() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
