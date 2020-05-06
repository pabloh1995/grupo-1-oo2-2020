package negocio;

import dao.VentaDao;
import datos.*;
import java.time.*;
import java.util.List;
import java.util.Set;

public class VentaABM {
	VentaDao dao = new VentaDao();

	public Venta traer(long idVenta) {
		Venta v = dao.traer(idVenta);
		return v;
	}

	public int agregar(long idVenta, Local local, Cliente cliente, LocalDate fechaActual, Empleado empleado, Set<DetalleVenta> listaDetallesVenta) {
		Venta v = new Venta(idVenta, local, cliente, fechaActual, empleado, listaDetallesVenta);
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