package org.enchere.bll;

import org.enchere.bo.Utilisateur;
import org.enchere.dal.DALException;
import org.enchere.dal.DAOFactory;
import org.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	private static UtilisateurManager utilisateurManager;
	private UtilisateurDAO utilisateurDAO;
	
	private UtilisateurManager() {
		// Initialisation de la factory d'utilisateur
		this.utilisateurDAO = DAOFactory.getUtilisateurImpl();
	}
	
	/**
	 * Utilis� pour cr�er la connexion aupr�s du serveur
	 * @param pseudo Pseudo de l'utilisateur
	 * @param motDePasse Mot de passe de l'utilisateur
	 * @throws BLLException
	 * @return true si le couple pseudo-motDePasse set valide, false sinon
	 */
	public boolean connexion(String pseudo, String motDePasse, boolean seSouvenirDeMoi) throws BLLException {
		boolean connexionAutorise = false;
		
		// V�rification des pseudo et mot de passe renseign� par l'utilisateur
		verificationConnexion(pseudo, motDePasse);
		
		// Cr�ation d'un utilisateur avec les informations renseign�es
		Utilisateur utilisateur = new Utilisateur(pseudo, motDePasse);
		
		try {
			connexionAutorise =  this.utilisateurDAO.verificationConnexion(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		// TODO Syst�me de sauvegarde de donn�e utilisateur
		//if(seSouvenirDeMoi)
		
		return connexionAutorise;
	}
	
	/**
	 * V�rifie si le mot de passe renseign� n'est pas null ou vide
	 * @return true si le pseudo est valide, false sinon
	 */
	public void verificationConnexion(String pseudo, String motDePasse) throws BLLException{
		boolean valid = true;
		String msg = "";
		
		// Gestion du cas d'erreur pseudo null ou champ vide
		if(pseudo == null || pseudo.equalsIgnoreCase("")) {
			msg += "Le pseudo doit �tre renseign�\n";
		}
		// Gestion du cas d'erreur mot de passe null ou champ vide
		if(motDePasse == null || motDePasse.equalsIgnoreCase("")) {
			msg += "Le mot de passe doit �tre renseign�";
		}
		
		if(!valid) {
			throw new BLLException(msg);
		}
	}
	
	public static synchronized UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManager();
		}
		
		return utilisateurManager;
	}

}
