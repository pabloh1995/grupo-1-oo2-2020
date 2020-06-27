package com.unla.grupo1oo22020.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class SolicitudStockModel {
	private long idSolicitudStock;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaSolicitudStock;
	private ProductoModel producto;
	private int cantidad;
	private boolean aceptado;
	private EmpleadoModel empleado;
	private EmpleadoModel colaborador;
	private LocalModel local;
	private LocalModel local2;
	private PedidoModel pedido;
	private boolean activo;

	public SolicitudStockModel() {
	}

	public SolicitudStockModel(long idSolicitudStock, LocalDate fechaSolicitudStock, ProductoModel producto,
			int cantidad, boolean aceptado, EmpleadoModel empleado, EmpleadoModel colaborador, LocalModel local,
			LocalModel local2, PedidoModel pedido, boolean activo) {
		super();
		this.idSolicitudStock = idSolicitudStock;
		this.fechaSolicitudStock = fechaSolicitudStock;
		this.producto = producto;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.empleado = empleado;
		this.colaborador = colaborador;
		this.local = local;
		this.local2 = local2;
		this.pedido = pedido;
		this.activo = activo;
	}

	public SolicitudStockModel(long idSolicitudStock, LocalDate fechaSolicitudStock, ProductoModel producto,
			int cantidad, boolean aceptado, EmpleadoModel empleado, LocalModel local, LocalModel local2,
			PedidoModel pedido, boolean activo) {
		super();
		this.idSolicitudStock = idSolicitudStock;
		this.fechaSolicitudStock = fechaSolicitudStock;
		this.producto = producto;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.empleado = empleado;
		this.local = local;
		this.local2 = local2;
		this.pedido = pedido;
		this.activo = activo;
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

	public EmpleadoModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}

	public EmpleadoModel getColaborador() {
		return colaborador;
	}

	public void setColaborador(EmpleadoModel colaborador) {
		this.colaborador = colaborador;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public LocalModel getLocal2() {
		return local2;
	}

	public void setLocal2(LocalModel local2) {
		this.local2 = local2;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}