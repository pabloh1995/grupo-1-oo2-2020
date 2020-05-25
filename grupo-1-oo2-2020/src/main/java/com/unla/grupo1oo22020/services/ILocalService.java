package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Local;
import com.unla.grupo1oo22020.models.LocalModel;


public interface ILocalService {

	public List<Local> getAll();
	
	public LocalModel findByIdLocal(long idLocal);
	
	public LocalModel insertOrUpdate(LocalModel localModel);
	
	public boolean remove(long idLocal);
	
}
