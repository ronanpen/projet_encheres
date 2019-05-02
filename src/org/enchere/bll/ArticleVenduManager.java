package org.enchere.bll;

import java.util.Date;

import org.enchere.bo.ArticleVendu;
import org.enchere.dal.ArticleVenduDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.DAOFactory;

public class ArticleVenduManager {

	private ArticleVenduDAO articleVenduDAO;

	private ArticleVenduManager() {
		this.articleVenduDAO = DAOFactory.getArticleVenduImpl();
	}

	public Integer ArticleVendu(Integer idArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int prixInitial, int prixVente) {

		ArticleVendu articleVendu = new ArticleVendu(idArticle, nomArticle, description, dateDebutEncheres,
				dateFinEncheres, prixInitial, prixVente);

		Integer idArticleVendu = null;
		try {
			idArticleVendu = this.articleVenduDAO.insert(articleVendu);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idArticleVendu;
	}

	// public ArticleVendu RecupererArticleParId(Integer idArticle) {
	// ArticleVendu articleVendu = null;
	// articleVendu = this.articleVenduDAO.selectById(idArticle);
	// return articleVendu;
	// }

}
