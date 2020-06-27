package com.unla.grupo1oo22020.services.implementation;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.LocalConverter;
import com.unla.grupo1oo22020.entities.Local;
import com.unla.grupo1oo22020.models.DetalleVentaModel;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.repositories.ILocalRepository;
import com.unla.grupo1oo22020.services.IDetalleVentaService;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.IVentaService;

@Service("localService")
public class LocalService implements ILocalService {

	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;

	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	@Autowired
	@Qualifier("detalleVentaService")
	private IDetalleVentaService detalleVentaService;

	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;

	@Override
	public List<Local> getAll() {
		return localRepository.findAll();
	}

	@Override
	public LocalModel insert(LocalModel localModel) {
		Local local = localRepository.save(localConverter.modelToEntity(localModel));
		return localConverter.entityToModel(local);
	}

	@Override
	public LocalModel update(LocalModel localModel) {
		Local local = localRepository.save(localConverter.modelToEntity(localModel));
		return localConverter.entityToModel(local);
	}

	@Override
	public boolean remove(long idLocal) {
		try {
			localRepository.deleteById(idLocal);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public LocalModel findByIdLocal(long idLocal) {
		return localConverter.entityToModel(localRepository.findByIdLocal(idLocal));
	}

	@Override
	public List<LocalModel> getAlls() {
		List<LocalModel> models = new ArrayList<LocalModel>();
		for (Local local : localRepository.findAll()) {
			models.add(localConverter.entityToModel(local));
		}
		return models;
	}

	@Override
	public List<ProductoModel> productosVendidosPorFechas(LocalModel local, LocalDate desde, LocalDate hasta) {
		int index = 0;
		List<ProductoModel> productos = new ArrayList<ProductoModel>();
		List<DetalleVentaModel> detventas = detalleVentaService.getAlls();
		while (index < detventas.size()) {
			if (detventas.get(index).getFechaDetalle().isAfter(desde)
					&& detventas.get(index).getFechaDetalle().isBefore(hasta)) {
				if (detventas.get(index).getVenta().getLocal().getIdLocal() == local.getIdLocal()) {
					productos.add(detventas.get(index).getProducto());
				}
			}
			index++;
		}
		return productos;
	}

}