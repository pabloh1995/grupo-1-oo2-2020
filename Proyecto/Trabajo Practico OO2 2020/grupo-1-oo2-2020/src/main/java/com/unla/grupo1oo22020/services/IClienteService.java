package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Cliente;
import com.unla.grupo1oo22020.models.ClienteModel;

public interface IClienteService {

	public List<Cliente> getAll();

	public List<ClienteModel> getAlls();

	public ClienteModel findByIdPersona(long idPersona);

	public ClienteModel findByNombre(String nombre);

	public ClienteModel insert(ClienteModel clienteModel);

	public ClienteModel update(ClienteModel clienteModel);

	public boolean remove(long idPersona);

}
