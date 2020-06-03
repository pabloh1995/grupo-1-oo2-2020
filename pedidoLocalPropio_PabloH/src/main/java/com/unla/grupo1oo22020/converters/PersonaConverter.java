package com.unla.grupo1oo22020.converters;

import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.Persona;
import com.unla.grupo1oo22020.models.PersonaModel;

@Component("personaConverter")
public class PersonaConverter {

	public PersonaModel entityToModel(Persona persona) {
		return new PersonaModel(persona.getIdPersona(), persona.getDni(), persona.getApellido(), persona.getNombre(),
				persona.getFechaNacimiento());
	}

	public Persona modelToEntity(PersonaModel personaModel) {
		return new Persona(personaModel.getIdPersona(), personaModel.getDni(), personaModel.getApellido(), personaModel.getNombre(),
				personaModel.getFechaNacimiento());
	}
}