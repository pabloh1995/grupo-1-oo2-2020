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

	public abstract Pedido findByProducto(Producto producto);

	public abstract Pedido findByLocal(Local local);

	@Query("SELECT p FROM Pedido p JOIN FETCH p.local l WHERE l.idLocal = (:idLocal)")
	public abstract List<Pedido> findByIdLocal(long idLocal);

}
