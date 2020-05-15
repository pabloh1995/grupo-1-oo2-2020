package com.unla.grupo1oo22020.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class EmpleadoModel extends PersonaModel {
	private long idEmpleado;
	private float sueldoBasico;
	private float comision;
	private LocalTime horarioTrabajoE;
	private LocalTime horarioTrabajoS;
	private boolean gerente;
	private LocalModel local;

	public EmpleadoModel() {
	}

	public EmpleadoModel(long idPersona, long dni, String apellido, String nombre, LocalDate fechaNacimiento, int idEmpleado,
			float sueldoBasico, float comision, LocalTime horarioTrabajoE, LocalTime horarioTrabajoS, boolean gerente, 
			LocalModel local) {
		super(idPersona, dni, apellido, nombre, fechaNacimiento);
		this.sueldoBasico = sueldoBasico;
		this.comision = comision;
		this.horarioTrabajoE = horarioTrabajoE;
		this.horarioTrabajoS = horarioTrabajoS;
		this.gerente = gerente;
		this.local = local;
	}

	public EmpleadoModel(long idPersona, long dni, String apellido, String nombre, LocalDate fechaNacimiento,
			float sueldoBasico, float comision2, LocalTime horarioTrabajoE, LocalTime horarioTrabajoS,
			boolean gerente, LocalModel local) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return idEmpleado;
	}

	protected void setId(long idEmpleado) {
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

	public LocalTime getHorarioTrabajoE() {
		return horarioTrabajoE;
	}

	public void setHorarioTrabajoE(LocalTime horarioTrabajoE) {
		this.horarioTrabajoE = horarioTrabajoE;
	}

	public LocalTime getHorarioTrabajoS() {
		return horarioTrabajoS;
	}

	public void setHorarioTrabajoS(LocalTime horarioTrabajoS) {
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