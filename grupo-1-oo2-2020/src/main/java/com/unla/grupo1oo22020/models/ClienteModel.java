package com.unla.grupo1oo22020.models;

import java.sql.Date;
import java.time.LocalDate;

public class ClienteModel extends PersonaModel {
	private long idCliente;
	private String email;

	public ClienteModel() {
	}

	public ClienteModel(long idPersona, long dni, String apellido, String nombre, Date fechaNacimiento, String email) {
		super(idPersona, dni, apellido, nombre, fechaNacimiento);
		this.email=email;
	}


	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}