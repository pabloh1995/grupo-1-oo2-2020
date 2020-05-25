package com.unla.grupo1oo22020.models;

import java.sql.Date;

public class SolicitudStockModel {
	private long idSolicitudStock;
	private Date fecha;
	private ProductoModel producto;
	private int cantidad;
	private EmpleadoModel empleado;
	private LocalModel local;
	private boolean aceptado;
	
	
	public SolicitudStockModel() {

	}

	public SolicitudStockModel(long idSolicitudStock, Date fecha, ProductoModel producto, int cantidad,
			EmpleadoModel empleado, LocalModel local, boolean aceptado) {
		super();
		this.idSolicitudStock = idSolicitudStock;
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.empleado = empleado;
		this.local = local;
		this.aceptado = aceptado;
	}
	
	

}
