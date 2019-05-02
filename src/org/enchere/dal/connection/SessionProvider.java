package org.enchere.dal.connection;

import org.enchere.bo.Categorie;
import org.enchere.bo.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
	
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	
	public static synchronized Session getSession() {
		if(sessionFactory == null) {
			configuration = new Configuration().configure();
			configuration.addAnnotatedClass(Utilisateur.class);
			configuration.addAnnotatedClass(Categorie.class);
			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}
	
	

}
