package siststock;

import java.time.LocalDate;

public class Lote {
	private int idLote;
	private LocalDate fechaIngreso;
	private int cantidadIngreso;
	private int cantidadActual;
	private boolean activo;
	private Producto producto;
	private Local local;
	
	//CONSTRUCTOR


	//GETTERS Y SETTERS
	public int getIdLote() {
		return idLote;
	}

	public Lote(int idLote, LocalDate fechaIngreso, int cantidadIngreso, int cantidadActual, boolean activo,
			Producto producto, Local local) {
		super();
		this.idLote = idLote;
		this.fechaIngreso = fechaIngreso;
		this.cantidadIngreso = cantidadIngreso;
		this.cantidadActual = cantidadActual;
		this.activo = activo;
		this.producto = producto;
		this.local = local;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getCantidadIngreso() {
		return cantidadIngreso;
	}

	public void setCantidadIngreso(int cantidadIngreso) {
		this.cantidadIngreso = cantidadIngreso;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", fechaIngreso=" + fechaIngreso + ", cantidadIngreso=" + cantidadIngreso
				+ ", cantidadActual=" + cantidadActual + ", activo=" + activo + ", producto=" + producto + ", local="
				+ local + "]\n";
	}
	
}
