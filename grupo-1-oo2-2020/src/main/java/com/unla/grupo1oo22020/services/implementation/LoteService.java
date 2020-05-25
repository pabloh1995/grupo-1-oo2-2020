package com.unla.grupo1oo22020.services.implementation;

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
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
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
	public LoteModel insertOrUpdate(LoteModel loteModel) {
		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));
		return loteConverter.entityToModel(lote);
		
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