package com.unla.grupo1oo22020.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.LocalConverter;
import com.unla.grupo1oo22020.converters.ProductoConverter;
import com.unla.grupo1oo22020.converters.VentaConverter;
import com.unla.grupo1oo22020.entities.DetalleVenta;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.entities.Venta;
import com.unla.grupo1oo22020.models.DetalleVentaModel;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.models.VentaModel;
import com.unla.grupo1oo22020.repositories.IVentaRepository;
import com.unla.grupo1oo22020.services.IVentaService;
import com.unla.grupo1oo22020.services.IClienteService;
import com.unla.grupo1oo22020.services.IEmpleadoService;


@Service("ventaService")
public class VentaService implements IVentaService {
	@Autowired
	@Qualifier("ventaRepository")
	private IVentaRepository ventaRepository;

	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;

	@Autowired
	@Qualifier("empleadoService")
	private EmpleadoService empleadoService;

	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;

	
	@Autowired
	@Qualifier("localService")
	private LocalService localService;
	
	@Autowired
	@Qualifier("pedidoService")
	private PedidoService pedidoService;
	
	
	@Override
	public List<Venta> getAll() {

		return ventaRepository.findAll();
	}

	@Override
	public List<VentaModel> getAlls(){
		List<VentaModel> v = new ArrayList<VentaModel>();
		for (Venta venta : ventaRepository.findAll()) {
			v.add(ventaConverter.entityToModel(venta));
		}
		return v;
	}
	
	@Override
	public List<VentaModel> findByEmpleado(long idPersona){
		List<VentaModel> v = new ArrayList<VentaModel>();
		for (Venta venta : ventaRepository.findAll()) {
			if(venta.getEmpleado().getIdPersona() == idPersona) {
			v.add(ventaConverter.entityToModel(venta));
		}}
		return v;
	}
	
	
	@Override
	public VentaModel insert(VentaModel ventaModel) {
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}
	
	@Override
	public VentaModel update(VentaModel ventaModel) {
		
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}
	
	
	@Override
	public VentaModel findByIdVenta(long idVenta) {
		return ventaConverter.entityToModel(ventaRepository.findByIdVenta(idVenta));
	}
	
	@Override
	public void setAttributes(VentaModel ventaModel) {
		ventaModel.setCliente(clienteService.findByIdPersona(pedidoService.getCliente().getIdPersona()));
		ventaModel.setEmpleado(empleadoService.findByIdPersona(pedidoService.getEmpleado().getIdPersona()));
		ventaModel.setLocal(localService.findByIdLocal(empleadoService.findByIdPersona(pedidoService.getEmpleado().getIdPersona()).getLocal().getIdLocal()));
	}

}
