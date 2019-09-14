package com.gsa.dao.implem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gsa.dao.ElementoDAO;
import com.gsa.entity.Transaccion;
import com.gsa.util.HibernateUtil;

public class TransaccionDAOImplem implements ElementoDAO<Transaccion>
{

	@Override
	public void add(Transaccion pTransaccion) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pTransaccion);
		transaction.commit();
	}

	@Override
	public Transaccion getElemento(long pId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		return ( (Transaccion)(session.load(Transaccion.class, pId)) );
	}

	@Override
	public List<Transaccion> getAllElementos()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Transaccion> listaUsuarios = session.createQuery("from Transaccion").list();
		transaction.commit();
		return listaUsuarios;
	}

	@Override
	public void remove(Transaccion pTransaccion) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pTransaccion);
		transaction.commit();
	}

	@Override
	public void update(Transaccion pTransaccion) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pTransaccion);
		transaction.commit();
	}

	
}
