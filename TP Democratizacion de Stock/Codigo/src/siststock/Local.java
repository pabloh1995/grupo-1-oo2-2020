package siststock;

import java.util.List;

import siststock.Lote;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Local {
	private int id;
	private long telefono;
	private String direccion;
	private float latitud;
	private float longitud;
	private List<Empleado> listaEmpleados;
	private List<Lote> listaLotes;

	// CONSTRUCTOR
	public Local(int id, long telefono, String direccion, float latitud, float longitud) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.listaEmpleados = new ArrayList<Empleado>();
		this.listaLotes = new ArrayList<Lote>();
	}

	public Local(int id, long telefono, String direccion, float latitud, float longitud, List<Empleado> listaEmpleados,
			List<Lote> listaLotes) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.listaEmpleados = new ArrayList<Empleado>();
		this.listaLotes = new ArrayList<Lote>();
	}

	// SETTERS Y GETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public List<Lote> getListaLotes() {
		return listaLotes;
	}

	@Override
	public String toString() {
		return "\nLocal [id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]\n";
	}

	// 6
	public Empleado traerEmpleado(long dni) {
		Empleado empleadoEncontrado = null;
		int i = 0;

		while (empleadoEncontrado == null && i < this.listaEmpleados.size()) {
			if (this.listaEmpleados.get(i).getDni() == dni) {
				empleadoEncontrado = this.listaEmpleados.get(i);
			}
			i++;
		}
		return empleadoEncontrado;
	}

	// 7
	public Empleado traerEmpleado(int id) {
		Empleado empleadoEncontrado = null;
		int i = 0;

		while (empleadoEncontrado == null && i < this.listaEmpleados.size()) {
			if (this.listaEmpleados.get(i).getId() == id) {
				empleadoEncontrado = this.listaEmpleados.get(i);
			}
			i++;
		}
		return empleadoEncontrado;
	}

	// 9
	public boolean altaEmpleado(String apellido, String nombre, long dni, LocalDate fechaNacimiento, int id,
			float sueldoBasico, LocalTime horarioTrabajoE, LocalTime horarioTrabajoS, boolean gerente)
			throws Exception {
		if (this.traerEmpleado(dni) != null)
			throw new Exception("Error. Empleado ya registrado");
		Empleado empleado = new Empleado(apellido, nombre, dni, fechaNacimiento, id, sueldoBasico, horarioTrabajoE,
				horarioTrabajoS, gerente, this);
		return this.listaEmpleados.add(empleado);
	}

	// 10.
	public boolean bajaEmpleado(long dni) throws Exception {
		int indice = 0;
		boolean baja = false;
		if (this.traerEmpleado(dni) == null)
			throw new Exception("Error. Empleado no registrado");
		while (indice < listaEmpleados.size() && baja == false) {
			if (listaEmpleados.get(indice).getDni() == dni) {
				listaEmpleados.remove(indice);
				baja = true;
			}
			indice++;
		}
		return baja;
	}

	// 11.
	public boolean modificarEmpleado(String apellido, String nombre, long dni, LocalDate fechaNacimiento, int id,
			float sueldoBasico, LocalTime horarioTrabajoE, LocalTime horarioTrabajoS, boolean gerente)
			throws Exception {
		int indice = 0;
		boolean modificado = false;
		if (this.traerEmpleado(dni) == null) {
			throw new Exception("Error. Empleado no registrado\n");
		}
		while (indice < listaEmpleados.size() && modificado == false) {
			if (listaEmpleados.get(indice).getDni() == dni) {
				listaEmpleados.set(indice, new Empleado(apellido, nombre, dni, fechaNacimiento, id, sueldoBasico,
						horarioTrabajoE, horarioTrabajoS, gerente, this));
				modificado = true;
			}
			indice++;
		}
		return modificado;
	}

	// 23
	public Lote traerLote(int id) {
		Lote loteEncontrado = null;
		int i = 0;

		while (loteEncontrado == null && i < listaLotes.size()) {
			if (listaLotes.get(i).getIdLote() == id) {
				loteEncontrado = listaLotes.get(i);
			}
			i++;
		}
		return loteEncontrado;
	}

	// 24.
	public boolean altaLote(int id, LocalDate fechaIngreso, int cantidadIngreso, int cantidadActual, Producto producto)
			throws Exception {
		boolean activo = true;
		if (this.traerLote(id) != null)
			throw new Exception("Error. Lote ya registrado");
		if (cantidadActual == 0) {
			activo = false;
		}
		Lote lote = new Lote(id, fechaIngreso, cantidadIngreso, cantidadActual, activo, producto, this);
		return listaLotes.add(lote);
	}

	// 25.
	public double calcularDistancia(Local local) {
		double auxlat = this.getLatitud() - local.getLatitud();
		double auxlon = this.getLongitud() - local.getLongitud();
		double distancia = Math.sqrt(auxlat * auxlat + auxlon * auxlon);
		return distancia;
	}

	// 42
	public List<Lote> traerLotesActivos(Producto producto) {
		ArrayList<Lote> listaAux = new ArrayList<Lote>();
		for (Lote l : this.getListaLotes()) {
			if (l.getProducto().equals(producto) && l.isActivo()) {
				listaAux.add(l);
			}
		}
		return listaAux;
	}

	// 43
	public int traerCantidad(Producto producto) {
		int cantidad = 0;

		for (Lote l : this.traerLotesActivos(producto)) {
			cantidad += l.getCantidadActual();
		}
		return cantidad;
	}

	// 27
	public boolean validarConsumo(Producto producto, int cantidad) {
		return this.traerCantidad(producto) - cantidad >= 0;
	}

	// 44
	public boolean consumoStock(Producto producto, int cantidad) throws Exception {
		boolean consumo = false;
		int id = 0, cantidadRestante = cantidad, cantidadInicial = 0, cantidadActual = 0, indice = 0, indiceAux = 0,
				indice2 = 0, indiceAux2 = 0;
		LocalDate fechaAlta;
		boolean activo = true;
		List<Lote> listaAux = new ArrayList<Lote>();
		if (this.validarConsumo(producto, cantidad) == false) {
			throw new Exception("Error cantidad de stock insuficiente\n");
		}
		listaAux = this.traerLotesActivos(producto);
		while (cantidadRestante > 0) {
			indice2 = 0;
			while ((indice < (listaAux.size() - 1)) && (listaAux.size() > 1)) {
				if ((listaAux.get(indice).getFechaIngreso()
						.compareTo(listaAux.get(indice + 1).getFechaIngreso())) < 0) {
					if (listaAux.get(indice).getCantidadActual() > 0) {
						indiceAux = listaAux.get(indice).getIdLote();
						indiceAux2 = indice;
						while (indice2 < listaLotes.size()) {
							if (listaLotes.get(indice2).getIdLote() == indiceAux) {
								indiceAux = indice2;
							}
							indice2++;
						}
					}
				}
				indice++;
			}

			if (listaAux.size() == 1) {
				indiceAux = listaAux.get(0).getIdLote();
				while (indice2 < listaLotes.size()) {
					if (listaLotes.get(indice2).getIdLote() == indiceAux) {
						indiceAux = indice2;
					}
					indice2++;
				}
			}
			if (listaLotes.get(indiceAux).getCantidadActual() >= cantidadRestante) {
				id = listaLotes.get(indiceAux).getIdLote();
				fechaAlta = listaLotes.get(indiceAux).getFechaIngreso();
				cantidadInicial = listaLotes.get(indiceAux).getCantidadIngreso();
				cantidadActual = (listaLotes.get(indiceAux).getCantidadActual()) - cantidadRestante;
				producto = listaLotes.get(indiceAux).getProducto();
				activo = true;
				if (cantidadActual == 0) {
					activo = false;
				}
				listaLotes.set(indiceAux,
						new Lote(id, fechaAlta, cantidadInicial, cantidadActual, activo, producto, this));
				cantidadRestante = 0;
				indice = 0;
				indice2 = 0;
			}
			if (listaLotes.get(indiceAux).getCantidadActual() < cantidadRestante) {
				id = listaLotes.get(indiceAux).getIdLote();
				fechaAlta = listaLotes.get(indiceAux).getFechaIngreso();
				cantidadInicial = listaLotes.get(indiceAux).getCantidadIngreso();
				cantidadRestante = cantidadRestante - (listaLotes.get(indiceAux).getCantidadActual());
				producto = listaLotes.get(indiceAux).getProducto();
				activo = false;
				listaLotes.set(indiceAux, new Lote(id, fechaAlta, cantidadInicial, 0, activo, producto, this));
				listaAux.remove(indiceAux2);
				indice = 0;
				indice2 = 0;
			}
		}
		return consumo;
	}

	// 8
	public List<Empleado> traerListaEmpleados() {
		return this.getListaEmpleados();
	}

	// 45
	public List<Lote> traerListaLotes() {
		return this.getListaLotes();
	}
}
