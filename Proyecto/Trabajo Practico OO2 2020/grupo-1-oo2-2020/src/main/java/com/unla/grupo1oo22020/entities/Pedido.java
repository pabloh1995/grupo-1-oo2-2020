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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;

	@Column(name = "fechaPedido")
	@CreationTimestamp
	private LocalDate fechaPedido;

	@OneToOne(cascade = CascadeType.MERGE)
	private Producto producto;

	@Column(name = "cantidad")
	private int cantidad;

	@OneToOne(cascade = CascadeType.MERGE)
	private Local local;

	@OneToOne(cascade = CascadeType.MERGE)
	private Empleado empleado;

	@OneToOne(cascade = CascadeType.MERGE)
	private Cliente cliente;

	@Column(name = "precioTotal")
	private float precioTotal;

	@Column(name = "resuelto")
	private boolean resuelto;

	public Pedido() {

	}

	public Pedido(long idPedido, LocalDate fechaPedido, Producto producto, int cantidad, Local local, Empleado empleado,
			Cliente cliente, float precioTotal, boolean resuelto) {
		super();
		this.setIdPedido(idPedido);
		this.fechaPedido = fechaPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.local = local;
		this.empleado = empleado;
		this.cliente = cliente;
		this.precioTotal = precioTotal;
		this.resuelto = resuelto;
	}

	public Pedido(LocalDate fechaPedido, Producto producto, int cantidad, Local local, Empleado empleado,
			float precioTotal) {
		super();
		this.fechaPedido = fechaPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.local = local;
		this.empleado = empleado;
		this.precioTotal = precioTotal;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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