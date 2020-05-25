package com.unla.grupo1oo22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.ProductoConverter;
import com.unla.grupo1oo22020.entities.Producto;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.repositories.IProductoRepository;
import com.unla.grupo1oo22020.services.IProductoService;


@Service("productoService")
public class ProductoService implements IProductoService{
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public ProductoModel insertOrUpdate(ProductoModel productoModel) {
		Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
		return productoConverter.entityToModel(producto);
	}
	
	@Override
	public ProductoModel findByIdProducto(long idProducto) {
		return productoConverter.entityToModel(productoRepository.findByIdProducto(idProducto));
	}
 
	@Override
	public ProductoModel findByNombre(String nombre) {
		return productoConverter.entityToModel(productoRepository.findByNombre(nombre));
	}
	
	@Override
	public boolean remove(long idProducto) {
		try {
			productoRepository.deleteById(idProducto);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	

}
