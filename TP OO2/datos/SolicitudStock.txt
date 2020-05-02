package datos;

import java.time.LocalDate;

public class SolicitudStock {
	private long idSolicitudStock;
	private LocalDate fecha;
	private Producto producto;
	private int cantidad;
	private Empleado vendedor;
	private Empleado colaborador;
	private boolean aceptado;

	public SolicitudStock() {

	}

	public SolicitudStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor,
			Empleado colaborador, boolean aceptado) {
		super();
		this.fecha = fecha;
		this.setProducto(producto);
		this.cantidad = cantidad;
		this.setVendedor(vendedor);
		this.setColaborador(colaborador);
		this.aceptado = aceptado;
	}

	public long getId() {
		return idSolicitudStock;
	}

	protected void setId(long idSolicitudStock) {
		this.idSolicitudStock = idSolicitudStock;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public Empleado getColaborador() {
		return colaborador;
	}

	public void setColaborador(Empleado colaborador) {
		this.colaborador = colaborador;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	@Override
	public String toString() {
		return "SolicitudStock [idSolicitudStock=" + idSolicitudStock + ", fecha=" + fecha + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", vendedor=" + vendedor + ", colaborador=" + colaborador + ", aceptado="
				+ aceptado + "]";
	}
	

}