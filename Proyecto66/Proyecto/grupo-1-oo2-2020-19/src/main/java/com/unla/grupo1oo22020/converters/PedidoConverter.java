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
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;

	
	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel(pedido.getIdPedido(),pedido.getFechaPedido(), productoConverter.entityToModel(pedido.getProducto()), 
				pedido.getCantidad(), pedido.getSubtotal() ,localConverter.entityToModel(pedido.getLocal()), 
				empleadoConverter.entityToModel(pedido.getVendedor()), empleadoConverter.entityToModel(pedido.getColaborador()),
				clienteConverter.entityToModel(pedido.getCliente()), pedido.isAceptado());
	}
	
	public Pedido modelToEntity(PedidoModel pedidoModel) {
		return new Pedido(pedidoModel.getIdPedido(), pedidoModel.getFechaPedido(), productoConverter.modelToEntity(pedidoModel.getProducto()),
				pedidoModel.getCantidad(), pedidoModel.getSubtotal(), localConverter.modelToEntity(pedidoModel.getLocal()), 
				empleadoConverter.modelToEntity(pedidoModel.getVendedor()), empleadoConverter.modelToEntity(pedidoModel.getColaborador()), 
				clienteConverter.modelToEntity(pedidoModel.getCliente()), pedidoModel.isAceptado());
	}

}