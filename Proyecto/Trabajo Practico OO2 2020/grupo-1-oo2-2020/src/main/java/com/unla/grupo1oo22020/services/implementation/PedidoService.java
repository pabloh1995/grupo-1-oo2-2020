package com.unla.grupo1oo22020.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.PedidoConverter;
import com.unla.grupo1oo22020.converters.ProductoConverter;
import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.models.ClienteModel;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.LoteModel;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.models.DetalleVentaModel;
import com.unla.grupo1oo22020.models.SolicitudStockModel;
import com.unla.grupo1oo22020.models.VentaModel;
import com.unla.grupo1oo22020.repositories.IPedidoRepository;
import com.unla.grupo1oo22020.services.IClienteService;
import com.unla.grupo1oo22020.services.IEmpleadoService;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.IPedidoService;
import com.unla.grupo1oo22020.services.IProductoService;
import com.unla.grupo1oo22020.services.ISolicitudStockService;
import com.unla.grupo1oo22020.services.IDetalleVentaService;
import com.unla.grupo1oo22020.services.IVentaService;

@Service("pedidoService")
public class PedidoService implements IPedidoService {

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;

	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;

	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService solicitudStockService;

	@Autowired
	@Qualifier("detalleVentaService")
	private IDetalleVentaService detalleVentaService;

	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;

	private double[] dists;

	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public void setAttributes(PedidoModel pedidoModel) {
		pedidoModel.setProducto(productoService.findByIdProducto(pedidoModel.getProducto().getIdProducto()));
		pedidoModel.setLocal(localService.findByIdLocal(pedidoModel.getLocal().getIdLocal()));
		pedidoModel.setEmpleado(empleadoService.findByIdPersona(pedidoModel.getEmpleado().getIdPersona()));
		pedidoModel.setCliente(clienteService.findByIdPersona(pedidoModel.getCliente().getIdPersona()));

	}

	@Override
	public PedidoModel insert(PedidoModel pedidoModel) {
		Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}

	@Override
	public PedidoModel update(PedidoModel pedidoModel) {
		Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
	}

	@Override
	public PedidoModel findByIdPedido(long idPedido) {
		return pedidoConverter.entityToModel(pedidoRepository.findByIdPedido(idPedido));
	}

	@Override
	public List<PedidoModel> getAlls() {
		List<PedidoModel> models = new ArrayList<PedidoModel>();
		for (Pedido pedido : pedidoRepository.findAll()) {
			models.add(pedidoConverter.entityToModel(pedido));
		}
		return models;
	}

	@Override
	public List<Lote> getActiveLotes(PedidoModel pedidoModel) {
		List<Lote> activeLotes = new ArrayList<Lote>();
		for (Lote l : loteService.getAll()) {
			if (l.getProducto().getIdProducto() == pedidoModel.getProducto().getIdProducto()
					&& l.getLocal().getIdLocal() == pedidoModel.getLocal().getIdLocal() && l.isActivo()) {
				activeLotes.add(l);
			}
		}
		return activeLotes;
	}

	@Override
	public int calcularStock(PedidoModel pedidoModel) {
		int total = 0;
		for (Lote l : getActiveLotes(pedidoModel)) {
			total += l.getCantidadActual();
		}
		return total;
	}

	@Override
	public boolean validarConsumo(PedidoModel pedidoModel) {
		if (calcularStock(pedidoModel) >= pedidoModel.getCantidad()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void consumoStock(PedidoModel pedidoModel) {
		int cant = pedidoModel.getCantidad();
		List<Lote> l = new ArrayList<Lote>();
		l = this.getActiveLotes(pedidoModel);
		int x = 0;
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

	public List<EmpleadoModel> getEmpleadosColaboradores() {
		List<EmpleadoModel> colaboradores = new ArrayList<EmpleadoModel>();
		List<EmpleadoModel> auxiliar = new ArrayList<EmpleadoModel>();
		List<LocalModel> locales = new ArrayList<LocalModel>();
		LocalModel local = new LocalModel();
		local = getLocal();
		locales = localService.getAlls();
		int i = 0, j = 0;
		while (i < locales.size()) {
			if (locales.get(i).getIdLocal() != local.getIdLocal()) {
				auxiliar = empleadoService.findByIdLocalNoGerente(locales.get(i).getIdLocal());
				j = 0;
				while (j < auxiliar.size()) {
					colaboradores.add(auxiliar.get(j));
					j++;
				}
			}
			i++;
		}
		return colaboradores;
	}

	@Override
	public boolean remove(long idPedido) {
		try {
			pedidoRepository.deleteById(idPedido);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<LocalModel> LocalesConStock() {
		List<LocalModel> localesConStock = new ArrayList<LocalModel>();
		List<LocalModel> locales = new ArrayList<LocalModel>();
		LocalModel localAux = new LocalModel();
		int x = 0, solicitudProcesandose = 0;
		double dLat = 0, dLng = 0, sindLat = 0, sindLng = 0, va1 = 0, va2 = 0;
		double radioTierra = 6371; // en kilómetros
		locales = localService.getAlls();
		PedidoModel pedidoAux = new PedidoModel();
		int i = 0, cantidadTotal = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		List<PedidoModel> pedidosAux = new ArrayList<PedidoModel>();
		List<SolicitudStockModel> solicitudes = new ArrayList<SolicitudStockModel>();
		solicitudes = solicitudStockService.getAlls();
		pedidos = getAlls();

		while (i < pedidos.size()) {
			for (int k = 0; k < solicitudes.size(); k++) {
				if (pedidos.get(i).isResuelto() == false) {
					if ((pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
							&& solicitudes.get(k).isActivo() == false && solicitudes.get(k).isAceptado() == true)
							|| pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
									&& solicitudes.get(k).isActivo() == true) {
						solicitudProcesandose = 1;
					}
				}
			}
			if (pedidos.get(i).isResuelto() == true) {
				solicitudProcesandose = 1;
			}
			if (solicitudProcesandose == 0) {
				pedidosAux.add(pedidos.get(i));
			}
			i++;
			solicitudProcesandose = 0;
		}
		i = 0;
		pedidoAux = pedidosAux.get(0);
		System.out.println("\n \n \n" + pedidoAux.getIdPedido() + " \n \n \n");
		while (i < locales.size()) {
			if (locales.get(i).getIdLocal() != pedidoAux.getLocal().getIdLocal()) {
				for (Lote l : loteService.getAll()) {
					if (l.getProducto().getIdProducto() == pedidoAux.getProducto().getIdProducto()
							&& l.getLocal().getIdLocal() == locales.get(i).getIdLocal() && l.isActivo()) {
						cantidadTotal = cantidadTotal + l.getCantidadActual();
					}
				}
				if (pedidoAux.getCantidad() <= cantidadTotal) {
					localesConStock.add(locales.get(i));
				}
			}
			cantidadTotal = 0;
			i++;
		}
		dists = new double[localesConStock.size()];
		i = 0;
		while (i < localesConStock.size()) {
			dLat = Math.toRadians(localesConStock.get(i).getLatitud() - pedidoAux.getLocal().getLatitud());
			dLng = Math.toRadians(localesConStock.get(i).getLongitud() - pedidoAux.getLocal().getLongitud());
			sindLat = Math.sin(dLat / 2);
			sindLng = Math.sin(dLng / 2);
			va1 = Math.pow(sindLat, 2)
					+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(pedidoAux.getLocal().getLatitud()))
							* Math.cos(Math.toRadians(localesConStock.get(i).getLatitud()));
			va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
			dists[i] = radioTierra * va2;
			i++;
		}

		for (x = 0; x < localesConStock.size(); x++) {
			for (int y = 0; y < localesConStock.size() - x - 1; y++) {
				if (dists[y] > dists[y + 1]) {
					double aux = dists[y + 1];
					localAux = localesConStock.get(y + 1);
					dists[y + 1] = dists[y];
					localesConStock.set((y + 1), localesConStock.get(y));
					dists[y] = aux;
					localesConStock.set(y, localAux);
				}
			}
		}
		return localesConStock;
	}

	public ProductoModel getProducto() {
		PedidoModel pedidoAux = new PedidoModel();
		ProductoModel producto = new ProductoModel();
		int ultimoPedido = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido - 1);
		producto = pedidoAux.getProducto();
		return producto;
	}

	public int getCantidad() {
		PedidoModel pedidoAux = new PedidoModel();
		int cantidad = 0, ultimoPedido = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido - 1);
		cantidad = pedidoAux.getCantidad();
		return cantidad;
	}

	public LocalModel getLocal() {
		PedidoModel pedidoAux = new PedidoModel();
		LocalModel local = new LocalModel();
		int ultimoPedido = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido - 1);
		local = pedidoAux.getLocal();
		return local;
	}

	public EmpleadoModel getEmpleado() {
		PedidoModel pedidoAux = new PedidoModel();
		EmpleadoModel empleado = new EmpleadoModel();
		int ultimoPedido = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido - 1);
		empleado = pedidoAux.getEmpleado();
		return empleado;
	}

	public ClienteModel getCliente() {
		PedidoModel pedidoAux = new PedidoModel();
		ClienteModel cliente = new ClienteModel();
		int ultimoPedido = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido - 1);
		cliente = pedidoAux.getCliente();
		return cliente;
	}

	@Override
	public void setDetalleVenta(VentaModel ventaModel) {
		DetalleVentaModel detalleVenta = new DetalleVentaModel();
		List<SolicitudStockModel> solicitudes = new ArrayList<SolicitudStockModel>();
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		List<VentaModel> ventas = new ArrayList<VentaModel>();
		ventas = ventaService.getAlls();
		ventaModel = ventas.get(ventas.size() - 1);
		pedidos = getAlls();
		int i = 0, j = 0;
		float total = 0;
		while (i < pedidos.size()) {
			if (pedidos.get(i).getCliente().getIdPersona() == ventaModel.getCliente().getIdPersona()
					&& pedidos.get(i).getEmpleado().getIdPersona() == ventaModel.getEmpleado().getIdPersona()
					&& pedidos.get(i).isResuelto() == true) {
				detalleVenta.setProducto(pedidos.get(i).getProducto());
				detalleVenta.setCantidad(pedidos.get(i).getCantidad());
				detalleVenta.setPrecioSubTotal(
						pedidos.get(i).getCantidad() * pedidos.get(i).getProducto().getPrecioUnitario());
				detalleVenta.setVenta(ventaService.findByIdVenta(ventaModel.getIdVenta()));
				total = total + detalleVenta.getPrecioSubTotal();
				detalleVentaService.insert(detalleVenta);
				this.consumoStock(pedidos.get(i));
				this.remove(pedidos.get(i).getIdPedido());
			} else if (pedidos.get(i).getCliente().getIdPersona() == ventaModel.getCliente().getIdPersona()
					&& pedidos.get(i).getEmpleado().getIdPersona() == ventaModel.getEmpleado().getIdPersona()
					&& pedidos.get(i).isResuelto() == false) {
				solicitudes = solicitudStockService.getAlls();
				while (j < solicitudes.size()) {
					if (solicitudes.get(j).getEmpleado().getIdPersona() == pedidos.get(i).getEmpleado().getIdPersona()
							&& solicitudes.get(j).getCantidad() == pedidos.get(i).getCantidad() && solicitudes.get(j)
									.getProducto().getIdProducto() == pedidos.get(i).getProducto().getIdProducto()
							&& solicitudes.get(j).isAceptado() == true) {
						detalleVenta.setProducto(pedidos.get(i).getProducto());
						detalleVenta.setCantidad(pedidos.get(i).getCantidad());
						detalleVenta.setPrecioSubTotal(
								pedidos.get(i).getCantidad() * pedidos.get(i).getProducto().getPrecioUnitario());
						detalleVenta.setVenta(ventaService.findByIdVenta(ventaModel.getIdVenta()));
						total = total + detalleVenta.getPrecioSubTotal();
						detalleVentaService.insert(detalleVenta);
						solicitudStockService.consumoStock(solicitudes.get(j));
						EmpleadoModel e = new EmpleadoModel();
						e = solicitudes.get(j).getColaborador();
						e.setComision(e.getComision() + solicitudes.get(j).getCantidad()
								* solicitudes.get(j).getProducto().getPrecioUnitario() * 0.03f);
						empleadoService.update(e);
						solicitudStockService.remove(solicitudes.get(j).getIdSolicitudStock());
						j = solicitudes.size();
						this.remove(pedidos.get(i).getIdPedido());
					}
					j++;
				}

			}
			i++;
		}
		ventaModel.setTotal(total);
	}

	public ProductoModel getProductoSS() {
		PedidoModel pedidoAux = new PedidoModel();
		ProductoModel producto = new ProductoModel();
		List<SolicitudStockModel> solicitudes = new ArrayList<SolicitudStockModel>();
		solicitudes = solicitudStockService.getAlls();
		int i = 0, solicitudProcesandose = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		List<PedidoModel> pedidosAux = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		while (i < pedidos.size()) {
			for (int k = 0; k < solicitudes.size(); k++) {
				if (pedidos.get(i).isResuelto() == false) {
					if ((pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
							&& solicitudes.get(k).isActivo() == false && solicitudes.get(k).isAceptado() == true)
							|| pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
									&& solicitudes.get(k).isActivo() == true) {
						solicitudProcesandose = 1;
					}
				}
			}
			if (pedidos.get(i).isResuelto() == true) {
				solicitudProcesandose = 1;
			}
			if (solicitudProcesandose == 0) {
				pedidosAux.add(pedidos.get(i));
			}
			i++;
			solicitudProcesandose = 0;
		}
		pedidoAux = pedidosAux.get(0);
		producto = pedidoAux.getProducto();
		return producto;
	}

	public int getCantidadSS() {
		PedidoModel pedidoAux = new PedidoModel();
		List<SolicitudStockModel> solicitudes = new ArrayList<SolicitudStockModel>();
		solicitudes = solicitudStockService.getAlls();
		int cantidad = 0, i = 0, solicitudProcesandose = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		List<PedidoModel> pedidosAux = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		while (i < pedidos.size()) {
			for (int k = 0; k < solicitudes.size(); k++) {
				if (pedidos.get(i).isResuelto() == false) {
					if ((pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
							&& solicitudes.get(k).isActivo() == false && solicitudes.get(k).isAceptado() == true)
							|| pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
									&& solicitudes.get(k).isActivo() == true) {
						solicitudProcesandose = 1;
					}
				}
			}
			if (pedidos.get(i).isResuelto() == true) {
				solicitudProcesandose = 1;
			}
			if (solicitudProcesandose == 0) {
				pedidosAux.add(pedidos.get(i));
			}
			i++;
			solicitudProcesandose = 0;
		}
		pedidoAux = pedidosAux.get(0);
		cantidad = pedidoAux.getCantidad();
		return cantidad;
	}

	public LocalModel getLocalSS() {
		PedidoModel pedidoAux = new PedidoModel();
		LocalModel local = new LocalModel();
		List<SolicitudStockModel> solicitudes = new ArrayList<SolicitudStockModel>();
		solicitudes = solicitudStockService.getAlls();
		int i = 0, solicitudProcesandose = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		List<PedidoModel> pedidosAux = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		while (i < pedidos.size()) {
			for (int k = 0; k < solicitudes.size(); k++) {
				if (pedidos.get(i).isResuelto() == false) {
					if ((pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
							&& solicitudes.get(k).isActivo() == false && solicitudes.get(k).isAceptado() == true)
							|| pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
									&& solicitudes.get(k).isActivo() == true) {
						solicitudProcesandose = 1;
					}
				}
			}
			if (pedidos.get(i).isResuelto() == true) {
				solicitudProcesandose = 1;
			}
			if (solicitudProcesandose == 0) {
				pedidosAux.add(pedidos.get(i));
			}
			i++;
			solicitudProcesandose = 0;
		}
		pedidoAux = pedidosAux.get(0);
		local = pedidoAux.getLocal();
		return local;
	}

	public EmpleadoModel getEmpleadoSS() {
		PedidoModel pedidoAux = new PedidoModel();
		EmpleadoModel empleado = new EmpleadoModel();
		List<SolicitudStockModel> solicitudes = new ArrayList<SolicitudStockModel>();
		solicitudes = solicitudStockService.getAlls();
		int i = 0, solicitudProcesandose = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		List<PedidoModel> pedidosAux = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		while (i < pedidos.size()) {
			for (int k = 0; k < solicitudes.size(); k++) {
				if (pedidos.get(i).isResuelto() == false) {
					if ((pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
							&& solicitudes.get(k).isActivo() == false && solicitudes.get(k).isAceptado() == true)
							|| pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
									&& solicitudes.get(k).isActivo() == true) {
						solicitudProcesandose = 1;
					}
				}
			}
			if (pedidos.get(i).isResuelto() == true) {
				solicitudProcesandose = 1;
			}
			if (solicitudProcesandose == 0) {
				pedidosAux.add(pedidos.get(i));
			}
			i++;
			solicitudProcesandose = 0;
		}
		pedidoAux = pedidosAux.get(0);
		empleado = pedidoAux.getEmpleado();
		return empleado;
	}

	public PedidoModel getPedidoSS() {
		PedidoModel pedidoAux = new PedidoModel();
		PedidoModel pedido = new PedidoModel();
		List<SolicitudStockModel> solicitudes = new ArrayList<SolicitudStockModel>();
		solicitudes = solicitudStockService.getAlls();
		int i = 0, solicitudProcesandose = 0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		List<PedidoModel> pedidosAux = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		while (i < pedidos.size()) {
			for (int k = 0; k < solicitudes.size(); k++) {
				if (pedidos.get(i).isResuelto() == false) {
					if ((pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
							&& solicitudes.get(k).isActivo() == false && solicitudes.get(k).isAceptado() == true)
							|| pedidos.get(i).getIdPedido() == solicitudes.get(k).getPedido().getIdPedido()
									&& solicitudes.get(k).isActivo() == true) {
						solicitudProcesandose = 1;
					}
				}
			}
			if (pedidos.get(i).isResuelto() == true) {
				solicitudProcesandose = 1;
			}
			if (solicitudProcesandose == 0) {
				pedidosAux.add(pedidos.get(i));
			}
			i++;
			solicitudProcesandose = 0;
		}
		pedidoAux = pedidosAux.get(0);
		pedido = pedidoAux;
		return pedido;
	}

}