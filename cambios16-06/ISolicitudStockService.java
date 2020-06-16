package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.entities.SolicitudStock;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.SolicitudStockModel;


public interface ISolicitudStockService {

	List<SolicitudStock> getAll();
	
	List<SolicitudStockModel> getAlls();

	SolicitudStockModel findByIdSolicitudStock(long idSolicitudStock);

	SolicitudStockModel insert(SolicitudStockModel solicitudStockModel);
	
	public void setAttributes(SolicitudStockModel solicitudStockModel);
	
	public void setAttributes(SolicitudStockModel solicitudStockModel, LocalModel localModel);

	SolicitudStockModel update(SolicitudStockModel solicitudStockModel);
	
	public List<Lote> getActiveLotes(SolicitudStockModel solicitudStockModel);
	
	public int calcularStock(SolicitudStockModel solicitudStockModel);
	
	public boolean validarConsumo(SolicitudStockModel solicitudStockModel);
	
	public void consumoStock(SolicitudStockModel solicitudStockModel );

	public List<LocalModel> LocalesConStock(SolicitudStockModel solicitudStockModel);
	
	boolean remove(long idSolicitudStock);
	

}
