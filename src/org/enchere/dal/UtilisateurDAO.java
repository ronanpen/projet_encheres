package org.enchere.dal;

import java.util.List;

import org.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	Integer insert(Utilisateur utilisateur) throws DALException;
	
	List<Utilisateur> selectAll() throws DALException;
	
	Utilisateur selectById(int id) throws DALException;
	
	Utilisateur selectByPseudo(String pseudo) throws DALException;
	
	Utilisateur selectByMail(String mail) throws DALException;
	
	Integer verificationConnexion(Utilisateur utilisateur, boolean isMail) throws DALException;
	
	
}
