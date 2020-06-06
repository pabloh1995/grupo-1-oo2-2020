package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable>{
	public abstract Producto findByIdProducto(long idProducto);
	
	public abstract Producto findByNombre (String nombre);

}
