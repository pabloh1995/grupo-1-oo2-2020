package com.unla.grupo1oo22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.Local;
import com.unla.grupo1oo22020.models.LocalModel;

@Component("localConverter")
public class LocalConverter {
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	public LocalModel entityToModel(Local local) {
		return new LocalModel(local.getIdLocal(), local.getTelefono(), local.getDireccion(), local.getLatitud(), local.getLongitud());
	}

	public Local modelToEntity(LocalModel localModel) {
		return new Local(localModel.getIdLocal(), localModel.getTelefono(), localModel.getDireccion(), localModel.getLatitud(), localModel.getLongitud());
	}
}