package org.enchere.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.enchere.bo.ArticleVendu;
import org.enchere.bo.Categorie;
import org.enchere.bo.Retrait;
import org.enchere.bo.Utilisateur;
import org.enchere.dal.ArticleVenduDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.DAOFactory;

public class ArticleManager {
	private static ArticleManager instance = null;
	private ArticleVenduDAO articleVenduDAO = null;
	
	private ArticleManager() {
		this.articleVenduDAO = DAOFactory.getArticleVenduImpl();
	}
	
	public void ajouterArticle(ArticleVendu article) throws BLLException{
		try {
			this.articleVenduDAO.insert(article);
		} catch(DALException dale) {
			throw new BLLException("Impossible d'ajouter un article", dale);
		}
	}
	
	public List<ArticleVendu> recupererArticles() throws BLLException{
		List<ArticleVendu> articles = new ArrayList<>();
		
		try {
			articles = this.articleVenduDAO.selectAll();
		} catch(DALException dale) {
			throw new BLLException("Impossible de récupérer la liste des articles", dale);
		}
		
		return articles;
	}

	public ArticleVendu recupererArticleParId(Integer idArticle) throws BLLException{
		ArticleVendu article = null;
		
		try {
			article = this.articleVenduDAO.selectById(idArticle);
		} catch (DALException dale) {
			throw new BLLException("Impossible de récuperer l'article avec cet id", dale);
		}
		
		return article;
	}
	
	public void modifierArticle(Integer idArticle, String nomArticle, String description, 
								LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
								int miseAPrix, Integer prixVente, Utilisateur utilisateur, 
								Retrait retrait, Categorie categorie) throws BLLException {
		
		verificationTotale(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, utilisateur, retrait, categorie);
		
		ArticleVendu article = new ArticleVendu(idArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, utilisateur, retrait, categorie);
		
		try {
			this.articleVenduDAO.update(article);
		} catch(DALException dale) {
			throw new BLLException("Impossible de modifier l'article", dale);
		}
	}

	public void supprimerArticle(Integer idArticle) throws BLLException{
		try {
			this.articleVenduDAO.delete(idArticle);
		} catch(DALException dale) {
			throw new BLLException("Impossible de supprimer l'article", dale);
		}
	}
	
	private void verificationTotale(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, Integer prixVente, Utilisateur utilisateur, Retrait retrait,
			Categorie categorie) throws BLLException{
		// TODO Vérification champs article
	}
	
	public static synchronized ArticleManager getInstance() {
		if(instance == null) {
			instance = new ArticleManager();
		}
		
		return instance;
	}
}
