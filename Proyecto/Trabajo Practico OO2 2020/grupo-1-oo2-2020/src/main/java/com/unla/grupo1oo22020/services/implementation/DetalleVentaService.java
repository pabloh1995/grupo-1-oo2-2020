package com.unla.grupo1oo22020.services.implementation;

import java.util.List;

import com.unla.grupo1oo22020.entities.DetalleVenta;
import com.unla.grupo1oo22020.entities.Producto;
import com.unla.grupo1oo22020.models.DetalleVentaModel;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.models.RankingProductoModel;
import com.unla.grupo1oo22020.models.VentaModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.DetalleVentaConverter;
import com.unla.grupo1oo22020.converters.ProductoConverter;
import com.unla.grupo1oo22020.repositories.IDetalleVentaRepository;
import com.unla.grupo1oo22020.services.IDetalleVentaService;
import com.unla.grupo1oo22020.services.IPedidoService;
import com.unla.grupo1oo22020.services.IEmpleadoService;

@Service("detalleVentaService")
public class DetalleVentaService implements IDetalleVentaService {

	@Autowired
	@Qualifier("detalleVentaRepository")
	private IDetalleVentaRepository detalleVentaRepository;

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;

	@Autowired
	@Qualifier("detalleVentaConverter")
	private DetalleVentaConverter detalleVentaConverter;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public List<DetalleVenta> getAll() {
		return detalleVentaRepository.findAll();
	}

	@Override
	public List<DetalleVentaModel> getAlls() {
		List<DetalleVentaModel> dv = new ArrayList<DetalleVentaModel>();
		for (DetalleVenta detalleVenta : detalleVentaRepository.findAll()) {
			dv.add(detalleVentaConverter.entityToModel(detalleVenta));
		}
		return dv;
	}

	@Override
	public List<DetalleVentaModel> findByIdVenta(long idVenta) {
		List<DetalleVentaModel> dv = new ArrayList<DetalleVentaModel>();
		for (DetalleVenta detalleVenta : detalleVentaRepository.findAll()) {
			if (detalleVenta.getVenta().getIdVenta() == idVenta) {
				dv.add(detalleVentaConverter.entityToModel(detalleVenta));
			}
		}
		return dv;

	}

	@Override
	public DetalleVentaModel findByIdDetalleVenta(long idDetalleVenta) {
		return detalleVentaConverter.entityToModel(detalleVentaRepository.findByIdDetalleVenta(idDetalleVenta));
	}

	@Override
	public DetalleVentaModel insert(DetalleVentaModel detalleVentaModel) {
		DetalleVenta detalleVenta = detalleVentaRepository.save(detalleVentaConverter.modelToEntity(detalleVentaModel));
		return detalleVentaConverter.entityToModel(detalleVenta);
	}

	@Override
	public DetalleVentaModel update(DetalleVentaModel detalleVentaModel) {
		DetalleVenta detalleVenta = detalleVentaRepository.save(detalleVentaConverter.modelToEntity(detalleVentaModel));
		return detalleVentaConverter.entityToModel(detalleVenta);
	}

	@Override
	public boolean remove(long idDetalleVenta) {
		try {
			detalleVentaRepository.deleteById(idDetalleVenta);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void setAttribues(VentaModel ventaModel) {
		pedidoService.setDetalleVenta(ventaModel);
	}

	@Override
	public float getTotal(VentaModel ventaModel) {
		float total = 0;
		int i = 0;
		List<DetalleVentaModel> detalleVenta = new ArrayList<DetalleVentaModel>();
		detalleVenta = this.findByIdVenta(ventaModel.getIdVenta());
		while (i < detalleVenta.size()) {
			total = total + detalleVenta.get(i).getPrecioSubTotal();
			i++;
		}
		EmpleadoModel e = new EmpleadoModel();
		e = ventaModel.getEmpleado();
		e.setComision(e.getComision() + total * 0.05f);
		empleadoService.update(e);
		return total;
	}

	public List<DetalleVenta> ventasPorProducto(Producto p) {
		List<DetalleVenta> detventas = this.getAll();
		List<DetalleVenta> auxiliar = new ArrayList<>();

		for (DetalleVenta dven : detventas) {
			if (dven.getProducto().getIdProducto() == p.getIdProducto()) {
				auxiliar.add(dven);
			}
		}
		return auxiliar;
	}

	@Override
	public List<RankingProductoModel> rankingproductosvendidos() {
		RankingProductoModel prodAuxiliar = new RankingProductoModel();
		List<RankingProductoModel> productosList = new ArrayList<>();
		List<Producto> productos = productoService.getAll();
		List<DetalleVenta> auxiliar = new ArrayList<>();

		int cantidadAux = 0;

		for (Producto p : productos) {
			prodAuxiliar = new RankingProductoModel();
			cantidadAux = 0;
			auxiliar = this.ventasPorProducto(p);

			for (DetalleVenta dven : auxiliar) {
				cantidadAux += dven.getCantidad();

			}
			prodAuxiliar.setProducto(productoConverter.entityToModel(p));
			prodAuxiliar.setCantidad(cantidadAux);
			productosList.add(prodAuxiliar);
		}

		Collections.sort(productosList, new Comparator<RankingProductoModel>() {
			public int compare(RankingProductoModel o1, RankingProductoModel o2) {
				if (o1.getCantidad() == o2.getCantidad()) {
					return 0;
				} else if (o1.getCantidad() > o2.getCantidad()) {
					return -1;
				}
				return 1;
			}
		});

		return productosList;
	}

}
