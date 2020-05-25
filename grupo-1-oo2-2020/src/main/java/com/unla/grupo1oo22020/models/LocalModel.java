package com.unla.grupo1oo22020.models;

import java.util.HashSet;
import java.util.Set;


public class LocalModel {
	private long idLocal;
	private long telefono;
	private String direccion;
	private float latitud;
	private float longitud;
	private Set<ClienteModel> listaClientes = new HashSet<ClienteModel>();
	private Set<EmpleadoModel> listaEmpleados = new HashSet<EmpleadoModel>();

	
	public LocalModel() {

	}

	public LocalModel(long idLocal, long telefono, String direccion, float latitud, float longitud) {
		super();
		this.idLocal = idLocal;
		this.telefono = telefono;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(long idLocal) {
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
	

}