package org.enchere.dal.impl;

import org.enchere.bo.ArticleVendu;
import org.enchere.dal.ArticleVenduDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;

public class ArticleVenduHibernateImpl implements ArticleVenduDAO {
	@Override
	public Integer insert(ArticleVendu article) throws DALException{
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();
		session.close();
		
		return article.getIdArticle();
	}
}
