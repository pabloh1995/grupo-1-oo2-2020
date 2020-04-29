package siststock;

import java.time.LocalDate;
import java.util.*;
import siststock.Local;

public class Venta {
	private int idVenta;
	private Local local;
	private Cliente cliente;
	private LocalDate fechaActual;
	private Empleado empleado;
	private List<DetalleVenta> listaDetallesVenta;

	// CONSTRUCTOR
	public Venta(int idVenta, Local local, Cliente cliente, LocalDate fechaActual, Empleado empleado) {
		super();
		this.idVenta = idVenta;
		this.local = local;
		this.cliente = cliente;
		this.fechaActual = fechaActual;
		this.empleado = empleado;
		this.listaDetallesVenta = new ArrayList<DetalleVenta>();
		;
	}

	public Venta(int idVenta, Local local, Cliente cliente, LocalDate fechaActual, Empleado empleado,
			List<DetalleVenta> listaDetallesVenta) {
		super();
		this.idVenta = idVenta;
		this.local = local;
		this.cliente = cliente;
		this.fechaActual = fechaActual;
		this.empleado = empleado;
		this.listaDetallesVenta = listaDetallesVenta;
	}

	// GETTERS Y SETTERS
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<DetalleVenta> getListaDetallesVenta() {
		return listaDetallesVenta;
	}

	@Override
	public String toString() {
		return "\nVenta [idVenta=" + idVenta + ", local=" + local + ", cliente=" + cliente + ", fechaActual="
				+ fechaActual + ", empleado=" + empleado + ", listaDetallesVenta=" + listaDetallesVenta + "]\n";
	}

	// 46
	public boolean agregarDetalleVenta(Producto producto, int cantidad) throws Exception {
		int idDetalleVenta = 1;
		if (this.getLocal().validarConsumo(producto, cantidad) == false) {
			throw new Exception("Error Stock Insuficiente");
		}
		if (listaDetallesVenta.isEmpty() == false) {
			idDetalleVenta = listaDetallesVenta.get(listaDetallesVenta.size() - 1).getIdDetalleVenta() + 1;
		}
		return listaDetallesVenta.add(new DetalleVenta(idDetalleVenta, producto, cantidad));
	}

	// 47
	public DetalleVenta traerDetalleVenta(int idDetalleVenta) {
		DetalleVenta encontrado = null;
		int i = 0;
		while (i < this.listaDetallesVenta.size() && encontrado == null) {
			if (this.listaDetallesVenta.get(i).getIdDetalleVenta() == idDetalleVenta) {
				encontrado = this.listaDetallesVenta.get(i);
			}
			i++;
		}
		return encontrado;
	}

	// 48
	public List<DetalleVenta> traerListaDetallesVenta() {
		return this.getListaDetallesVenta();
	}
}
