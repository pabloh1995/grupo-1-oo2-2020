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
	
	
	
	public SolicitudStock() {}

	public SolicitudStock(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.aceptado = false;
		this.producto = producto;
	}
	
	public SolicitudStock(long idSolicitudStock, int cantidad, Producto producto) {
		this.idSolicitudStock = idSolicitudStock;
		this.cantidad = cantidad;
		this.aceptado = false;
		this.producto = producto;
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
	
	

	
	
	
}