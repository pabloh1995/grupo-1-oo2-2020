package com.unla.grupo1oo22020.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.SolicitudStockConverter;
import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.entities.SolicitudStock;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.LoteModel;
import com.unla.grupo1oo22020.models.SolicitudStockModel;
import com.unla.grupo1oo22020.repositories.ISolicitudStockRepository;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.IProductoService;
import com.unla.grupo1oo22020.services.ISolicitudStockService;
import com.unla.grupo1oo22020.services.IEmpleadoService;
import com.unla.grupo1oo22020.services.IPedidoService;

@Service("solicitudStockService")
public class SolicitudStockService implements ISolicitudStockService {

	@Autowired
	@Qualifier("solicitudStockRepository")
	private ISolicitudStockRepository solicitudStockRepository;

	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;

	@Override
	public List<SolicitudStock> getAll() {
		return solicitudStockRepository.findAll();
	}

	@Override
	public List<SolicitudStockModel> getAlls() {
		List<SolicitudStockModel> ssModel = new ArrayList<SolicitudStockModel>();
		for (SolicitudStock ss : solicitudStockRepository.findAll()) {
			ssModel.add(solicitudStockConverter.entityToModel(ss));
		}
		return ssModel;
	}

	@Override
	public SolicitudStockModel findByIdSolicitudStock(long idSolicitudStock) {
		return solicitudStockConverter.entityToModel(solicitudStockRepository.findByIdSolicitudStock(idSolicitudStock));
	}

	@Override
	public void setAttributes(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setPedido(pedidoService.findByIdPedido(pedidoService.getPedidoSS().getIdPedido()));
		solicitudStockModel.setLocal(localService.findByIdLocal(
				empleadoService.findByIdPersona(pedidoService.getEmpleadoSS().getIdPersona()).getLocal().getIdLocal()));
		solicitudStockModel
				.setProducto(productoService.findByIdProducto(pedidoService.getProductoSS().getIdProducto()));
		solicitudStockModel.setCantidad(pedidoService.getCantidadSS());
		solicitudStockModel.setEmpleado(empleadoService.findByIdPersona(pedidoService.getEmpleadoSS().getIdPersona()));
		solicitudStockModel.setLocal2(localService.findByIdLocal(solicitudStockModel.getLocal2().getIdLocal()));
	}

	@Override
	public void setAttributes(SolicitudStockModel solicitudStockModel, LocalModel localModel) {
		LocalModel locales = localService.findByIdLocal(localModel.getIdLocal());
		solicitudStockModel.setPedido(pedidoService.findByIdPedido(pedidoService.getPedidoSS().getIdPedido()));
		solicitudStockModel.setLocal(localService.findByIdLocal(
				empleadoService.findByIdPersona(pedidoService.getEmpleadoSS().getIdPersona()).getLocal().getIdLocal()));
		solicitudStockModel.setColaborador(empleadoService.findByIdLocales(locales.getIdLocal()));
		solicitudStockModel
				.setProducto(productoService.findByIdProducto(pedidoService.getProductoSS().getIdProducto()));
		solicitudStockModel.setCantidad(pedidoService.getCantidadSS());
		solicitudStockModel.setEmpleado(empleadoService.findByIdPersona(pedidoService.getEmpleadoSS().getIdPersona()));
		solicitudStockModel.setLocal2(localService.findByIdLocal(solicitudStockModel.getLocal2().getIdLocal()));
		solicitudStockModel.setActivo(true);
	}

	@Override
	public SolicitudStockModel insert(SolicitudStockModel solicitudStockModel) {
		SolicitudStock solicitudStock = solicitudStockRepository
				.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}

	@Override
	public SolicitudStockModel update(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setActivo(false);
		solicitudStockModel.setPedido(pedidoService.findByIdPedido(solicitudStockModel.getPedido().getIdPedido()));
		solicitudStockModel.setEmpleado(empleadoService.findByIdPersona(pedidoService
				.findByIdPedido(solicitudStockModel.getPedido().getIdPedido()).getEmpleado().getIdPersona()));
		solicitudStockModel.setLocal(localService.findByIdLocal(empleadoService.findByIdPersona(pedidoService
				.findByIdPedido(solicitudStockModel.getPedido().getIdPedido()).getEmpleado().getIdPersona()).getLocal()
				.getIdLocal()));
		solicitudStockModel.setLocal2(localService.findByIdLocal(solicitudStockModel.getLocal2().getIdLocal()));
		solicitudStockModel
				.setProducto(productoService.findByIdProducto(solicitudStockModel.getProducto().getIdProducto()));
		solicitudStockModel
				.setColaborador(empleadoService.findByIdPersona(solicitudStockModel.getColaborador().getIdPersona()));
		SolicitudStock solicitudStock = solicitudStockRepository
				.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}

	@Override
	public boolean remove(long idSolicitudStock) {

		try {
			solicitudStockRepository.deleteById(idSolicitudStock);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Lote> getActiveLotes(SolicitudStockModel solicitudStockModel) {
		List<Lote> activeLotes = new ArrayList<Lote>();
		for (Lote l : loteService.getAll()) {
			if (l.getProducto().getIdProducto() == solicitudStockModel.getProducto().getIdProducto()
					&& l.getLocal().getIdLocal() == solicitudStockModel.getLocal2().getIdLocal() && l.isActivo()) {
				activeLotes.add(l);
			}
		}
		return activeLotes;
	}

	@Override
	public int calcularStock(SolicitudStockModel solicitudStockModel) {
		int total = 0;
		for (Lote l : getActiveLotes(solicitudStockModel)) {
			total += l.getCantidadActual();
		}
		return total;
	}

	@Override
	public boolean validarConsumo(SolicitudStockModel solicitudStockModel) {
		if (calcularStock(solicitudStockModel) >= solicitudStockModel.getCantidad()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void consumoStock(SolicitudStockModel solicitudStockModel) {
		int cant = solicitudStockModel.getCantidad();
		List<Lote> l = new ArrayList<Lote>();
		int x = 0;
		l = this.getActiveLotes(solicitudStockModel);
		while (cant > 0) {
			if (l.get(x).getCantidadActual() > cant) {
				l.get(x).setCantidadActual(l.get(x).getCantidadActual() - cant);
				cant = 0;
			} else if (l.get(x).getCantidadActual() < cant) {
				cant -= l.get(x).getCantidadActual();
				l.get(x).setCantidadActual(0);
				l.get(x).setActivo(false);
			} else if (l.get(x).getCantidadActual() == cant) {
				cant = 0;
				l.get(x).setCantidadActual(0);
				l.get(x).setActivo(false);
			}
			LoteModel lM = loteService.findByIdLote(l.get(x).getIdLote());
			lM.setCantidadActual(l.get(x).getCantidadActual());
			lM.setActivo(l.get(x).isActivo());
			loteService.insert(lM);
			x++;
		}
	}

}