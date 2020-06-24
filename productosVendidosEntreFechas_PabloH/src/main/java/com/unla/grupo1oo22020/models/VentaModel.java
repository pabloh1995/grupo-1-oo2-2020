package com.unla.grupo1oo22020.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


public class VentaModel {
	private long idVenta;
	private LocalDate fechaVenta;
	private EmpleadoModel empleado;
	private ClienteModel cliente;
	private LocalModel local;
	private float total;
	private Set<DetalleVentaModel> detalleVenta= new HashSet<>();

	
	public VentaModel() {	
	}


	public VentaModel(long idVenta, LocalDate fechaVenta, EmpleadoModel empleado, ClienteModel cliente, LocalModel local, float total) {
		super();
		this.idVenta = idVenta;
		this.fechaVenta = fechaVenta;
		this.empleado = empleado;
		this.cliente = cliente;
		this.local = local;
		this.total = total;
	}


	public long getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}


	public LocalDate getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public EmpleadoModel getEmpleado() {
		return empleado;
	}


	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}


	public ClienteModel getCliente() {
		return cliente;
	}


	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}


	public LocalModel getLocal() {
		return local;
	}


	public void setLocal(LocalModel local) {
		this.local = local;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public Set<DetalleVentaModel> getDetalleVenta() {
		return detalleVenta;
	}


	public void setDetalleVenta(Set<DetalleVentaModel> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	
}
