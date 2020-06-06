package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.Nullable;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	
	@Column(name = "fechaPedido")
	@CreationTimestamp
	private LocalDate fechaPedido;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Producto producto;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "subtotal")
	private float subtotal;
	
	@OneToOne
	private Local local;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id_vendedor")
	private Empleado vendedor;
	
	@Nullable
	@OneToOne(cascade = CascadeType.MERGE, optional=true)
	@JoinColumn(name="id_colaborador")
	private Empleado colaborador;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Cliente cliente;

	@Column(name = "aceptado")
	private boolean aceptado;
	
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalTime updatedAt;

	public Pedido() {
		
	}

	public Pedido(long idPedido, LocalDate fechaPedido, Producto producto, int cantidad, float subtotal, Local local,
			Empleado vendedor, Empleado colaborador, Cliente cliente, boolean aceptado) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.local = local;
		this.vendedor = vendedor;
		this.colaborador = colaborador;
		this.cliente = cliente;
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

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	public float CalcularSubtotal() {
		return producto.getPrecioUnitario()*cantidad;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public Empleado getColaborador() {
		return colaborador;
	}

	public void setColaborador(Empleado colaborador) {
		this.colaborador = colaborador;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	

	

	
}
