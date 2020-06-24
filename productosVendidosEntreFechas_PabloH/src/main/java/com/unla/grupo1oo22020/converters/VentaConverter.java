package com.unla.grupo1oo22020.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.entities.Venta;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.models.VentaModel;


@Component("ventaConverter")
public class VentaConverter {
	
	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	
	public VentaModel entityToModel(Venta venta) {
		return new VentaModel(venta.getIdVenta(), venta.getFechaVenta(), empleadoConverter.entityToModel(venta.getEmpleado()), clienteConverter.entityToModel(venta.getCliente()), localConverter.entityToModel(venta.getLocal()), venta.getTotal());
	}

	public Venta modelToEntity(VentaModel ventaModel) {
		return new Venta(ventaModel.getIdVenta(), ventaModel.getFechaVenta(), empleadoConverter.modelToEntity(ventaModel.getEmpleado()), clienteConverter.modelToEntity(ventaModel.getCliente()), localConverter.modelToEntity(ventaModel.getLocal()), ventaModel.getTotal());
	}
	
	
}
