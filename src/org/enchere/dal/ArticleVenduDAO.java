package org.enchere.dal;

import org.enchere.bo.ArticleVendu;

public interface ArticleVenduDAO {
	Integer insert(ArticleVendu article) throws DALException;
}
