package com.unla.grupo1oo22020.entities;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

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
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="lote")
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLote;
	
	@Column(name="fechaIngreso")
	//@CreationTimestamp
	private LocalDate fechaIngreso;
	
	@Column(name="cantidadIngreso")
	private int cantidadIngreso;
	
	@Column(name="cantidadActual")
	private int cantidadActual;
	
	@Column(name="activo")
	private boolean activo;

	//@OneToOne(cascade = CascadeType.ALL)
	@OneToOne(cascade = CascadeType.MERGE)
  // @JoinColumn(name = "producto_idProducto", referencedColumnName = "idProducto")
    private Producto producto;
	
	//@OneToOne(cascade = CascadeType.ALL)
	@OneToOne(cascade = CascadeType.MERGE)
  // @JoinColumn(name = "local_idLocal", referencedColumnName = "idLocal")
    private Local local;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="stock_idStock", nullable=false)
	private Stock stock;
	*/
	
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalTime updatedAt;

	public Lote() {
		super();
	}

	public Lote(long idLote, LocalDate fechaIngreso, int cantidadIngreso, int cantidadActual, boolean activo,
			Producto producto, Local local) {
		super();
		this.idLote = idLote;
		this.fechaIngreso = fechaIngreso;
		this.cantidadIngreso = cantidadIngreso;
		this.cantidadActual = cantidadActual;
		this.activo = activo;
		this.producto = producto;
		this.local = local;
		//this.stock = stock;
	}

	public long getIdLote() {
		return idLote;
	}

	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getCantidadIngreso() {
		return cantidadIngreso;
	}

	public void setCantidadIngreso(int cantidadIngreso) {
		this.cantidadIngreso = cantidadIngreso;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	
	/*public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	*/
	

	
	
}