package org.enchere.dal.impl;

import java.util.List;

import org.enchere.bo.Enchere;
import org.enchere.dal.DALException;
import org.enchere.dal.EnchereDAO;

public class EnchereHibernateImpl implements EnchereDAO {

	@Override
	public List<Enchere> selectByIdArticle(Integer idArticle) throws DALException {
		return null;
	}

	@Override
	public void insert(Enchere enchere) throws DALException {
		
	}

}
