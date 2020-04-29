package siststock;

import java.time.LocalDate;

public class SolicitudStock {
	private int id;
	private LocalDate fecha;
	private Producto producto;
	private int cantidad;
	private Empleado vendedor;
	private Empleado colaborador;
	private boolean aceptado;
	
	//constructor
	public SolicitudStock(int id, LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, Empleado colaborador,
			boolean aceptado) {
		super();
		this.id = id; 
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
		this.colaborador = colaborador;
		this.aceptado = aceptado;
	}

	//getters y setters
	
	public LocalDate getFecha() {
		return fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "\nSolicitudStock [id=" + id + ", fecha=" + fecha + ", producto=" + producto + ", cantidad=" + cantidad + ", vendedor="
				+ vendedor + ", colaborador=" + colaborador + ", aceptado=" + aceptado + "]";
	}

}
