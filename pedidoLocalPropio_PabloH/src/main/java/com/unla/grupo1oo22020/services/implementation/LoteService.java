package com.unla.grupo1oo22020.services.implementation;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.LocalConverter;
import com.unla.grupo1oo22020.converters.LoteConverter;
import com.unla.grupo1oo22020.converters.ProductoConverter;
import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.models.LoteModel;
import com.unla.grupo1oo22020.repositories.ILoteRepository;
import com.unla.grupo1oo22020.services.ILoteService;

@Service("loteService")
public class LoteService implements ILoteService{

	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	@Autowired
	@Qualifier("localService")
	private LocalService localService;
	
	@Override
	public List<Lote> getAll(){
		
		return loteRepository.findAll();
		
	}
	@Override
	public LoteModel findByIdLote(long idLote) {	
		return loteConverter.entityToModel(loteRepository.findByIdLote(idLote));
		
	}
	
	@Override
	public LoteModel insert(LoteModel loteModel) {
		loteModel.setLocal(localService.findByIdLocal(loteModel.getLocal().getIdLocal()));
		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));
		return loteConverter.entityToModel(lote);
	}
	
	@Override
	public LoteModel update(LoteModel loteModel) {
		loteModel.setProducto(productoService.findByIdProducto(loteModel.getProducto().getIdProducto()));
		loteModel.setLocal(localService.findByIdLocal(loteModel.getLocal().getIdLocal()));
		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));
		return loteConverter.entityToModel(lote);
	}
	
	@Override
	public List<LoteModel> getAlls() {
		List<LoteModel> models = new ArrayList<LoteModel>();
		for (Lote lote : loteRepository.findAll()) {
			models.add(loteConverter.entityToModel(lote));
		}
		return models;
	}
	
	@Override
	public List<LoteModel> findByIdLocal(long idLocal) {
		List<LoteModel> models = new ArrayList<LoteModel>();
		for (Lote lote : loteRepository.findByIdLocal(idLocal)) {
			models.add(loteConverter.entityToModel(lote));
		}
		return models;
	}
	
	@Override
	public List<LoteModel> findByIdProducto(long idProducto) {
		List<LoteModel> models = new ArrayList<LoteModel>();
		for (Lote lote : loteRepository.findByIdProducto(idProducto)) {
			models.add(loteConverter.entityToModel(lote));
		}
		return models;
	}
	
	@Override
	public boolean remove(long idLote) {
		
		try {
			
			loteRepository.deleteById(idLote);;
			return true;
		}catch(Exception e) {
			
			return false;
			
		}
		
	}
	
	
}