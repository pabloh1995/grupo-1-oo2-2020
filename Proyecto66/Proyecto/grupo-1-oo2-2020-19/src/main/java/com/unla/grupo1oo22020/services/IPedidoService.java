package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.models.PedidoModel;


public interface IPedidoService {
	
	public  List<Pedido> getAll();
	   
    public  List<PedidoModel> getAlls();
	
	public  PedidoModel insert(PedidoModel pedidoModel);
	
	public  PedidoModel update(PedidoModel pedidoModel);
	
	public  boolean remove(long idPedido);

	public PedidoModel findByIdPedido(long idPedido);
	
	public List<Lote> getActiveLotes(PedidoModel pedidoModel);
	
	public int calcularStock(PedidoModel pedidoModel);
	
	public boolean validarConsumo(PedidoModel pedidoModel);
	
	public void consumoStock(PedidoModel pedidoModel );

}
