package com.unla.grupo1oo22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.DetalleVenta;
import com.unla.grupo1oo22020.models.DetalleVentaModel;

@Component("detalleVentaConverter")
public class DetalleVentaConverter {

	@Autowired
	@Qualifier("detalleVentaConverter")
	private DetalleVentaConverter detalleVentaConverter;

	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	public DetalleVentaModel entityToModel(DetalleVenta detalleVenta) {
		return new DetalleVentaModel(detalleVenta.getIdDetalleVenta(), detalleVenta.getFechaDetalle(),
				productoConverter.entityToModel(detalleVenta.getProducto()), detalleVenta.getCantidad(),
				detalleVenta.getPrecioSubTotal(), ventaConverter.entityToModel(detalleVenta.getVenta()));
	}

	public DetalleVenta modelToEntity(DetalleVentaModel detalleVentaModel) {
		return new DetalleVenta(detalleVentaModel.getIdDetalleVenta(), detalleVentaModel.getFechaDetalle(),
				productoConverter.modelToEntity(detalleVentaModel.getProducto()), detalleVentaModel.getCantidad(),
				detalleVentaModel.getPrecioSubTotal(), ventaConverter.modelToEntity(detalleVentaModel.getVenta()));
	}
}