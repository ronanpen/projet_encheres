package org.enchere.dal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.enchere.bo.Categorie;
import org.enchere.dal.CategorieDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;

public class CategorieHibernateImpl implements CategorieDAO {

	@Override
	public List<Categorie> selectAll() throws DALException {
		List<Categorie> listCategorie = new ArrayList<Categorie>();
		Session session = SessionProvider.getSession();
		Query query = session.createQuery("FROM CATEGORIES");

		listCategorie = query.getResultList();

		session.close();

		return listCategorie;

	}
}
