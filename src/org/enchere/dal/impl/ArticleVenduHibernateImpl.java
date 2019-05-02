package org.enchere.dal.impl;

import java.util.List;

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

	@Override
	public ArticleVendu selectById(Integer idArticle) throws DALException {
		return null;
	}

	@Override
	public void update(ArticleVendu article) throws DALException {
		
	}

	@Override
	public void delete(Integer idArticle) throws DALException {
		
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		return null;
	}
}
