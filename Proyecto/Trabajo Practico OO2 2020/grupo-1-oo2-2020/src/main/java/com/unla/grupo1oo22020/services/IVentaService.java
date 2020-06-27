package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Venta;
import com.unla.grupo1oo22020.models.VentaModel;

public interface IVentaService {

	public List<Venta> getAll();

	public List<VentaModel> getAlls();

	public List<VentaModel> findByEmpleado(long idPersona);

	public VentaModel findByIdVenta(long idVenta);

	public VentaModel insert(VentaModel ventaModel);

	public void setAttributes(VentaModel ventaModel);

	public VentaModel update(VentaModel ventaModel);

}
