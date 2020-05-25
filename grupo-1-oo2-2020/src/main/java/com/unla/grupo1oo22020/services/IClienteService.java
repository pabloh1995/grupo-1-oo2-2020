package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Cliente;
import com.unla.grupo1oo22020.models.ClienteModel;

public interface IClienteService {
	
	public List<Cliente> getAll();
	
	public ClienteModel findByIdPersona(long idPersona);
	
	public ClienteModel findByNombre(String nombre);
	
	public ClienteModel insertOrUpdate(ClienteModel empleadoModel);
	
	public boolean remove(long idPersona);


}
