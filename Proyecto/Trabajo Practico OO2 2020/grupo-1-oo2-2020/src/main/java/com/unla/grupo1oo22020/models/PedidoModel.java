package com.unla.grupo1oo22020.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PedidoModel {
	private long idPedido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPedido;
	private ProductoModel producto;
	private int cantidad;
	private LocalModel local;
	private EmpleadoModel empleado;
	private ClienteModel cliente;
	private float precioTotal;
	private boolean resuelto;

	public PedidoModel() {

	}

	public PedidoModel(long idPedido, LocalDate fechaPedido, ProductoModel producto, int cantidad, LocalModel local,
			EmpleadoModel empleado, ClienteModel cliente, float precioTotal, boolean resuelto) {
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

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public EmpleadoModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public float getPrecioTotal() {
		return precioTotal = this.getProducto().getPrecioUnitario() * cantidad;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public boolean isResuelto() {
		return resuelto;
	}

	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}

}