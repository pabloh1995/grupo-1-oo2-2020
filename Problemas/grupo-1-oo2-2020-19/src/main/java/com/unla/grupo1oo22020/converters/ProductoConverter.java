package com.unla.grupo1oo22020.converters;

import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.Producto;
import com.unla.grupo1oo22020.models.ProductoModel;


@Component("productoConverter")
public class ProductoConverter {
	
	public ProductoModel entityToModel(Producto producto) {
		return new ProductoModel(producto.getIdProducto(), producto.getNombre(), producto.getDescripcion(), producto.getPrecioUnitario(),producto.getFechaAlta());
	}
	
	public Producto modelToEntity(ProductoModel productoModel) {
		return new Producto(productoModel.getIdProducto(), productoModel.getNombre(), productoModel.getDescripcion(),productoModel.getPrecioUnitario(),productoModel.getFechaAlta());
	}

}
