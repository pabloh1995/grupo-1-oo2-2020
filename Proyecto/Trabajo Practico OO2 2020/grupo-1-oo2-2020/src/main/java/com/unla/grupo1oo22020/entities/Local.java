package com.unla.grupo1oo22020.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name = "local")
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLocal;

	@Column(name = "telefono")
	private long telefono;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "latitud")
	private float latitud;

	@Column(name = "longitud")
	private float longitud;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "local")
	private Set<Empleado> listaEmpleados = new HashSet<Empleado>();

	@ManyToMany(mappedBy = "listaLocales")
	private Set<Cliente> listaClientes = new HashSet<Cliente>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "local")
	private Set<Lote> lotes = new HashSet<Lote>();

	public Local() {

	}

	public Local(long idLocal, long telefono, String direccion, float latitud, float longitud) {
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

	public Set<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(Set<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Set<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(Set<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}

}
