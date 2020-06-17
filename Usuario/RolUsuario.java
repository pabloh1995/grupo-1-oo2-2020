package com.unla.grupo1oo22020.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="rolUsuario")
public class RolUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;
	
	@Column(name="rol", nullable=false, length=50)
	private String rol;
	
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime creado;
	
	@Column(name="actualizado")
	@CreationTimestamp
	private LocalDateTime actualizado;
	
	public RolUsuario() {
	}
	
	public RolUsuario(long idRol, Usuario usuario, String rol) {
		this.setIdRol(idRol);
		this.usuario = usuario;
		this.rol = rol;
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public LocalDateTime getCreado() {
		return creado;
	}

	public void setCreado(LocalDateTime creado) {
		this.creado = creado;
	}

	public LocalDateTime getActualizado() {
		return actualizado;
	}

	public void setActualizado(LocalDateTime actualizado) {
		this.actualizado = actualizado;
	}
	
	
	

}
