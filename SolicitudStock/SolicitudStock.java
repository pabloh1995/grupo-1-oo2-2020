package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.unla.grupo1oo22020.models.ProductoModel;

@Entity
@Table(name="solicitudStock")
public class SolicitudStock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSolicitudStock;
	
	private LocalDate fechaSolicitudStock;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
	private Producto producto;
	
	@Column
	private int cantidad;
	
	@Column
	private boolean aceptado;
	
	@OneToOne(cascade = CascadeType.MERGE)
	
	private Empleado empleado;
	
	@OneToOne(cascade = CascadeType.MERGE)
	
	private Empleado colaborador;
	
	@OneToOne(cascade = CascadeType.MERGE)
	
	private Local local;
	
	@OneToOne(cascade = CascadeType.MERGE)
	
	private Local local2;
	
	public SolicitudStock() {
		
	}

	public SolicitudStock(long idSolicitudStock, LocalDate fechaSolicitudStock, Producto producto, int cantidad,
			boolean aceptado, Empleado empleado, Empleado colaborador, Local local, Local local2) {
		super();
		this.idSolicitudStock = idSolicitudStock;
		this.fechaSolicitudStock = fechaSolicitudStock;
		this.producto = producto;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.empleado = empleado;
		this.colaborador = colaborador;
		this.local = local;
		this.local2 = local2;
	}

	public long getIdSolicitudStock() {
		return idSolicitudStock;
	}

	public void setIdSolicitudStock(long idSolicitudStock) {
		this.idSolicitudStock = idSolicitudStock;
	}

	public LocalDate getFechaSolicitudStock() {
		return fechaSolicitudStock;
	}

	public void setFechaSolicitudStock(LocalDate fechaSolicitudStock) {
		this.fechaSolicitudStock = fechaSolicitudStock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empleado getColaborador() {
		return colaborador;
	}

	public void setColaborador(Empleado colaborador) {
		this.colaborador = colaborador;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Local getLocal2() {
		return local2;
	}

	public void setLocal2(Local local2) {
		this.local2 = local2;
	}


	
}