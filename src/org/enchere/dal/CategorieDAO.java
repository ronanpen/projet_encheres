package org.enchere.dal;

import java.util.List;

import org.enchere.bo.Categorie;

public interface CategorieDAO {

	List<Categorie> selectAll() throws DALException;

}
