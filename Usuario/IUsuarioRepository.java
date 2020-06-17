package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.grupo1oo22020.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	//@Query("SELECT u FROM Usuario u JOIN FETCH u.rolesUsuarios WHERE u.usuario = (:usuario)")
	public abstract Usuario findByUsuario(@Param("usuario") String usuario);

}
