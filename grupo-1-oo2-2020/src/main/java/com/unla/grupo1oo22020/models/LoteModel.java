package com.unla.grupo1oo22020.models;

import java.sql.Date;
import java.time.LocalDate;

import com.unla.grupo1oo22020.entities.Stock;


public class LoteModel {
	private long idLote;
	private Date fechaIngreso;
	private int cantidadIngreso;
	private int cantidadActual;
	private boolean activo;
	private ProductoModel producto;
	private LocalModel local;
	private Stock stock;
	
	public LoteModel() {

	}

	public LoteModel(long idLote, Date fechaIngreso, int cantidadIngreso, int cantidadActual, boolean activo, ProductoModel producto,
			LocalModel local, Stock stock) {
		super();
		this.idLote = idLote;
		this.fechaIngreso = fechaIngreso;
		this.cantidadIngreso = cantidadIngreso;
		this.cantidadActual = cantidadActual;
		this.activo = activo;
		this.producto = producto;
		this.local = local;
		this.stock = stock;
	}

	public long getIdLote() {
		return idLote;
	}

	protected void setIdLote(long idLote) {
		this.idLote = idLote;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
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

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	

}