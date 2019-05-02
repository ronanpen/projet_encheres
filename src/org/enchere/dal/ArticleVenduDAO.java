package org.enchere.dal;

import java.util.List;

import org.enchere.bo.ArticleVendu;

public interface ArticleVenduDAO {
	Integer insert(ArticleVendu article) throws DALException;

	ArticleVendu selectById(Integer idArticle) throws DALException;

	void update(ArticleVendu article) throws DALException;

	void delete(Integer idArticle) throws DALException;

	List<ArticleVendu> selectAll() throws DALException;
}
