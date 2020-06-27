package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona {

	@Column(name = "email")
	private String email;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(

			name = "clienteporlocal", joinColumns = { @JoinColumn(name = "idPersona") }, inverseJoinColumns = {
					@JoinColumn(name = "idLocal") }

	)

	private Set<Local> listaLocales = new HashSet<Local>();

	public Cliente() {
		super();
	}

	public Cliente(long idPersona, long dni, String apellido, String nombre, LocalDate fechaNacimiento, String email) {
		super(idPersona, dni, apellido, nombre, fechaNacimiento);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Local> getListaLocales() {
		return listaLocales;
	}

	public void setListaLocales(Set<Local> listaLocales) {
		this.listaLocales = listaLocales;
	}

}