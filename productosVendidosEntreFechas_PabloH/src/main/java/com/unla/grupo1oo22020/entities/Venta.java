package com.unla.grupo1oo22020.entities;



import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idVenta")
	private long idVenta;
	
	@Column(name = "fechaVenta")
	@CreationTimestamp
	LocalDate fechaVenta;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Empleado empleado;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLocal", nullable=false)
	private Local local;
	
	@Column(name = "total")
	private float total;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<DetalleVenta> detalleVenta = new HashSet<>();

	public Venta() {
	}

	public Venta(long idVenta, LocalDate fechaVenta, Empleado empleado, Cliente cliente, Local local, float total) {
		super();
		this.idVenta = idVenta;
		this.fechaVenta = fechaVenta;
		this.empleado = empleado;
		this.cliente = cliente;
		this.local = local;
		this.total = total;
	}

	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Set<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(Set<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	
}
