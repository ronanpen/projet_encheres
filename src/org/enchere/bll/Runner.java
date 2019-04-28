package org.enchere.bll;

import org.enchere.bo.Categorie;
import org.enchere.dal.CategorieDAO;
import org.enchere.dal.DALException;
import org.enchere.dal.DAOFactory;

public class Runner {
	public static void main(String[] args) {
		CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
		Categorie categorie = new Categorie("Informatique");
		
		try {
			categorieDAO.insert(categorie);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}
