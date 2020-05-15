package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Cliente extends Persona {
	
	
	private long idCliente;
	private String email;

	public Cliente() {
		super();
	}

	public Cliente(long idPersona, long dni, String apellido, String nombre, LocalDate fechaNacimiento, String email2) {
		// TODO Auto-generated constructor stub
	}

	public Cliente(long idCliente, String email) {
		super();
		this.setIdCliente(idCliente);
		this.email = email;
	}


	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}