package com.unla.grupo1oo22020.models;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.Nullable;

public class PedidoModel {
	private long idPedido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPedido;
	private ProductoModel producto;
	private int cantidad;
	private float subtotal;
	private LocalModel local;
	private EmpleadoModel vendedor;
	@Nullable
	private EmpleadoModel colaborador;
	private ClienteModel cliente;
	private boolean aceptado;
	
	
	public PedidoModel() {
		
	}


	public PedidoModel(long idPedido, LocalDate fechaPedido, ProductoModel producto, int cantidad, float subtotal,
			LocalModel local, EmpleadoModel vendedor, EmpleadoModel colaborador, ClienteModel cliente,
			boolean aceptado) {
		super();
		this.setIdPedido(idPedido);
		this.fechaPedido = fechaPedido;
		this.setProducto(producto);
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.local = local;
		this.vendedor = vendedor;
		this.colaborador = colaborador;
		this.setCliente(cliente);
		this.aceptado = aceptado;
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


	public float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
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


	public ClienteModel getCliente() {
		return cliente;
	}


	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}


	public boolean isAceptado() {
		return aceptado;
	}


	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
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
	

}
