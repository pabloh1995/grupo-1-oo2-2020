package negocio;

import dao.VentaDao;
import datos.*;
import java.util.List;

public class VentaABM {
	VentaDao dao = new VentaDao();

	public Venta traer(long idVenta) {
		Venta v = dao.traer(idVenta);
		return v;
	}

	public int agregar(Venta v) {
		return dao.agregar(v);
	}
	
	public void modificar(Venta v) {
		dao.actualizar(v);
	}
	
	public void eliminar(long idVenta) {
		Venta v = dao.traer(idVenta);
		dao.eliminar(v);
	}
	
	public List<Venta> traer(){
		return dao.traer();
	}
}
