package com.unla.grupo1oo22020.models;

public class DetalleVentaModel {
	private long idDetalleVenta;
	private ProductoModel producto;
	private int cantidad;


	public DetalleVentaModel() {
		
	}

	public DetalleVentaModel(long idDetalleVenta, ProductoModel producto, int cantidad) {
		super();
		this.setIdDetalleVenta(idDetalleVenta);
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	protected void setIdDetalleVenta(long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
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

	
}