package com.unla.grupo1oo22020.services;

import java.util.List;


import com.unla.grupo1oo22020.entities.Empleado;
import com.unla.grupo1oo22020.models.EmpleadoModel;


public interface IEmpleadoService {
	
	public List<Empleado> getAll();
	
	public EmpleadoModel findByIdPersona(long idPersona);
	
	public EmpleadoModel findByNombre(String nombre);
	
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel);
	
	public boolean remove(long idPersona);
	
	public List<EmpleadoModel> findByGerente(boolean gerente);


}
