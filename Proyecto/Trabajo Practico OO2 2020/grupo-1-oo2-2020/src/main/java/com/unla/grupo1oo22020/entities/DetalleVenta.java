package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "detalleVenta")

public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetalleVenta;

	@Column(name = "fechaDetalle")
	@CreationTimestamp
	LocalDate fechaDetalle;

	@OneToOne(cascade = CascadeType.MERGE)
	private Producto producto;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "precioSubTotal")
	private float precioSubTotal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVenta", nullable = false)
	private Venta venta;

	public DetalleVenta() {
	}

	public DetalleVenta(long idDetalleVenta, LocalDate fechaDetalle, Producto producto, int cantidad,
			float precioSubTotal, Venta venta) {
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

	public float getPrecioSubTotal() {
		return precioSubTotal;
	}

	public void setPrecioSubTotal(float precioSubTotal) {
		this.precioSubTotal = precioSubTotal;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
