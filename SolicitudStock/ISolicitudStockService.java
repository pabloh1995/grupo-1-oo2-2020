package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.SolicitudStock;
import com.unla.grupo1oo22020.models.SolicitudStockModel;

public interface ISolicitudStockService {

	List<SolicitudStock> getAll();
	
	List<SolicitudStockModel> getAlls();

	SolicitudStockModel findByIdSolicitudStock(long idSolicitudStock);

	SolicitudStockModel insert(SolicitudStockModel solicitudStockModel);

	SolicitudStockModel update(SolicitudStockModel solicitudStockModel);

	boolean remove(long idSolicitudStock);

}
