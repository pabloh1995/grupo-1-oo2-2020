package com.unla.grupo1oo22020.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idProducto;

	@NotNull(message = "Debes especificar el nombre")
	@Column(name = "nombre")
	String nombre;

	@NotNull(message = "Debes especificar la descripcion")
	@Column(name = "descripcion")
	String descripcion;

	@NotNull(message = "Debes especificar el precio")
	@Column(name = "precioUnitario")
	float precioUnitario;

	@Column(name = "fechaAlta")
	@CreationTimestamp
	LocalDate fechaAlta;

	public Producto() {

	}

	public Producto(long idProducto, String nombre, String descripcion, float precioUnitario, LocalDate fechaAlta) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.fechaAlta = fechaAlta;
	}

	public Producto(String nombre, String descripcion, float precioUnitario, LocalDate fechaAlta) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.fechaAlta = fechaAlta;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
}