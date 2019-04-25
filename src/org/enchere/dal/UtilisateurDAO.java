package org.enchere.dal;

import java.util.List;

import org.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	/**
	 * Utilis� pour ins�rer un utilisateur dans le syst�me de persistance
	 * @param utilisateur Utilisateur � ins�rer
	 * @return id de l'utilisateur ins�r�
	 * @throws DALException
	 */
	Integer insert(Utilisateur utilisateur) throws DALException;
	
	/**
	 * Utilis� pour r�cup�rer la liste des utilisateurs pr�sent dans le syst�me de persistance
	 * @return liste de tous les utilisateurs
	 * @throws DALException
	 */
	List<Utilisateur> selectAll() throws DALException;
	
	/**
	 * Utilis� pour selectionner l'utilisateur avec l'id <code>id</code> dans le syst�me de persistance
	 * @param id Id de l'utilisateur
	 * @return l'utilisateur avec l'id <code>id</code>
	 * @throws DALException
	 */
	Utilisateur selectById(int id) throws DALException;
	
	/**
	 * Utilis� pour selectionner l'utilisateur avec le pseudo <code>pseudo</code> dans le syst�me de persistance
	 * @param pseudo Pseudo de l'utilisateur
	 * @return l'utilisateur avec le pseudo <code>pseudo</code>
	 * @throws DALException
	 */
	Utilisateur selectByPseudo(String pseudo) throws DALException;
	
	/**
	 * Utilis� pour selectionner l'utilisateur avec le mail <code>mail</code> dans le syst�me de persistance
	 * @param mail Mail de l'utilisateur
	 * @return l'utilisateur avec le mail <code>mail</code>
	 * @throws DALException
	 */
	Utilisateur selectByMail(String mail) throws DALException;
	
	/**
	 * Utilis� pour v�rifier la connexion de l'utilisateur
	 * @param utilisateur Utilisateur voulant se connecter
	 * @param isMail Si l'identifiant de l'utilisateur est un mail
	 * @return id de l'utilisateur si la connexion est valid�e
	 * @throws DALException
	 */
	Integer verificationConnexion(Utilisateur utilisateur, boolean isMail) throws DALException;
	
	/**
	 * Utilis� pour modifier l'utilisateur dans le syst�me de persistance
	 * @param utilisateur Utilisateur � modifier
	 * @throws DALException
	 */
	void update(Utilisateur utilisateur) throws DALException;
	
	/**
	 * Utilis� pour supprimer l'utilisateur dans le syst�me de persistance
	 * @param idUtilisateur Id de l'utilisateur
	 * @throws DALException
	 */
	void delete(Integer idUtilisateur) throws DALException;
}
