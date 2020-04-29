package siststock;

import siststock.Producto;

public class DetalleVenta {
	private int idItem;
	private Producto producto;
	private int cantidad;
	
	//CONSTRUCTOR
	public DetalleVenta(int idDetalleVenta, Producto producto, int cantidad) {
		super();
		this.idItem = idDetalleVenta;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	//GETTERS Y SETTERS
	public int getIdDetalleVenta() {
		return idItem;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idItem = idDetalleVenta;
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

	@Override
	public String toString() {
		return "\nDetalleVenta [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
}
