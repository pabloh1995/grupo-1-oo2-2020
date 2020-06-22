package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Local;
import com.unla.grupo1oo22020.models.LocalModel;


public interface ILocalService {

	public List<Local> getAll();
	
	public List<LocalModel> getAlls();
	
	public LocalModel findByIdLocal(long idLocal);
	
	LocalModel insert(LocalModel localModel);
	
	LocalModel update(LocalModel localModel);
	
	public boolean remove(long idLocal);
	
}
