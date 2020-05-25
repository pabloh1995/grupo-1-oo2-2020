package com.unla.grupo1oo22020.models;

import java.sql.Date;
import java.time.LocalDate;

public class EmpleadoModel extends PersonaModel {
	private long idEmpleado;
	private float sueldoBasico;
	private float comision;
	private String horarioTrabajoE;
	private String horarioTrabajoS;
	private boolean gerente;
	private LocalModel local;

	public EmpleadoModel() {
	}

	public EmpleadoModel(long idPersona, long dni, String apellido, String nombre, Date fechaNacimiento,
			float sueldoBasico, float comision, String horarioTrabajoE, String horarioTrabajoS, boolean gerente, 
			LocalModel local) {
		super(idPersona, dni, apellido, nombre, fechaNacimiento);
		this.sueldoBasico = sueldoBasico;
		this.comision = comision;
		this.horarioTrabajoE = horarioTrabajoE;
		this.horarioTrabajoS = horarioTrabajoS;
		this.gerente = gerente;
		this.local = local;
	}


	public long getId() {
		return idEmpleado;
	}

	public void setId(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public float getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public String getHorarioTrabajoE() {
		return horarioTrabajoE;
	}

	public void setHorarioTrabajoE(String horarioTrabajoE) {
		this.horarioTrabajoE = horarioTrabajoE;
	}

	public String getHorarioTrabajoS() {
		return horarioTrabajoS;
	}

	public void setHorarioTrabajoS(String horarioTrabajoS) {
		this.horarioTrabajoS = horarioTrabajoS;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}


}