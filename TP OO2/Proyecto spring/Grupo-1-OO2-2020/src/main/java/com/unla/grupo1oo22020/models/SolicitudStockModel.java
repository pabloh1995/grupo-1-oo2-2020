package com.unla.grupo1oo22020.models;

import java.time.LocalDate;

public class SolicitudStockModel {
	private long idSolicitudStock;
	private LocalDate fecha;
	private ProductoModel producto;
	private int cantidad;
	private EmpleadoModel vendedor;
	private EmpleadoModel colaborador;
	private boolean aceptado;

	public SolicitudStockModel() {

	}

	public SolicitudStockModel(long idSolicitudSotck, LocalDate fecha, ProductoModel producto, int cantidad, EmpleadoModel vendedor,
			EmpleadoModel colaborador, boolean aceptado) {
		super();
		this.setId(idSolicitudSotck);
		this.fecha = fecha;
		this.setProducto(producto);
		this.cantidad = cantidad;
		this.setVendedor(vendedor);
		this.setColaborador(colaborador);
		this.aceptado = aceptado;
	}

	public long getId() {
		return idSolicitudStock;
	}

	protected void setId(long idSolicitudStock) {
		this.idSolicitudStock = idSolicitudStock;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	public EmpleadoModel getVendedor() {
		return vendedor;
	}

	public void setVendedor(EmpleadoModel vendedor) {
		this.vendedor = vendedor;
	}

	public EmpleadoModel getColaborador() {
		return colaborador;
	}

	public void setColaborador(EmpleadoModel colaborador) {
		this.colaborador = colaborador;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}


}