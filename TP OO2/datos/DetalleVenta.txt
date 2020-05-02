package datos;


public class DetalleVenta {
	private long idDetalleVenta;
	private Producto producto;
	private int cantidad;


	public DetalleVenta() {
		
	}

	public DetalleVenta(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	protected void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
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
		return "\nDetalleVenta [idDetalleVenta=" + idDetalleVenta + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}

}
