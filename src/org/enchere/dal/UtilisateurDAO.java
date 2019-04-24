package org.enchere.dal;

import java.util.List;

import org.enchere.bo.Utilisateurs;

public interface UtilisateurDAO {

	void insert(Utilisateurs utilisateur) throws DALException;
	
	List<Utilisateurs> selectAll() throws DALException;
	
	Utilisateurs selectById(int id) throws DALException;
	
	Integer verificationConnexion(Utilisateurs utilisateur) throws DALException;
	
	
}
