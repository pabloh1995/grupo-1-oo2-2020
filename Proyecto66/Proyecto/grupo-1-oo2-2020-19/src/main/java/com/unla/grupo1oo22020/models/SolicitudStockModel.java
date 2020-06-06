package com.unla.grupo1oo22020.models;


import java.time.LocalDate;


public class SolicitudStockModel {
	private long idSolicitudStock;
	private LocalDate fechaSolicitudStock;
	private ProductoModel producto;
	private int cantidad;
	private boolean aceptado;
	//private EmpleadoModel empleado;
	private LocalModel local;
	
	public SolicitudStockModel() {

	}

	public SolicitudStockModel(long idSolicitudStock, LocalDate fechaSolicitudStock, ProductoModel producto, int cantidad,
			LocalModel local) {
		super();
		this.idSolicitudStock = idSolicitudStock;
		this.fechaSolicitudStock = fechaSolicitudStock;
		this.producto = producto;
		this.cantidad = cantidad;
		//this.empleado = empleado;
		this.local = local;
		this.aceptado = false;
	}
	
	public SolicitudStockModel(int cantidad, ProductoModel producto) {

		this.cantidad = cantidad;
		this.aceptado=false;
		this.producto= producto;
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

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
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

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}
	
	

}
