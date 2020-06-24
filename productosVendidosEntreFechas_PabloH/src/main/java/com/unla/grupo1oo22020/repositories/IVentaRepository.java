package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.Venta;

@Repository("ventaRepository")
public interface IVentaRepository extends JpaRepository<Venta, Serializable> {
	
	public abstract Venta findByIdVenta(long idVenta);
	
	@Query("SELECT v FROM Venta v JOIN FETCH v.empleado e WHERE e.idPersona = (:idPersona)")
    public abstract List<Venta> findByIdEmpleado(long idPersona);
    
}
