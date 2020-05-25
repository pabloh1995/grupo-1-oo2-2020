package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Producto;
import com.unla.grupo1oo22020.models.ProductoModel;


public interface IProductoService {

	public abstract List<Producto> getAll();

	public ProductoModel insertOrUpdate(ProductoModel productoModel);

	public ProductoModel findByIdProducto(long idProducto);
	
	public ProductoModel findByNombre(String nombre);

	public boolean remove(long idProducto);
}
