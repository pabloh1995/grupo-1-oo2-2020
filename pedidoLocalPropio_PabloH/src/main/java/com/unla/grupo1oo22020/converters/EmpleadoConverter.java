package com.unla.grupo1oo22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.Empleado;
import com.unla.grupo1oo22020.models.EmpleadoModel;

@Component("empleadoConverter")
public class EmpleadoConverter {
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	public EmpleadoModel entityToModel(Empleado empleado) {
		return new EmpleadoModel(empleado.getIdPersona(), empleado.getDni(), empleado.getApellido(), empleado.getNombre(), 
				empleado.getFechaNacimiento(), empleado.getSueldoBasico(), empleado.getComision(), empleado.getHorarioTrabajoE(), 
				empleado.getHorarioTrabajoS(), empleado.isGerente(), localConverter.entityToModel(empleado.getLocal()));
	}
	
	public Empleado modelToEntity(EmpleadoModel empleadoModel) {
		return new Empleado(empleadoModel.getIdPersona(), empleadoModel.getDni(), empleadoModel.getApellido(), 
				empleadoModel.getNombre(), empleadoModel.getFechaNacimiento(), empleadoModel.getSueldoBasico(),
				empleadoModel.getComision(), empleadoModel.getHorarioTrabajoE(), empleadoModel.getHorarioTrabajoS(), 
				empleadoModel.isGerente(), localConverter.modelToEntity(empleadoModel.getLocal()));
	}

}
