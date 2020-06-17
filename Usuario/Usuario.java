package com.unla.grupo1oo22020.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="contraseña")
	private String contraseña;
	
	@Column(name="aceptado")
	private boolean aceptado;
	
	@Column(name="creado")
	@UpdateTimestamp
	private LocalDateTime creado;
	
	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime actualizado;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
	private Set<RolUsuario> rolesUsuario = new HashSet<RolUsuario>();
	
	public Usuario() {
	}
	
	public Usuario(String usuario, String contraseña, boolean aceptado) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.aceptado = aceptado;
	}
	
	public Usuario(String usuario, String contraseña, boolean aceptado, Set<RolUsuario> rolesUsuario) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.aceptado = aceptado;
		this.rolesUsuario = rolesUsuario;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
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

	public Set<RolUsuario> getRolesUsuario() {
		return rolesUsuario;
	}

	public void setRolesUsuario(Set<RolUsuario> rolesUsuarios) {
		this.rolesUsuario = rolesUsuarios;
	}

	
	
}
