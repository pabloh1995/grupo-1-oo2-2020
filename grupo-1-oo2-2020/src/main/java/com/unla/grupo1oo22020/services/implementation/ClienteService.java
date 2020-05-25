package com.unla.grupo1oo22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.ClienteConverter;
import com.unla.grupo1oo22020.entities.Cliente;
import com.unla.grupo1oo22020.models.ClienteModel;
import com.unla.grupo1oo22020.repositories.IClienteRepository;
import com.unla.grupo1oo22020.services.IClienteService;

@Service("clienteService")
public class ClienteService implements IClienteService {

	@Autowired
	@Qualifier("clienteRepository")
	private IClienteRepository clienteRepository;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	@Override
	public ClienteModel insertOrUpdate(ClienteModel clienteModel) {
		Cliente cliente = clienteRepository.save(clienteConverter.modelToEntity(clienteModel));
		return clienteConverter.entityToModel(cliente);
	}

	@Override
	public boolean remove(long idPersona) {
		try {
			clienteRepository.deleteById(idPersona);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public ClienteModel findByIdPersona(long idPersona) {
		return clienteConverter.entityToModel(clienteRepository.findByIdPersona(idPersona));
	}

	@Override
	public ClienteModel findByNombre(String nombre) {
		return null;
	}

	
	


}