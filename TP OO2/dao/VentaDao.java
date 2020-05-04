package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Venta;

public class VentaDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Venta venta) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(venta).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Venta venta) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(venta);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Venta venta) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(venta);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Venta traer(long idVenta) throws HibernateException {
		Venta venta = null;
		try {
			iniciaOperacion();
			venta = (Venta) session.get(Venta.class, idVenta);
		} finally {
			session.close();
		}
		return venta;
	}

	@SuppressWarnings("unchecked")
	public List<Venta> traer() throws HibernateException {
		List<Venta> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Venta v order by v.local asc").list();
		} finally {
			session.close();
		}
		return lista;
	}

}
