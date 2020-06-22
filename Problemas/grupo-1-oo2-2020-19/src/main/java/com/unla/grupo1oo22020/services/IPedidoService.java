package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.LoteModel;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.models.RankingProductoModel;


public interface IPedidoService {
	
	public  List<Pedido> getAll();
	   
    public  List<PedidoModel> getAlls();
	
	public  PedidoModel insert(PedidoModel pedidoModel);
	
	public  PedidoModel update(PedidoModel pedidoModel);
	
	public  boolean remove(long idPedido);

	public PedidoModel findByIdPedido(long idPedido);
	
	public List<LoteModel> getActiveLotes(LocalModel localModel, ProductoModel productoModel);
	
	public int calcularStock(LocalModel localModel, ProductoModel productoModel);
	
	public boolean validarConsumo(LocalModel localModel, ProductoModel productoModel, int cantidad);
	
	public void consumoStock(LocalModel localModel, ProductoModel productoModel, int cantidad);
	
	public List<RankingProductoModel> rankingproductosvendidos();

	public List<LocalModel> LocalesConStock();
	
	public ProductoModel getProducto();
	
	public int getCantidad();
	
	public LocalModel getLocal();
	
	public List<EmpleadoModel> getEmpleadosColaboradores();

	void setAttributes(PedidoModel pedidoModel);

	
}