package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.SolicitudStock;

public class SolicitudStockDao {
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

	public int agregar(SolicitudStock solicitudStock) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(solicitudStock).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(SolicitudStock solicitudStock) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(solicitudStock);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(SolicitudStock solicitudStock) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(solicitudStock);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public SolicitudStock traer(long idSolicitudStock) throws HibernateException {
		SolicitudStock sStock = null;
		try {
			iniciaOperacion();
			sStock = (SolicitudStock) session.get(SolicitudStock.class, idSolicitudStock);
		} finally {
			session.close();
		}
		return sStock;
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudStock> traer() throws HibernateException {
		List<SolicitudStock> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from SolicitudStock sStock order by sStock.idSolicitudStock asc").list();
		} finally {
			session.close();
		}
		return lista;
	}

}