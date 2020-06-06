package com.unla.grupo1oo22020.models;

import java.util.HashSet;
import java.util.Set;
import com.unla.grupo1oo22020.entities.Cliente;
import com.unla.grupo1oo22020.entities.Empleado;


public class LocalModel {
	private long idLocal;
	private long telefono;
	private String direccion;
	private float latitud;
	private float longitud;
	private Set<Cliente> listaClientes = new HashSet<Cliente>();
	private Set<Empleado> listaEmpleados = new HashSet<Empleado>();

	
	public LocalModel() {

	}

	public LocalModel(long idLocal, long telefono, String direccion, float latitud, float longitud) {
		super();
		this.setIdLocal(idLocal);
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

	public Set<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(Set<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Set<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(Set<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	
}