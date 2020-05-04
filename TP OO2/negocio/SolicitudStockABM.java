package negocio;

import java.util.List;

import dao.SolicitudStockDao;
import datos.SolicitudStock;

public class SolicitudStockABM {
	SolicitudStockDao stockDao = new SolicitudStockDao();

	public SolicitudStock traer(long idSolicitudStock) {
		return stockDao.traer(idSolicitudStock);
	}

	public List<SolicitudStock> traer() {
		return stockDao.traer();
	}

	public int agregar(SolicitudStock solicitudStock) {
		return stockDao.agregar(solicitudStock);
	}
	
	public void actualizar(SolicitudStock solicitudStock) {
		stockDao.actualizar(solicitudStock);
	}
	
	public void eliminar (long idSolicitudStock) {
		SolicitudStock sStock = stockDao.traer(idSolicitudStock);
		stockDao.eliminar(sStock);
	}

}
