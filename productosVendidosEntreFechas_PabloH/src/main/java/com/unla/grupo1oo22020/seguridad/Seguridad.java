package com.unla.grupo1oo22020.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unla.grupo1oo22020.services.implementation.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Seguridad extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/*", "/img/*", "/js/*", "/vendor/bootstrap/css/*", "/vendor/jquery/*",
						"/vendor/bootstrap/js/*", "/static/css/*", "/static/img/*", "/css/static/img/background.jpg",
						"/resources/*").permitAll()
				.antMatchers("/login").permitAll()
				//.antMatchers("/empleado/new").hasRole("administrador")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
				.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/loginsuccess")
				.permitAll()
				.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
	}

}