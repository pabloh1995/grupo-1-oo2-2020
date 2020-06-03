package com.unla.grupo1oo22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo1oo22020.entities.Local;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.entities.Producto;

@Repository("pedidoRepository")
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable> {
	
	public abstract Pedido findByIdPedido(long idPedido);
	
	//ver si se necesita
	public abstract Pedido findByProducto(Producto producto);
	
	//ver si se necesita
	public abstract Pedido findByLocal(Local local);
	
	//ver si la necesito
	@Query("SELECT p FROM Pedido p JOIN FETCH p.local s WHERE s.idLocal = (:idLocal)")
	public abstract List<Pedido> findByIdLocal(long idLocal);

}
