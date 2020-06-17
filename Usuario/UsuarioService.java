package com.unla.grupo1oo22020.services.implementation;

import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.entities.RolUsuario;
import com.unla.grupo1oo22020.entities.Usuario;
import com.unla.grupo1oo22020.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		com.unla.grupo1oo22020.entities.Usuario usu = usuarioRepository.findByUsuario(usuario);
		return (UserDetails) buildUser(usu, buildGrantedAuthorities(usu.getRolesUsuario()));
	}

	private Usuario buildUser(com.unla.grupo1oo22020.entities.Usuario usuario,
			List<GrantedAuthority> grantedAuthorities) {
		return new Usuario(usuario.getUsuario(), usuario.getContraseña(), usuario.isAceptado());
	}

	private List<GrantedAuthority> buildGrantedAuthorities(Set<RolUsuario> rolesUsuarios) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (RolUsuario rolUsuario : rolesUsuarios) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rolUsuario.getRol()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}
