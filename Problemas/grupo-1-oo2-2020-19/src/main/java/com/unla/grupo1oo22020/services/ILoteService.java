package com.unla.grupo1oo22020.services;

import java.util.List;

import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.models.LoteModel;


public interface ILoteService {

    public  List<Lote> getAll();
	   
    public  List<LoteModel> getAlls();
	
	public  LoteModel insert(LoteModel loteModel);
	
	public  LoteModel update(LoteModel loteModel);
	
	public  boolean remove(long idBatch);

	public  LoteModel findByIdLote(long idLote);
	
	public  List<LoteModel> findByIdLocal(long idLocal);

	public List<LoteModel> findByIdProducto(long idProducto);
	
}
