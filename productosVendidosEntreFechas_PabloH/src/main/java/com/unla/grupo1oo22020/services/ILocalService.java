package com.unla.grupo1oo22020.services;

import java.time.LocalDate;
import java.util.List;

import com.unla.grupo1oo22020.entities.Local;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.ProductoModel;


public interface ILocalService {

	public List<Local> getAll();
	
	public List<LocalModel> getAlls();
	
	public LocalModel findByIdLocal(long idLocal);
	
	LocalModel insert(LocalModel localModel);
	
	LocalModel update(LocalModel localModel);
	
	public boolean remove(long idLocal);
	
	public List<ProductoModel> productosVendidosPorFechas(LocalModel local, LocalDate desde,LocalDate hasta);
	
}
