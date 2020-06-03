package com.unla.grupo1oo22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.Lote;
import com.unla.grupo1oo22020.models.LoteModel;


@Component("loteConverter")
public class LoteConverter {
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	public	LoteModel entityToModel(Lote lote) {
		return new LoteModel(lote.getIdLote(), lote.getFechaIngreso(), lote.getCantidadIngreso(), lote.getCantidadActual(), lote.isActivo(), productoConverter.entityToModel(lote.getProducto()), localConverter.entityToModel(lote.getLocal()));
	}

	public Lote modelToEntity(LoteModel loteModel) {
		return new Lote(loteModel.getIdLote(), loteModel.getFechaIngreso(), loteModel.getCantidadIngreso(),loteModel.getCantidadActual(), loteModel.isActivo(), productoConverter.modelToEntity(loteModel.getProducto()), localConverter.modelToEntity(loteModel.getLocal()));
	}

	/*public List<LoteModel> loteToLoteModel (List<Lote> lote) {
		List<LoteModel> nuevoLotes = new ArrayList<LoteModel>();
		for(int i = 0 ; i < lote.size(); i ++) {
			LoteModel loteEntidad = new LoteModel();
			loteEntidad.setIdLote(lote.get(i).getIdLote());
			loteEntidad.setCantidadActual(lote.get(i).getCantidadActual());
			loteEntidad.setCantidadInicial(lote.get(i).getCantidadInicial());
			loteEntidad.setEstado(lote.get(i).isEstado());
			loteEntidad.setFechaIngreso(lote.get(i).getFechaIngreso());
			loteEntidad.setProducto(productoConverter.entityToModel(lote.get(i).getProducto()));
			loteEntidad.setStock(lote.get(i).getStock());
			nuevoLotes.add(loteEntidad);
		}


		return nuevoLotes;
	}*/
	
}
