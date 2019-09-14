package com.gsa.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{

	private static SessionFactory sessionFactory;
	
	static
	{
		Configuration configuration = new Configuration().configure();
		
		StandardServiceRegistryBuilder standarService = new StandardServiceRegistryBuilder();
		standarService = standarService.applySettings( configuration.getProperties() );
		
		sessionFactory = configuration.buildSessionFactory( standarService.build() );
	}
	
	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
}
