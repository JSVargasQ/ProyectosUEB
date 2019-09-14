package com.gsa.dao.implem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gsa.dao.ElementoDAO;
import com.gsa.entity.Producto;
import com.gsa.util.HibernateUtil;

public class ProductoDAOImplem implements ElementoDAO<Producto>
{

	@Override
	public void add(Producto pProducto) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pProducto);
		transaction.commit();
	}

	@Override
	public Producto getElemento(long pId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		return ( (Producto)(session.load(Producto.class, pId)) );
	}

	@Override
	public List<Producto> getAllElementos()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Producto> listaUsuarios = session.createQuery("from Producto").list();
		transaction.commit();
		return listaUsuarios;
	}

	@Override
	public void remove(Producto pProducto) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pProducto);
		transaction.commit();
	}

	@Override
	public void update(Producto pProducto) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pProducto);
		transaction.commit();
	}
	
	public void obraVendida(Long pIdObra)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Producto vendida = (Producto)(session.load(Producto.class, pIdObra));
		vendida.setActivo("I");
		session.update(vendida);
		transaction.commit();
	}
	
}
