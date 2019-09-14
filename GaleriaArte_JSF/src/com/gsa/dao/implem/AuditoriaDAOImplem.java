package com.gsa.dao.implem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gsa.dao.ElementoDAO;
import com.gsa.entity.Auditoria;
import com.gsa.util.HibernateUtil;

public class AuditoriaDAOImplem implements ElementoDAO<Auditoria>
{

	@Override
	public void add(Auditoria pAuditoria)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pAuditoria);
		transaction.commit();
	}

	@Override
	public List<Auditoria> getAllElementos()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Auditoria> listaAuditoria = session.createQuery("from Auditoria").list();
		transaction.commit();
		return listaAuditoria;
	}

	
	
	//-------------------------NO UTILIZADOS-----------------------------------------------
	@Override
	public Auditoria getElemento(long pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Auditoria pElemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Auditoria pElemento) {
		// TODO Auto-generated method stub
		
	}

}
