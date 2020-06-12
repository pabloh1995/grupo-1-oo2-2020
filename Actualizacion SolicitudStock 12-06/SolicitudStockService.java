package com.unla.grupo1oo22020.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.SolicitudStockConverter;
import com.unla.grupo1oo22020.entities.SolicitudStock;
import com.unla.grupo1oo22020.models.SolicitudStockModel;
import com.unla.grupo1oo22020.repositories.ISolicitudStockRepository;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.IProductoService;
import com.unla.grupo1oo22020.services.ISolicitudStockService;
import com.unla.grupo1oo22020.services.IEmpleadoService;

@Service("solicitudStockService")
public class SolicitudStockService implements ISolicitudStockService{
	
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
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Override
	public List<SolicitudStock> getAll(){
		return solicitudStockRepository.findAll();
	}
	
	@Override
	public List<SolicitudStockModel> getAlls(){
		List<SolicitudStockModel> ssModel = new ArrayList<SolicitudStockModel>();
		for (SolicitudStock ss : solicitudStockRepository.findAll()) {
			ssModel.add(solicitudStockConverter.entityToModel(ss));
		}
		return ssModel;
	}
	
	public SolicitudStockModel findByIdSolicitudStock(long idSolicitudStock) {
		return solicitudStockConverter.entityToModel(solicitudStockRepository.findByIdSolicitudStock(idSolicitudStock));	
	}
	
	public SolicitudStockModel insert(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setProducto(productoService.findByIdProducto(solicitudStockModel.getProducto().getIdProducto()));
		solicitudStockModel.setEmpleado(empleadoService.findByIdPersona(solicitudStockModel.getEmpleado().getIdPersona()));
		solicitudStockModel.setLocal(localService.findByIdLocal(solicitudStockModel.getEmpleado().getLocal().getIdLocal()));
		solicitudStockModel.setLocal2(localService.findByIdLocal(solicitudStockModel.getLocal2().getIdLocal()));
		solicitudStockModel.setColaborador(empleadoService.findByIdPersona(solicitudStockModel.getColaborador().getIdPersona()));
		SolicitudStock solicitudStock = solicitudStockRepository.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}
	
	public SolicitudStockModel update(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setLocal(localService.findByIdLocal(solicitudStockModel.getLocal().getIdLocal()));
		solicitudStockModel.setLocal2(localService.findByIdLocal(solicitudStockModel.getLocal2().getIdLocal()));
		solicitudStockModel.setProducto(productoService.findByIdProducto(solicitudStockModel.getProducto().getIdProducto()));
		solicitudStockModel.setColaborador(empleadoService.findByIdPersona(solicitudStockModel.getColaborador().getIdPersona()));
		solicitudStockModel.setEmpleado(empleadoService.findByIdPersona(solicitudStockModel.getEmpleado().getIdPersona()));
		SolicitudStock solicitudStock = solicitudStockRepository.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}
	
	@Override
	public boolean remove(long idSolicitudStock) {

		try {
			solicitudStockRepository.deleteById(idSolicitudStock);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	
	

}
