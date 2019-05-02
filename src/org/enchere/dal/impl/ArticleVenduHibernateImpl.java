package org.enchere.dal.impl;

import java.util.List;

import org.enchere.bo.ArticleVendu;
import org.enchere.dal.ArticleVenduDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;

public class ArticleVenduHibernateImpl implements ArticleVenduDAO {

	@Override
	public Integer insert(ArticleVendu articleVendu) throws DALException {

		Session session = SessionProvider.getSession();

		session.beginTransaction();
		session.save(articleVendu);
		session.getTransaction().commit();
		session.close();

		return articleVendu.getIdArticle();
	}

	@Override
	public List<ArticleVendu> selectAll() {
		return null;
	}

	@Override
	public ArticleVendu selectById(Integer idArticle) {
		Session session = SessionProvider.getSession();
		session.beginTransaction();
		ArticleVendu articleVendu = session.get(ArticleVendu.class, idArticle);
		if (articleVendu == null)
			session.getTransaction().rollback();
		else
			session.getTransaction().commit();
		session.close();
		return articleVendu;
	}

}
