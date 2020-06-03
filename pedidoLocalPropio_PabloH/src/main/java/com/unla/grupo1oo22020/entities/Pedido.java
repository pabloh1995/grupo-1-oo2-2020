package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	
	private LocalDate fechaPedido;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Producto producto;
	
	private int cantidad;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Local local;

	public Pedido() {
		
	}

	public Pedido(long idPedido, LocalDate fechaPedido, Producto producto, int cantidad, Local local) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.local = local;
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

	
}
