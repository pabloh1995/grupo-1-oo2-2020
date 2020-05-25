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
		return new LoteModel(lote.getIdLote(), lote.getFechaIngreso(), lote.getCantidadIngreso(), lote.getCantidadActual(), lote.isActivo(), productoConverter.entityToModel(lote.getProducto()), localConverter.entityToModel(lote.getLocal()), lote.getStock());
	}

	public Lote modelToEntity(LoteModel loteModel) {
		return new Lote(loteModel.getIdLote(), loteModel.getFechaIngreso(), loteModel.getCantidadIngreso(),loteModel.getCantidadActual(), loteModel.isActivo(), productoConverter.modelToEntity(loteModel.getProducto()), localConverter.modelToEntity(loteModel.getLocal()), loteModel.getStock());
	}

	
}
