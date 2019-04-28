package org.enchere.dal.impl;

import org.enchere.bo.Categorie;
import org.enchere.dal.CategorieDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;

public class CategorieHibernateImpl implements CategorieDAO {

	@Override
	public Integer insert(Categorie categorie) throws DALException {
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		session.close();
		
		return categorie.getIdCategorie();
	}

}
