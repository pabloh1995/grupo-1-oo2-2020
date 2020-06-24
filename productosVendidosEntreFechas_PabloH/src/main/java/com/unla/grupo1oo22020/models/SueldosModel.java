package com.unla.grupo1oo22020.models;

public class SueldosModel {
	private long idSueldoBruto;
	private EmpleadoModel empleado;
	private float sueldoBruto;
	
	public SueldosModel(EmpleadoModel empleado, float sueldoBruto) {
		super();
		this.empleado = empleado;
		this.sueldoBruto = sueldoBruto;
	}

	public SueldosModel() {
		// TODO Auto-generated constructor stub
	}

	public long getIdSueldoBruto() {
		return idSueldoBruto;
	}

	public void setIdSueldoBruto(long idSueldoBruto) {
		this.idSueldoBruto = idSueldoBruto;
	}

	public EmpleadoModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}

	public float getSueldoBruto() {
		return sueldoBruto;
	}

	public void setSueldoBruto(float sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	
	

}
