package org.enchere.dal;

import org.enchere.bo.Categorie;

public interface CategorieDAO {
	Integer insert(Categorie categorie) throws DALException;
}
