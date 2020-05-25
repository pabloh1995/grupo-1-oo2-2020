package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Stock;
import com.unla.grupo1oo22020.models.StockModel;


public interface IStockService {

	public List<Stock> getAll();
	
	public StockModel insertOrUpdate(StockModel stockModel);
	
	public StockModel findByIdStock(long idStock);
	
	public boolean remove(long idStock);
	
}