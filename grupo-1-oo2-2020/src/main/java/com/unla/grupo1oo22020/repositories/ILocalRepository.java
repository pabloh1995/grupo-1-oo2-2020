package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.Local;


@Repository("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Serializable>{
	
	public abstract Local findByIdLocal(long idLocal);
	

}