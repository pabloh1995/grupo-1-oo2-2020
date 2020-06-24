package com.unla.grupo1oo22020.services;

import java.util.List;


import com.unla.grupo1oo22020.entities.Empleado;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.models.SueldosModel;


public interface IEmpleadoService {
	
	public List<Empleado> getAll();
	
	public List<EmpleadoModel> getAlls();
	
	public List<EmpleadoModel> getAlle();
	
	public EmpleadoModel findByIdPersona(long idPersona);
	
	public EmpleadoModel findByNombre(String nombre);
	
	public EmpleadoModel insert(EmpleadoModel empleadoModel);
	
	public EmpleadoModel update(EmpleadoModel empleadoModel);
	
	public boolean remove(long idPersona);
	
	public List<EmpleadoModel> findByGerente(boolean gerente);

	public List<EmpleadoModel> findByIdLocal(long idLocal);
	
	public EmpleadoModel findByIdLocales(long idLocal);
	
	public List<EmpleadoModel> findByIdLocalNoGerente(long idLocal);

	public List<SueldosModel> SueldoBruto();

}