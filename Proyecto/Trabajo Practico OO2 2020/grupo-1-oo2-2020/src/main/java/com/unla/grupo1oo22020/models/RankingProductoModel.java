package com.unla.grupo1oo22020.models;

public class RankingProductoModel {
	private long idProducto;
	private ProductoModel producto;
	private int cantidad;

	public RankingProductoModel() {

	}

	public RankingProductoModel(ProductoModel producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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

}