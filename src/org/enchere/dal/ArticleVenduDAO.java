package org.enchere.dal;

import java.util.List;

import org.enchere.bo.ArticleVendu;

public interface ArticleVenduDAO {

	Integer insert(ArticleVendu articleVendu) throws DALException;

	List<ArticleVendu> selectAll();

	ArticleVendu selectById(Integer idArticle);

}
