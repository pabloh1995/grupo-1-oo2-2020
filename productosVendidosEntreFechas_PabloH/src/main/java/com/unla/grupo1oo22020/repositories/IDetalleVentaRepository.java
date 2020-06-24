package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.DetalleVenta;

	@Repository("detalleVentaRepository")
	public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Serializable> {
		
		public abstract DetalleVenta findByIdDetalleVenta(long idDetalleVenta);
		
		 @Query("SELECT d FROM DetalleVenta d JOIN FETCH d.venta v WHERE v.idVenta = (:idVenta)")
		    public abstract List<DetalleVenta> findByIdVenta(long idVenta);

	}

