package com.unla.grupo1oo22020.models;

import java.time.LocalDate;

public class LoteModel {
	private long idLote;
	private LocalDate fechaIngreso;
	private int cantidadIngreso;
	private int cantidadActual;
	private boolean activo;
	private ProductoModel producto;
	private LocalModel local;
	
	public LoteModel() {
		super();
	}

	public LoteModel(long idLote, LocalDate fechaIngreso, int cantidadIngreso, int cantidadActual, boolean activo, ProductoModel producto,
			LocalModel local) {
		super();
		this.setIdLote(idLote);
		this.fechaIngreso = fechaIngreso;
		this.cantidadIngreso = cantidadIngreso;
		this.cantidadActual = cantidadActual;
		this.activo = activo;
		this.producto = producto;
		this.local = local;
	}

	public long getIdLote() {
		return idLote;
	}

	protected void setIdLote(long idLote) {
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


}
