package org.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import org.enchere.bo.ArticleVendu;
import org.enchere.bo.Enchere;
import org.enchere.bo.Utilisateur;
import org.enchere.dal.DALException;
import org.enchere.dal.DAOFactory;
import org.enchere.dal.EnchereDAO;

public class EnchereManager {
	private static EnchereManager instance = null;
	// Manager
	private UtilisateurManager utilisateurManager = null;
	private ArticleManager articleManager = null;
	// DAO
	private EnchereDAO enchereDAO = null;
	
	public EnchereManager() {
		this.utilisateurManager = UtilisateurManager.getInstance();
		this.articleManager = ArticleManager.getInstance();
		this.enchereDAO = DAOFactory.getEnchereImpl();
	}

	public List<Enchere> recupererEncheresParIdArticle(Integer idArticle) throws BLLException{
		List<Enchere> encheres = new ArrayList<>();
		
		try {
			encheres = this.enchereDAO.selectByIdArticle(idArticle);
		} catch (DALException dale) {
			throw new BLLException("Impossible de récuperer les enchères liés à cet article", dale);
		}
		
		return encheres;
	}

	public void ajouterEnchere(Integer idArticle, Integer prixPropose, Integer idUtilisateur) throws BLLException{
		Utilisateur utilisateur = null;
		ArticleVendu article = null;
		
		// Récupérer utilisateur par son id
		utilisateur = utilisateurManager.recupererProfilParId(idUtilisateur);
		
		// Récupérer l'article par son id
		article = articleManager.recupererArticleParId(idArticle);
		
		verificationEnchere(prixPropose, article);
		
		Enchere enchere = new Enchere(utilisateur, article, prixPropose);
		
		try {
			this.enchereDAO.insert(enchere);
		} catch (DALException dale) {
			throw new BLLException("Impossible d'enregistrer l'enchère", dale);
		}
	}
	
	public void verificationEnchere(Integer prixPropose, ArticleVendu article) throws BLLException {
		if(prixPropose <= article.getPrixVente()) {
			throw new BLLException(ErrorCode.PRIX_ENCHERE_INFERIEUR_OU_EGAL_PRIX_ACTUEL);
		}
	}
	
	public static synchronized EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
}
