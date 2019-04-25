package org.enchere.dal;

import java.util.List;

import org.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	/**
	 * Utilisé pour insérer un utilisateur dans le système de persistance
	 * @param utilisateur Utilisateur à insérer
	 * @return id de l'utilisateur inséré
	 * @throws DALException
	 */
	Integer insert(Utilisateur utilisateur) throws DALException;
	
	/**
	 * Utilisé pour récupérer la liste des utilisateurs présent dans le système de persistance
	 * @return liste de tous les utilisateurs
	 * @throws DALException
	 */
	List<Utilisateur> selectAll() throws DALException;
	
	/**
	 * Utilisé pour selectionner l'utilisateur avec l'id <code>id</code> dans le système de persistance
	 * @param id Id de l'utilisateur
	 * @return l'utilisateur avec l'id <code>id</code>
	 * @throws DALException
	 */
	Utilisateur selectById(int id) throws DALException;
	
	/**
	 * Utilisé pour selectionner l'utilisateur avec le pseudo <code>pseudo</code> dans le système de persistance
	 * @param pseudo Pseudo de l'utilisateur
	 * @return l'utilisateur avec le pseudo <code>pseudo</code>
	 * @throws DALException
	 */
	Utilisateur selectByPseudo(String pseudo) throws DALException;
	
	/**
	 * Utilisé pour selectionner l'utilisateur avec le mail <code>mail</code> dans le système de persistance
	 * @param mail Mail de l'utilisateur
	 * @return l'utilisateur avec le mail <code>mail</code>
	 * @throws DALException
	 */
	Utilisateur selectByMail(String mail) throws DALException;
	
	/**
	 * Utilisé pour vérifier la connexion de l'utilisateur
	 * @param utilisateur Utilisateur voulant se connecter
	 * @param isMail Si l'identifiant de l'utilisateur est un mail
	 * @return id de l'utilisateur si la connexion est validée
	 * @throws DALException
	 */
	Integer verificationConnexion(Utilisateur utilisateur, boolean isMail) throws DALException;
	
	/**
	 * Utilisé pour modifier l'utilisateur dans le système de persistance
	 * @param utilisateur Utilisateur à modifier
	 * @throws DALException
	 */
	void update(Utilisateur utilisateur) throws DALException;
	
	/**
	 * Utilisé pour supprimer l'utilisateur dans le système de persistance
	 * @param idUtilisateur Id de l'utilisateur
	 * @throws DALException
	 */
	void delete(Integer idUtilisateur) throws DALException;
}
