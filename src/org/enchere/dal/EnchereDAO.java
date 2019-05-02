package org.enchere.dal;

import java.util.List;

import org.enchere.bo.Enchere;

public interface EnchereDAO {

	List<Enchere> selectByIdArticle(Integer idArticle) throws DALException;

	void insert(Enchere enchere) throws DALException;

}
