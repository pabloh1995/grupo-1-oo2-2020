package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Local;
import com.unla.grupo1oo22020.models.LocalModel;


public interface ILocalService {

	public List<Local> getAll();
	
	public LocalModel findById(long id);
	
	public LocalModel insertOrUpdate(LocalModel localModel);
	
	public boolean remove(long id);

	public double calcularDistancia(Local local);
	
}
