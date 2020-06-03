package com.unla.grupo1oo22020.converters;

import org.springframework.stereotype.Component;


import com.unla.grupo1oo22020.entities.Cliente;
import com.unla.grupo1oo22020.models.ClienteModel;

@Component("clienteConverter")
public class ClienteConverter {
	
	public ClienteModel entityToModel(Cliente cliente) {
		return new ClienteModel(cliente.getIdPersona(), cliente.getDni(), cliente.getApellido(), cliente.getNombre(), 
				cliente.getFechaNacimiento(), cliente.getEmail());
	}
	
	public Cliente modelToEntity(ClienteModel clienteModel) {
		return new Cliente(clienteModel.getIdPersona(), clienteModel.getDni(), clienteModel.getApellido(), clienteModel.getNombre(),
				clienteModel.getFechaNacimiento(), clienteModel.getEmail());
	}

}
