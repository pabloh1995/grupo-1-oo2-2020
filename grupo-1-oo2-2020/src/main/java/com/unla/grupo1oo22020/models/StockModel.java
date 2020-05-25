package com.unla.grupo1oo22020.models;

import java.util.ArrayList;
import java.util.List;


public class StockModel {
	private long idStock;
	private List<LoteModel> lotes = new ArrayList<LoteModel>();
	private LocalModel local;
	private int cantidad;
	
	
	public StockModel() {

	}

	public StockModel(long idStock, List<LoteModel> lotes, LocalModel local, int cantidad) {
		super();
		this.idStock = idStock;
		this.lotes = lotes;
		this.local = local;
		this.cantidad = cantidad;
	}

	public StockModel(long idStock, LocalModel local) {
		super();
		this.idStock = idStock;
		this.local = local;
	}

	public long getIdStock() {
		return idStock;
	}

	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}

	public List<LoteModel> getLotes() {
		return lotes;
	}

	public void setLotes(List<LoteModel> lotes) {
		this.lotes = lotes;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	
	

	
	
	
}
