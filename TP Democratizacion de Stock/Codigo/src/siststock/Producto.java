package siststock;

import java.time.LocalDate;


public class Producto {
	private String descripcion;
	private float precioUnitario;
	private LocalDate fechaAlta;
	
	//CONSTRUCTOR
	public Producto(String descripcion, float precioUnitario, LocalDate fechaAlta) {
		super();
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.fechaAlta = fechaAlta;
	}
	
	//GETTERS Y SETTERS
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "\nProducto [descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + ", fechaAlta="
				+ fechaAlta + "]";
	}
	@Override
	public boolean equals(Object obj) {
		return this.descripcion==((Producto)obj).descripcion;
	}
}
