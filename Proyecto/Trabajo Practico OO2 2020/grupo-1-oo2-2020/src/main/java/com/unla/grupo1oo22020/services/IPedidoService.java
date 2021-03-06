package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.models.ClienteModel;
import com.unla.grupo1oo22020.models.VentaModel;

public interface IPedidoService {

	public List<Pedido> getAll();

	public List<PedidoModel> getAlls();

	public PedidoModel insert(PedidoModel pedidoModel);

	public PedidoModel update(PedidoModel pedidoModel);

	public boolean remove(long idPedido);

	public PedidoModel findByIdPedido(long idPedido);

	public List<Lote> getActiveLotes(PedidoModel pedidoModel);

	public int calcularStock(PedidoModel pedidoModel);

	public boolean validarConsumo(PedidoModel pedidoModel);

	public void consumoStock(PedidoModel pedidoModel);

	public List<LocalModel> LocalesConStock();

	public ProductoModel getProducto();

	public int getCantidad();

	public LocalModel getLocal();

	public EmpleadoModel getEmpleado();

	public List<EmpleadoModel> getEmpleadosColaboradores();

	void setAttributes(PedidoModel pedidoModel);

	public ClienteModel getCliente();

	public void setDetalleVenta(VentaModel ventaModel);

	public ProductoModel getProductoSS();

	public int getCantidadSS();

	public LocalModel getLocalSS();

	public EmpleadoModel getEmpleadoSS();

	public PedidoModel getPedidoSS();
}