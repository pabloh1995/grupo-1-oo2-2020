package com.unla.grupo1oo22020.models;

import java.sql.Date;
import java.time.LocalDate;

public class PersonaModel {
	protected long idPersona;
	private long dni;
	private String apellido;
	private String nombre;
	private Date fechaNacimiento;

	public PersonaModel() {
	}

	public PersonaModel(long idPersona, long dni, String apellido, String nombre, Date fechaNacimiento) {
		this.idPersona = idPersona;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	

}