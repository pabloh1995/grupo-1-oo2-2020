package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.Local;


@Repository("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Serializable> {
	
	//public List<Local> getAll();
	
	public abstract Local findById(long id);
	
	//public LocalModel insertOrUpdate(LocalModel personModel);
	
	//public boolean remove(int id);
	
	//public abstract Local findByName(String name);
	
	// Todas las personas que tengan un título con ese nombre (parámetro name)
	//@Query("SELECT p FROM Person p JOIN FETCH p.degrees d WHERE d.name = (:name)")
	//public abstract List<Local> findByDegreeName(String name);
}