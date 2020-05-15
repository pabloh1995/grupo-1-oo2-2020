package com.unla.grupo1oo22020.models;

import java.time.LocalDate;
import java.util.Set;

public class VentaModel {
	private long idVenta;
	private ClienteModel cliente;
	private LocalDate fechaActual;
	private EmpleadoModel empleado;
	private Set<DetalleVentaModel> DetallesVenta;
	

	public VentaModel() {

	}

	public VentaModel(long idVenta, ClienteModel cliente, LocalDate fechaActual, EmpleadoModel empleado,
			Set<DetalleVentaModel> detallesVenta) {
		super();
		this.setIdVenta(idVenta);
		this.cliente = cliente;
		this.fechaActual = fechaActual;
		this.empleado = empleado;
		DetallesVenta = detallesVenta;
	}

	
	public long getIdVenta() {
		return idVenta;
	}

	protected void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	public EmpleadoModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}

	public Set<DetalleVentaModel> getDetallesVenta() {
		return DetallesVenta;
	}

	public void setDetallesVenta(Set<DetalleVentaModel> detallesVenta) {
		DetallesVenta = detallesVenta;
	}


}