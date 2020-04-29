package siststock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import siststock.Producto;

public class Sistema {
	private List<Local> listaLocales;
	private List<SolicitudStock> listaSolicitudesStock;
	private List<Cliente> listaClientes;
	private List<Venta> listaVentas;
	private List<Producto> listaProductos;
	private List<Venta> listaFacturas;

	// CONSTRUCTOR
	public Sistema(List<Local> listaLocales, List<SolicitudStock> listaSolicitudesStock, List<Cliente> listaClientes,
			List<Venta> listaVentas, List<Producto> listaProductos, List<Venta> listaFacturas) {
		super();
		this.listaLocales = new ArrayList<Local>();
		this.listaSolicitudesStock = new ArrayList<SolicitudStock>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaVentas = new ArrayList<Venta>();
		this.listaProductos = new ArrayList<Producto>();
		this.listaFacturas = new ArrayList<Venta>();
	}

	// GETTERS Y SETTERS
	public List<Local> getListaLocales() {
		return listaLocales;
	}

	public List<SolicitudStock> getListaSolicitudesStock() {
		return listaSolicitudesStock;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public List<Venta> getListaVentas() {
		return listaVentas;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public List<Venta> getListaFacturas() {
		return listaFacturas;
	}

	@Override
	public String toString() {
		return "\nSistema [listaLocales=" + listaLocales + ", listaSolicitudesStock=" + listaSolicitudesStock
				+ ", listaClientes=" + listaClientes + ", listaVentas=" + listaVentas + ", listaProductos="
				+ listaProductos + ", listaFacturas=" + listaFacturas + "]";
	}

	// CASOS DE USO
	// 1
	public Local traerLocal(int id) {
		Local dato = null;
		int i = 0;
		while (dato == null && i < this.listaLocales.size()) {
			if (this.listaLocales.get(i).getId() == id) {
				dato = (Local) this.listaLocales.get(i);
			}
			i++;
		}
		return dato;
	}

	// 3.
	public boolean altaLocal(int id, long telefono, String direccion, float latitud, float longitud) throws Exception {
		if (this.traerLocal(id) != null)
			throw new Exception("Error. El local ya está registrado");
		Local local = new Local(id, telefono, direccion, latitud, longitud);
		return listaLocales.add(local);
	}

	// 4.
	public Local bajaLocal(int id) throws Exception {
		if (this.traerLocal(id) == null)
			throw new Exception("Error. El local no existe");
		Local dato = null;
		int i = 0;
		while (dato == null && i < this.listaLocales.size()) {
			if (this.listaLocales.get(i).getId() == id) {
				dato = this.getListaLocales().remove(i);
			}
			i++;
		}
		return dato;
	}

	// 5.
	public boolean modificarLocal(int id, long telefono, String direccion, float latitud, float longitud)
			throws Exception {
		int i = 0;
		boolean modificado = false;
		if (traerLocal(id) == null)
			throw new Exception("Error. Local no encontrado");
		while (i < listaLocales.size() && modificado == false) {
			if (listaLocales.get(i).getId() == id) {
				listaLocales.set(i, new Local(id, telefono, direccion, latitud, longitud));
				modificado = true;
			}
			i++;
		}
		return modificado;
	}

	// 12.
	public Cliente traerCliente(long dni) {
		Cliente auxCliente = null;
		int indice = 0;
		while (indice < listaClientes.size() && auxCliente == null) {
			if (listaClientes.get(indice).getDni() == dni) {
				auxCliente = listaClientes.get(indice);
			}
			indice++;
		}
		return auxCliente;
	}

	// 13.
	public Cliente traerCliente(String email) {
		Cliente auxCliente = null;
		int indice = 0;
		while (indice < listaClientes.size() && auxCliente == null) {
			if (listaClientes.get(indice).getEmail().equals(email)) {
				auxCliente = listaClientes.get(indice);
			}
			indice++;
		}
		return auxCliente;
	}

	// 15.
	public boolean altaCliente(String apellido, String nombre, long dni, LocalDate fechaNacimiento, String email)
			throws Exception {
		boolean agregar = true;
		if (this.traerCliente(dni) != null)
			throw new Exception("Error Cliente ya registrado\n");
		listaClientes.add(new Cliente(apellido, nombre, dni, fechaNacimiento, email));
		return agregar;
	}

	// 16.
	public boolean bajaCliente(long dni) throws Exception {
		int indice = 0;
		boolean baja = false;
		if (this.traerCliente(dni) == null)
			throw new Exception("Error Cliente no registrado\n");
		while (indice < listaClientes.size() && baja == false) {
			if (listaClientes.get(indice).getDni() == dni) {
				listaClientes.remove(indice);
				baja = true;
			}
			indice++;
		}
		return baja;
	}

	// 17.
	public boolean modificarCliente(String apellido, String nombre, long dni, LocalDate fechaNacimiento, String email)
			throws Exception {
		int indice = 0;
		boolean modificado = false;
		if (this.traerCliente(dni) == null)
			throw new Exception("Error Cliente no registrado\n");
		while (indice < listaClientes.size() && modificado == false) {
			if (listaClientes.get(indice).getDni() == dni) {
				listaClientes.set(indice, new Cliente(apellido, nombre, dni, fechaNacimiento, email));
				modificado = true;
			}
			indice++;
		}
		return modificado;
	}

	// 18.
	public Producto traerProducto(String descripcion) {
		Producto dato = null;
		int i = 0;
		while (dato == null && i < this.listaProductos.size()) {
			if (this.listaProductos.get(i).getDescripcion().equals(descripcion)) {
				dato = this.listaProductos.get(i);
			}
			i++;
		}
		return dato;
	}

	// 20.
	public boolean altaProducto(String descripcion, float precioUnitario, LocalDate fechaAlta) throws Exception {
		if (traerProducto(descripcion) != null)
			throw new Exception("Error. El producto ya está registrado");
		Producto producto = new Producto(descripcion, precioUnitario, fechaAlta);
		return listaProductos.add(producto);
	}

	// 21.
	public Producto bajaProducto(String descripcion) throws Exception {
		if (traerProducto(descripcion) == null)
			throw new Exception("Error. El producto no existe");
		Producto dato = null;
		int i = 0;
		while (dato == null && i < this.listaProductos.size()) {
			if (this.listaProductos.get(i).getDescripcion().equals(descripcion)) {
				dato = this.listaProductos.remove(i);
			}
			i++;
		}
		return dato;
	}

	// 22.
	public boolean modificarProducto(String descripcion, float precioUnitario, LocalDate fechaAlta) throws Exception {
		int i = 0;
		boolean modificado = false;
		if (traerProducto(descripcion) == null)
			throw new Exception("Error. Producto no encontrado");
		while (i < listaProductos.size() && modificado == false) {
			if (listaProductos.get(i).getDescripcion().equals(descripcion)) {
				listaProductos.set(i, new Producto(descripcion, precioUnitario, fechaAlta));
				modificado = true;
			}
			i++;
		}
		return modificado;
	}

	// 26.
	public List<String> calcularDistancia(Producto producto, int cantidad, Local local) {
		int i = 0;
		double distancia = 0;
		String dist = "";
		List<String> listaAux = new ArrayList<String>();
		while ((i < listaLocales.size())) {
			if (listaLocales.get(i).equals(local) == false) {
				if (listaLocales.get(i).validarConsumo(producto, cantidad) == true) {
					distancia = listaLocales.get(i).calcularDistancia(local);
					dist = listaLocales.get(i) + "Distacia:" + distancia + "\n";
					listaAux.add(dist);
				}
			}
			i++;
		}
		return listaAux;
	}

	// 49
	public List<Local> solicitudStock(Producto producto, int cantidad, Local local) {
		List<Local> listaLocalesConStock = new ArrayList<Local>();
		int i = 0;
		while ((i < listaLocales.size())) {
			if (listaLocales.get(i).equals(local) == false) {
				if (listaLocales.get(i).validarConsumo(producto, cantidad) == true) {
					listaLocalesConStock.add(listaLocales.get(i));
				}
			}
			i++;
		}
		return listaLocalesConStock;
	}

	// 29
	public SolicitudStock traerSolicitudStock(int id) {
		SolicitudStock aux = null;
		int i = 0;
		while (i < listaSolicitudesStock.size() && aux == null) {
			if (listaSolicitudesStock.get(i).getId() == id) {
				aux = listaSolicitudesStock.get(i);
			}
		}
		return aux;
	}

	// 30
	public boolean generarSolicitudStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor) {
		boolean flag = true;
		{
			int id = 1;
			if (listaSolicitudesStock.isEmpty() == false) {
				id = listaSolicitudesStock.get(listaSolicitudesStock.size() - 1).getId() + 1;
			}
			listaSolicitudesStock.add(new SolicitudStock(id, fecha, producto, cantidad, vendedor, null, false));
		}

		return flag;
	}

	// 31
	public boolean respuestaSolicitudStock(Local local, SolicitudStock solicitudStock, Empleado colaborador,
			boolean aceptado) throws Exception {
		boolean encontrado = false;
		int i = 0;
		while (i < listaSolicitudesStock.size() && encontrado == false) {
			if (listaSolicitudesStock.get(i).getId() == solicitudStock.getId()) {
				encontrado = true;
			}
		}
		if (encontrado == true) {
			listaSolicitudesStock.set(i,
					new SolicitudStock(solicitudStock.getId(), solicitudStock.getFecha(), solicitudStock.getProducto(),
							solicitudStock.getCantidad(), solicitudStock.getVendedor(), colaborador, aceptado));
			if (aceptado == true) {
				local.validarConsumo(solicitudStock.getProducto(), solicitudStock.getCantidad());
			}
		}
		return encontrado;
	}

	// 34
	public boolean generarVenta(Local local, Cliente cliente, LocalDate fechaActual, Empleado empleado) {
		int idVenta = 1;
		if (listaVentas.isEmpty() == false) {
			idVenta = listaVentas.get(listaVentas.size() - 1).getIdVenta() + 1;
		}
		return listaVentas.add(new Venta(idVenta, local, cliente, fechaActual, empleado));
	}

	// 35
	public Venta traerVenta(int idVenta) {
		Venta encontrado = null;
		int i = 0;
		while (i < listaVentas.size() && encontrado == null) {
			if (listaVentas.get(i).getIdVenta() == idVenta) {
				encontrado = listaVentas.get(i);
			}
			i++;
		}
		return encontrado;
	}

	// 36
	public boolean bajaVenta(int idVenta) {
		boolean baja = false;
		int i = 0;
		while (i < listaVentas.size() && baja == false) {
			if (listaVentas.get(i).getIdVenta() == idVenta) {
				listaVentas.remove(i);
				baja = true;
			}
			i++;
		}
		return baja;
	}

	// 37
	public boolean generarFactura(int idVenta) throws Exception {
		boolean encontrado = false;
		int i = 0, j = 0;
		while (i < listaVentas.size() && encontrado == false) {
			if (listaVentas.get(i).getIdVenta() == idVenta) {
				listaFacturas.add(listaVentas.get(i));
				encontrado = true;
			}
			i++;
			while (j < listaVentas.get(idVenta - 1).getListaDetallesVenta().size()) {
				listaVentas.get(idVenta - 1).getLocal().consumoStock(
						listaVentas.get(idVenta - 1).getListaDetallesVenta().get(j).getProducto(),
						listaVentas.get(idVenta - 1).getListaDetallesVenta().get(j).getCantidad());
				j++;
			}
		}
		return encontrado;

	}

	// 38
	public float calcularSueldoEmpleado(Empleado empleado, int comisionVenta, int comisionAsistencia) {
		float sueldo = 0, comisionTotal = 0, comisionVentas = 0, comisionColab = 0, comisionColabTotal = 0, aux = 0,
				precio = 0;
		int i = 0, j = 0, cantidad = 0, k = 0;
		sueldo = empleado.getSueldoBasico();
		while (i < listaFacturas.size()) {
			if (listaFacturas.get(i).getEmpleado().equals(empleado)) {
				while (j < listaFacturas.get(i).getListaDetallesVenta().size()) {
					precio = listaFacturas.get(i).traerDetalleVenta(j + 1).getProducto().getPrecioUnitario();
					cantidad = listaFacturas.get(i).traerDetalleVenta(j + 1).getCantidad();
					aux = precio * cantidad;
					comisionVentas = comisionVentas + aux;
					j++;
				}
			}
			comisionTotal = comisionTotal + comisionVentas;
			i++;
		}
		comisionTotal = comisionTotal * comisionVenta / 100;
		while (k < listaSolicitudesStock.size()) {
			if (listaSolicitudesStock.get(k).getColaborador().equals(empleado)) {
				cantidad = listaSolicitudesStock.get(k).getCantidad();
				precio = listaSolicitudesStock.get(k).getProducto().getPrecioUnitario();
				aux = cantidad * precio;
				comisionColab = comisionColab + aux;
			}
			comisionColabTotal = comisionColabTotal + comisionColab;
			k++;
		}
		comisionTotal = comisionTotal + (comisionColabTotal * comisionAsistencia / 100);
		sueldo = sueldo + comisionTotal;
		return sueldo;
	}

	// 32
	public List<Venta> productosVendidos(Local local, LocalDate fechaInicio, LocalDate fechaFin) {
		List<Venta> listaProductosVendidos = new ArrayList<Venta>();
		int i = 0;
		while (i < listaVentas.size()) {
			if (listaVentas.get(i).getLocal().getId() == local.getId()) {
				if (listaVentas.get(i).getFechaActual().isAfter(fechaInicio)
						&& listaVentas.get(i).getFechaActual().isBefore(fechaFin)) {
					listaProductosVendidos.add(listaVentas.get(i));
				}
			}
			i++;
		}
		return listaProductosVendidos;
	}

	// 33
	public List<String> rankingProductosVendidos() {
		List<DetalleVenta> listaRanking = new ArrayList<DetalleVenta>();
		List<String> listaOrdenada = new ArrayList<String>();
		String dato = "";
		int k = 0, m = 0, aux = 0, auxIndice = 0, tam = 0, cantidadmax = 0;
		while (m < listaProductos.size()) {
			listaRanking.add(new DetalleVenta(m, listaProductos.get(m), 0));
			m++;
		}
		for (int i = 0; i < listaVentas.size(); i++) {
			for (int j = 0; j < listaVentas.get(i).getListaDetallesVenta().size(); j++) {
				while (k < listaRanking.size()) {
					if (listaVentas.get(i).getListaDetallesVenta().get(j).getProducto()
							.equals(listaRanking.get(k).getProducto())) {
						cantidadmax = listaRanking.get(k).getCantidad();
						cantidadmax = cantidadmax + listaVentas.get(i).getListaDetallesVenta().get(j).getCantidad();
						listaRanking.set(k, new DetalleVenta(listaRanking.get(k).getIdDetalleVenta(),
								listaRanking.get(k).getProducto(), cantidadmax));
					}
					k++;
				}
				k = 0;
			}
		}
		k = 0;
		tam = listaRanking.size();
		while (listaOrdenada.size() < tam) {
			while (k < listaRanking.size()) {
				if (listaRanking.get(k).getCantidad() > aux) {
					auxIndice = k;
					aux = listaRanking.get(k).getCantidad();
				}
				k++;
			}
			dato = listaRanking.get(auxIndice).getProducto() + "Cantidad:" + listaRanking.get(auxIndice).getCantidad()
					+ "\n";
			listaOrdenada.add(dato);
			listaRanking.remove(auxIndice);
			k = 0;
			aux = 0;
		}
		return listaOrdenada;
	}

	// 2
	public List<Local> traerListaLocales() {
		return this.getListaLocales();
	}

	// 14
	public List<Cliente> traerListaClientes() {
		return this.getListaClientes();
	}

	// 39
	public List<SolicitudStock> traerListaSolicitudesStock() {
		return this.getListaSolicitudesStock();
	}

	// 40
	public List<Venta> traerListaVentas() {
		return this.getListaVentas();
	}

	// 19
	public List<Producto> traerListaProductos() {
		return this.getListaProductos();
	}

	// 41
	public List<Venta> traerListaFacturas() {
		return this.getListaFacturas();
	}

}