package org.enchere.dal.impl;

import java.util.List;

import org.enchere.bo.Categorie;
import org.enchere.dal.CategorieDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;

public class CategorieHibernateImpl implements CategorieDAO {

	@Override
	public List<Categorie> selectAll() throws DALException {
		List<Categorie> listCategorie = null;
		Session session = SessionProvider.getSession();
		listCategorie = session.createQuery("FROM Categories", Categorie.class).list();

		session.close();

		return listCategorie;
	}
}
