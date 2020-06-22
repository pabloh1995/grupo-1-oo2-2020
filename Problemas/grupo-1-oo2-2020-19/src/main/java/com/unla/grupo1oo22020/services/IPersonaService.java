package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Persona;
import com.unla.grupo1oo22020.models.PersonaModel;

public interface IPersonaService {
	
	public List<Persona> getAll();


	public PersonaModel findByIdPersona(long idPersona);
	
	public PersonaModel findByNombre(String nombre);
	
	public PersonaModel insertOrUpdate(PersonaModel personaModel);
	
	public boolean remove(long idPersona);
}
