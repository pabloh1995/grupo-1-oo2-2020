package datos;

import java.util.Set;

public class Local {
	private long idLocal;
	private long telefono;
	private String direccion;
	private float latitud;
	private float longitud;
	private Set<Lote> Lotes;
	private Set<Empleado> Empleados;
	
	public Local() {
		super();
	}

	public Local(long telefono, String direccion, float latitud, float longitud, Set<Lote> lotes,
			Set<Empleado> empleados) {
		super();
		this.telefono = telefono;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		Lotes = lotes;
		Empleados = empleados;
	}

	public long getIdLocal() {
		return idLocal;
	}

	protected void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
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
	
	@Override
	public String toString() {
		return "Local [idLocal=" + idLocal + ", telefono=" + telefono + ", direccion=" + direccion + ", latitud="
				+ latitud + ", longitud=" + longitud + "]";
	}

	public Set<Lote> getLotes() {
		return Lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		Lotes = lotes;
	}

	public Set<Empleado> getEmpleados() {
		return Empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		Empleados = empleados;
	}



}