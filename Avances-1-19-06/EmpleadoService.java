package com.unla.grupo1oo22020.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.EmpleadoConverter;
import com.unla.grupo1oo22020.entities.Empleado;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.repositories.IEmpleadoRepository;
import com.unla.grupo1oo22020.services.IEmpleadoService;


@Service("empleadoService")
public class EmpleadoService implements IEmpleadoService{

	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Override
	public List<Empleado> getAll() {
		return empleadoRepository.findAll();
	}

	@Override
	public EmpleadoModel findByIdPersona(long idPersona) {
		return empleadoConverter.entityToModel(empleadoRepository.findByIdPersona(idPersona));
	}

	@Override
	public EmpleadoModel findByNombre(String nombre) {
		return empleadoConverter.entityToModel(empleadoRepository.findByNombre(nombre));
	}

    @Override
    public EmpleadoModel insert(EmpleadoModel empleadoModel) {
        Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
        return empleadoConverter.entityToModel(empleado);
    }

    @Override
    public EmpleadoModel update(EmpleadoModel empleadoModel) {
    	Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
        return empleadoConverter.entityToModel(empleado);
    }

	@Override
	public boolean remove(long idPersona) {

		try {
			empleadoRepository.deleteById(idPersona);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	@Override
	public List<EmpleadoModel> getAlls(){
		List<EmpleadoModel> em = new ArrayList<EmpleadoModel>();
		for (Empleado empleado : empleadoRepository.findAll()) {
			em.add(empleadoConverter.entityToModel(empleado));
		}
		return em;
	}
	
	@Override
	public List<EmpleadoModel> getAlle(){
		List<EmpleadoModel> em = new ArrayList<EmpleadoModel>();
		for (Empleado empleado : empleadoRepository.findAll()) {
			if(!empleado.isGerente())
			em.add(empleadoConverter.entityToModel(empleado));
		}
		return em;
	}

	@Override
	public List<EmpleadoModel> findByGerente(boolean gerente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoModel> findByIdLocal(long idLocal){
		List<EmpleadoModel> em = new ArrayList<EmpleadoModel>();
		for (Empleado empleado : empleadoRepository.findByIdLocal(idLocal)) {
			em.add(empleadoConverter.entityToModel(empleado));
		}
		return em;
	}
	
	@Override
	public  EmpleadoModel findByIdLocales(long idLocal){
		EmpleadoModel emp=null;
		for (Empleado empleado : empleadoRepository.findByIdLocal(idLocal)) {
			if(!empleado.isGerente()) {
			emp=empleadoConverter.entityToModel(empleado);
			}
		}
		return emp;
	}
	
	@Override
	public List<EmpleadoModel> findByIdLocalNoGerente(long idLocal){
		List<EmpleadoModel> empl = new ArrayList<EmpleadoModel>();
		for (Empleado empleado : empleadoRepository.findByIdLocal(idLocal)) {
			if(empleado.isGerente()==false) {
			empl.add(empleadoConverter.entityToModel(empleado));
		}}
		return empl;
	}
}