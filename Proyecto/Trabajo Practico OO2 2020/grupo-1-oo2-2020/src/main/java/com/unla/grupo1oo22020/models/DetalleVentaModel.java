package com.unla.grupo1oo22020.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class DetalleVentaModel {

	private long idDetalleVenta;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaDetalle;
	private ProductoModel producto;
	private int cantidad;
	private float precioSubTotal;
	private VentaModel venta;

	public DetalleVentaModel() {
	}

	public DetalleVentaModel(long idDetalleVenta, LocalDate fechaDetalle, ProductoModel producto, int cantidad,
			float precioSubTotal, VentaModel venta) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.fechaDetalle = fechaDetalle;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioSubTotal = precioSubTotal;
		this.venta = venta;
	}

	public long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public LocalDate getFechaDetalle() {
		return fechaDetalle;
	}

	public void setFechaDetalle(LocalDate fechaDetalle) {
		this.fechaDetalle = fechaDetalle;
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

	public float getPrecioSubTotal() {
		return precioSubTotal;
	}

	public void setPrecioSubTotal(float precioSubTotal) {
		this.precioSubTotal = precioSubTotal;
	}

	public VentaModel getVenta() {
		return venta;
	}

	public void setVenta(VentaModel venta) {
		this.venta = venta;
	}

}