package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.unla.grupo1oo22020.entities.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Serializable> {
	
	public abstract Empleado findByIdPersona(long idPersona);
	
	public abstract Empleado findByNombre(String nombre);

	public abstract Object findByGerente(boolean gerente);
	
	 @Query("SELECT e FROM Empleado e JOIN FETCH e.local l WHERE l.idLocal = (:idLocal)")
	    public abstract List<Empleado> findByIdLocal(long idLocal);

}
