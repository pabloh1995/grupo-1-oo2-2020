package com.unla.grupo1oo22020.services.implementation;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.PedidoConverter;
import com.unla.grupo1oo22020.converters.ProductoConverter;
import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.entities.Producto;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.LoteModel;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.models.RankingProductoModel;
import com.unla.grupo1oo22020.repositories.IPedidoRepository;
import com.unla.grupo1oo22020.services.IClienteService;
import com.unla.grupo1oo22020.services.IEmpleadoService;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.IPedidoService;
import com.unla.grupo1oo22020.services.IProductoService;

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
	public List<LoteModel> getActiveLotes(LocalModel localModel, ProductoModel productoModel) {
		List<LoteModel> activeLotes = new ArrayList<LoteModel>();
		for (LoteModel l : loteService.getAlls()) {
			if (l.getProducto().getIdProducto() ==productoModel.getIdProducto() && l.getLocal().getIdLocal() ==localModel.getIdLocal() && l.isActivo()) {
				activeLotes.add(l);
			}
		}
		return activeLotes;
	}

	@Override
	public int calcularStock(LocalModel localModel, ProductoModel productoModel) {
		int total = 0;
		for (LoteModel loteModel : getActiveLotes(localModel, productoModel) ){
			total += loteModel.getCantidadActual();
		}
		return total;
		
	}

	@Override
	public boolean validarConsumo(LocalModel localModel, ProductoModel productoModel, int cantidad) {
		return (calcularStock(localModel, productoModel) >= cantidad) ? true : false; 
		}

	@Override
	public void consumoStock(LocalModel localModel, ProductoModel productoModel, int cantidad) {
		for(LoteModel l: this.getActiveLotes(localModel, productoModel)) {
			if (l.getCantidadActual() > cantidad) {
				l.setCantidadActual(l.getCantidadActual() - cantidad);
				cantidad = 0;
			} else if (l.getCantidadActual() < cantidad) {
				cantidad -= l.getCantidadActual();
				l.setCantidadActual(0);
				l.setActivo(false);
			} else if (l.getCantidadActual() == cantidad) {
				cantidad = 0;
				l.setCantidadActual(0);
				l.setActivo(false);
			}
			LoteModel lM = loteService.findByIdLote(l.getIdLote());
			lM.setCantidadActual(l.getCantidadActual());
			lM.setActivo(l.isActivo());
			loteService.insert(lM);
		}
	}
	
	  @Override
	  public List<RankingProductoModel> rankingproductosvendidos(){  
		  RankingProductoModel prodAuxiliar = new RankingProductoModel();
		  List<RankingProductoModel> productosList = new ArrayList<>();
		  List<Producto> productos = productoService.getAll();
		  List<Pedido> auxiliar = new ArrayList<>();
		  
		  int cantidadAux=0;

		  for(Producto p : productos) {
			  prodAuxiliar = new RankingProductoModel();		  
			  cantidadAux=0;
			  auxiliar = this.pedidosPorProducto(p);

			  for(Pedido ped : auxiliar) {
				  if(ped.isResuelto()==true) {
					  cantidadAux+=ped.getCantidad();
				  }
			  }
			  prodAuxiliar.setProducto(productoConverter.entityToModel(p));
			  prodAuxiliar.setCantidad(cantidadAux);
			  productosList.add(prodAuxiliar);
		  }

		  Collections.sort(productosList,new Comparator<RankingProductoModel>()
		  {
            public int compare(RankingProductoModel o1,
            		RankingProductoModel o2)
            {
                if (o1.getCantidad() == o2.getCantidad())
                {
                    return 0;
                }
                else if (o1.getCantidad() >
                             o2.getCantidad())
                {
                    return -1;
                }
                return 1;
            }
           }
		);
		  
		return productosList;  
	  }

	public List<Pedido> pedidosPorProducto(Producto p){
		List<Pedido> pedidos = this.getAll();
		List<Pedido> auxiliar = new ArrayList<>();
		
		for(Pedido ped: pedidos) {
			if(ped.getProducto().getIdProducto()==p.getIdProducto()) {
				auxiliar.add(ped);
			}
		}
		return auxiliar;
	}
	
	public List<EmpleadoModel> getEmpleadosColaboradores(){
		List<EmpleadoModel> colaboradores = new ArrayList<EmpleadoModel>();
		List<EmpleadoModel> auxiliar = new ArrayList<EmpleadoModel>();
		List<LocalModel> locales = new ArrayList<LocalModel>();
		LocalModel local = new LocalModel();
		local = getLocal();
		locales = localService.getAlls();
		int i=0, j=0;
		while(i<locales.size()) {
			if(locales.get(i).getIdLocal() != local.getIdLocal()) {
				auxiliar = empleadoService.findByIdLocalNoGerente(locales.get(i).getIdLocal());
				while(j<auxiliar.size()) {
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
		List<LocalModel> localesConStock= new ArrayList<LocalModel>();
		List<LocalModel> locales = new ArrayList<LocalModel>();
		locales = localService.getAlls();
		PedidoModel pedidoAux = new PedidoModel();
		int i=0, cantidadTotal=0, ultimoPedido=0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido-1);
		while(i< locales.size()) {
			if(locales.get(i).getIdLocal() != pedidoAux.getLocal().getIdLocal()) {
				for (Lote l : loteService.getAll()) {
				if (l.getProducto().getIdProducto() == pedidoAux.getProducto().getIdProducto()
						&& l.getLocal().getIdLocal() == locales.get(i).getIdLocal() && l.isActivo()) {
					cantidadTotal = cantidadTotal + l.getCantidadActual();
				}
			}
			if(pedidoAux.getCantidad()<= cantidadTotal) {
				localesConStock.add(locales.get(i));
			}}
			cantidadTotal=0;
			i++;
		 }
      return localesConStock;
	}

	public ProductoModel getProducto() {
		PedidoModel pedidoAux = new PedidoModel();
		ProductoModel producto = new ProductoModel();
		int ultimoPedido=0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido-1);
		producto = pedidoAux.getProducto();
		return producto;
	}
	
	public int getCantidad() {
		PedidoModel pedidoAux = new PedidoModel();
		int cantidad=0, ultimoPedido=0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido-1);
		cantidad = pedidoAux.getCantidad();
		return cantidad;
	}

	public LocalModel getLocal() {
		PedidoModel pedidoAux = new PedidoModel();
		LocalModel local = new LocalModel();
		int ultimoPedido=0;
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidos = getAlls();
		ultimoPedido = pedidos.size();
		pedidoAux = pedidos.get(ultimoPedido-1);
		local = pedidoAux.getLocal();
		return local;
	}
}