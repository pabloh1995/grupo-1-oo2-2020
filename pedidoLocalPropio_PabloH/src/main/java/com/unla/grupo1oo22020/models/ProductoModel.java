package com.unla.grupo1oo22020.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductoModel {
    private long idProducto;
    private String nombre;
    private String descripcion;
    private float precioUnitario;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    public ProductoModel() {

    }

    public ProductoModel(long idProducto, String nombre, String descripcion, float precioUnitario, LocalDate fechaAlta){
        super();
        this.idProducto=idProducto;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precioUnitario=precioUnitario;
        this.fechaAlta=fechaAlta;
    }

	public long getIdProducto() {
		return idProducto;
	}

	protected void setIdProducto(long idProducto) {
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