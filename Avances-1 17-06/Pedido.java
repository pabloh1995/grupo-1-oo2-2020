package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	
	@Column(name="fechaPedido")
	private LocalDate fechaPedido;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Producto producto;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Local local;
	
	@Column(name="precioTotal")
	private float precioTotal;
	
	@Column (name= "resuelto")
	private boolean resuelto;
	
	public Pedido() {
		
	}

	public Pedido(long idPedido, LocalDate fechaPedido, Producto producto, int cantidad, Local local, float precioTotal, boolean resuelto) {
		super();
		this.setIdPedido(idPedido);
		this.fechaPedido = fechaPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.local = local;
		this.precioTotal = precioTotal;
		this.resuelto = resuelto;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public float precioTotal(Producto producto, int cantidad) {
		return precioTotal = producto.getPrecioUnitario() * cantidad;
	}

	public boolean isResuelto() {
		return resuelto;
	}

	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}
	
}