package com.gsa.dao.implem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gsa.dao.ElementoDAO;
import com.gsa.entity.Exposicion;
import com.gsa.util.HibernateUtil;

public class ExposicionDAOImplem implements ElementoDAO<Exposicion>
{
	
	@Override
	public void add(Exposicion pExposicion) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pExposicion);
		transaction.commit();
	}

	@Override
	public Exposicion getElemento(long pId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		return ( (Exposicion)(session.load(Exposicion.class, pId)) );
	}

	@Override
	public List<Exposicion> getAllElementos()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Exposicion> listaUsuarios = session.createQuery("from Exposicion").list();
		transaction.commit();
		return listaUsuarios;
	}

	@Override
	public void remove(Exposicion pExposicion) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pExposicion);
		transaction.commit();
	}

	@Override
	public void update(Exposicion pExposicion) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pExposicion);
		transaction.commit();
	}
	
}
