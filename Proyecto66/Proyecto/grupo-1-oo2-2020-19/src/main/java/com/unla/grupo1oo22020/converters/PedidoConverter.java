package com.unla.grupo1oo22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.models.PedidoModel;


@Component("pedidoConverter")
public class PedidoConverter {
	
	@Autowired()
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired()
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	
	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel(pedido.getIdPedido(),pedido.getFechaPedido(), productoConverter.entityToModel(pedido.getProducto()), pedido.getCantidad(), localConverter.entityToModel(pedido.getLocal()));
	}
	
	public Pedido modelToEntity(PedidoModel pedidoModel) {
		return new Pedido(pedidoModel.getIdPedido(), pedidoModel.getFechaPedido(), productoConverter.modelToEntity(pedidoModel.getProducto()), pedidoModel.getCantidad(), localConverter.modelToEntity(pedidoModel.getLocal()));
	}

}