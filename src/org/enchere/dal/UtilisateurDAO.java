package org.enchere.dal;

import java.util.List;

import org.enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	void insert(Utilisateur utilisateur) throws DALException;
	
	List<Utilisateur> selectAll() throws DALException;
	
	Utilisateur selectById(int id) throws DALException;
	
	boolean verificationConnexion(Utilisateur utilisateur) throws DALException;
	
	
}
