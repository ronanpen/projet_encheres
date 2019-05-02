package org.enchere.dal;

import org.enchere.dal.impl.ArticleVenduHibernateImpl;
import org.enchere.dal.impl.CategorieHibernateImpl;
import org.enchere.dal.impl.UtilisateurHibernateImpl;

public abstract class DAOFactory {
	public static UtilisateurDAO getUtilisateurImpl() {
		return new UtilisateurHibernateImpl();
	}

	public static ArticleVenduDAO getArticleVenduImpl() {
		return new ArticleVenduHibernateImpl();
	}

	public static CategorieDAO getCategorieImpl() {
		return new CategorieHibernateImpl();
	}
}
