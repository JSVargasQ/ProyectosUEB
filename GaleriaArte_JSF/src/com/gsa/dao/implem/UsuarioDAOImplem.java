package com.gsa.dao.implem;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gsa.dao.UsuarioDAO;
import com.gsa.entity.Usuario;
import com.gsa.util.HibernateUtil;

public class UsuarioDAOImplem implements UsuarioDAO
{

	@Override
	public void add(Usuario pUsuario) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pUsuario);
		transaction.commit();
	}

	@Override
	public Usuario getElemento(long pId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		return ( (Usuario)(session.load(Usuario.class, pId)) );
	}
	

	@Override
	public List<Usuario> getAllElementos()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Usuario> listaUsuarios = session.createQuery("from Usuario").list();
		transaction.commit();
		return listaUsuarios;
	}

	@Override
	public void remove(Usuario pUsuario) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pUsuario);
		transaction.commit();
	}

	@Override
	public void update(Usuario pUsuario) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(pUsuario);
		transaction.commit();
	}

	@Override
	public Usuario verificaUsuario(String pUserName, String pPassword) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("FROM Usuario user WHERE user.userName =:userName AND user.password =:password");
		q.setString("userName", pUserName);
		q.setString("password", pPassword);
		return (Usuario) q.uniqueResult();
	}
	
	public Usuario buscarUser(String pUserName)
	{
		System.out.println("BuscarUser: Username: " + pUserName);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("FROM Usuario user WHERE user.userName =:userName");
		q.setString("userName", pUserName);
		return ( ( Usuario )( q.uniqueResult() ) );
	}
	
	public Usuario buscarUserCorreo(String pUserName, String pCorreo) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("FROM Usuario user WHERE user.userName =:userName AND user.emailAddress =:email");
		q.setString("userName", pUserName);
		q.setString("email", pCorreo);
		return (Usuario) q.uniqueResult();
	}
	
	
}
