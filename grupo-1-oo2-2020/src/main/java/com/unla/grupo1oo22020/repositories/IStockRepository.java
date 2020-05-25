package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.Stock;


@Repository("stockRepository")
public interface IStockRepository extends JpaRepository<Stock, Serializable>{

	public abstract Stock findByIdStock(long idStock);

}
