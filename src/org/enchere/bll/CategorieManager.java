package org.enchere.bll;

import java.util.List;

import org.enchere.bo.Categorie;
import org.enchere.dal.CategorieDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.DAOFactory;

public class CategorieManager {
	private static CategorieManager instance = null;
	private CategorieDAO categorieDAO;

	private CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieImpl();
	}

	public List<Categorie> recupererCategories() throws BLLException {

		List<Categorie> listeCategorie = null;

		try {
			listeCategorie = this.categorieDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("impossible de récupérer la liste des catégories", e);
		}
		return listeCategorie;
	}
	
	public static synchronized CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

}
