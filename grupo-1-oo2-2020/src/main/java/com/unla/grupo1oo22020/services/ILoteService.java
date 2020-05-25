package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.models.LoteModel;

public interface ILoteService {

	public List<Lote> getAll();
	
	public LoteModel insertOrUpdate(LoteModel loteModel);
	
	public LoteModel findByIdLote(long idLote);
	
	public boolean remove(long idLote);
	
}
