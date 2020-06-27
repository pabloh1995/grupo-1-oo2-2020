package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.DetalleVenta;
import com.unla.grupo1oo22020.models.DetalleVentaModel;
import com.unla.grupo1oo22020.models.RankingProductoModel;
import com.unla.grupo1oo22020.models.VentaModel;

public interface IDetalleVentaService {

	public List<DetalleVenta> getAll();

	public List<DetalleVentaModel> getAlls();

	public List<DetalleVentaModel> findByIdVenta(long idVenta);

	public DetalleVentaModel findByIdDetalleVenta(long idDetalleVenta);

	public DetalleVentaModel insert(DetalleVentaModel detalleVentaModel);

	public DetalleVentaModel update(DetalleVentaModel detalleVentaModel);

	public boolean remove(long idDetalleVenta);

	public void setAttribues(VentaModel ventaModel);

	float getTotal(VentaModel ventaModel);

	public List<RankingProductoModel> rankingproductosvendidos();

}
