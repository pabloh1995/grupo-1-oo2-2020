package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.Lote;


@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Serializable>{

	public abstract Lote findByIdLote(long idLote);
	
	//Consulta que trae una lista de lotes con ese id de local
	@Query("SELECT l FROM Lote l JOIN FETCH l.local loc WHERE loc.idLocal = (:idLocal)")
	public abstract List<Lote> findByIdLocal(long idLocal);
	
	
	//Consulta que trae una lista de lotes que tengan ese id de producto
	@Query("SELECT l FROM Lote l JOIN FETCH l.producto p WHERE p.idProducto = (:idProducto)")
	public abstract List<Lote> findByIdProducto(long idProducto);
	
}