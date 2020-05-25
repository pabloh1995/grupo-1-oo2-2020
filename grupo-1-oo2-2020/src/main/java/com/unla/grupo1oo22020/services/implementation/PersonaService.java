package com.unla.grupo1oo22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.PersonaConverter;
import com.unla.grupo1oo22020.entities.Persona;
import com.unla.grupo1oo22020.models.PersonaModel;
import com.unla.grupo1oo22020.repositories.IPersonaRepository;
import com.unla.grupo1oo22020.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService {

	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Override
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}

	@Override
	public PersonaModel insertOrUpdate(PersonaModel personaModel) {
		Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModel));
		return personaConverter.entityToModel(persona);
	}

	@Override
	public boolean remove(long idPersona) {
		try {
			personaRepository.deleteById(idPersona);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public PersonaModel findByIdPersona(long idPersona) {
		return personaConverter.entityToModel(personaRepository.findByIdPersona(idPersona));
	}

	@Override
	public PersonaModel findByNombre(String nombre) {
		return personaConverter.entityToModel(personaRepository.findByNombre(nombre));
	}
	


}