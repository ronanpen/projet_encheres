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
	
	
	public Utilisateur inscription(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			Integer codePostal, String ville, String motDePasse, String motDePasse2) {
		// Vérification des pseudo et mot de passe renseigné par l'utilisateur
		verificationInscription(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, motDePasse2);
		
		// Création d'un utilisateur avec les informations renseignées
		Utilisateur utilisateur = new Utilisateur(pseudo, motDePasse);
		
		
		return null;
	}


	/**
	 * Utilisé pour créer la connexion auprès du serveur
	 * @param pseudo Pseudo de l'utilisateur
	 * @param motDePasse Mot de passe de l'utilisateur
	 * @throws BLLException
	 * @return null si aucun utilisateur trouvé ou mot de passe incorrect,<br> 
	 * 		sinon instance d'utilisateur valorisé avec les données du système de persistance
	 */
	public Utilisateur connexion(String pseudo, String motDePasse, boolean seSouvenirDeMoi) throws BLLException {		
		// Vérification des pseudo et mot de passe renseigné par l'utilisateur
		verificationConnexion(pseudo, motDePasse);
		
		// Création d'un utilisateur avec les informations renseignées
		Utilisateur utilisateur = new Utilisateur(pseudo, motDePasse);
		
		try {
			utilisateur = this.utilisateurDAO.verificationConnexion(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		// TODO Système de sauvegarde de donnée utilisateur
		//if(seSouvenirDeMoi)
		
		return utilisateur;
	}
	
	/**
	 * Vérifie les informations saisie lors de la connexion
	 * @return true si les informations sont valide, false sinon
	 */
	private void verificationConnexion(String pseudo, String motDePasse) throws BLLException{
		boolean valid = true;
		String msg = "";
		
		// Gestion du cas d'erreur pseudo null ou champ vide
		if(pseudo == null || pseudo.equalsIgnoreCase("")) {
			msg += "Le pseudo doit être renseigné\n";
			valid = false;
		}
		// Gestion du cas d'erreur mot de passe null ou champ vide
		if(motDePasse == null || motDePasse.equalsIgnoreCase("")) {
			msg += "Le mot de passe doit être renseigné";
			valid = false;
		}
		
		if(!valid) {
			throw new BLLException(msg);
		}
	}
	
	/**
	 * Vérifie si les informations saisie lors de l'inscription
	 * @param pseudo Pseudo de l'utilisateur
	 * @param nom Nom de l'utilisateur
	 * @param prenom Prénom de l'utilisateur
	 * @param email Mail de l'utilisateur
	 * @param telephone Numéro de téléphone de l'utilisateur au format (0#########)
	 * @param rue Nom de la rue de l'utilisateur
	 * @param codePostal Code postal de l'utilisateur au format (#####)
	 * @param ville Ville de l'utilisateur
	 * @param motDePasse Mot de passe de l'utilisateur
	 * @param motDePasse2 Confirmation du mot de passe de l'utilisateur
	 */
	private void verificationInscription(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, Integer codePostal, String ville, String motDePasse, String motDePasse2) {
		boolean valid = true;
		String msg = "";
		
		// Gestion du cas d'erreur pseudo null ou champ vide
		if(pseudo == null || pseudo.equalsIgnoreCase("")) {
			msg += "Le pseudo doit être renseigné\n";
			valid = false;
		}
		
		// Gestion du cas d'erreur nom null ou champ vide
		if(nom == null || nom.equalsIgnoreCase("")) {
			msg += "Le nom doit être renseigné\n";
			valid = false;
		}
		
		// Gestion du cas d'erreur prenom null ou champ vide
		if(prenom == null || prenom.equalsIgnoreCase("")) {
			msg += "Le prenom doit être renseigné\n";
			valid = false;
		}
		
		// Gestion du cas d'erreur email null ou champ vide
		if(email == null || email.equalsIgnoreCase("")) {
			msg += "Le email doit être renseigné\n";
			valid = false;
		}
		
		// Gestion du cas d'erreur telephone null ou champ vide
		if(telephone == null || telephone.equalsIgnoreCase("")) {
			msg += "Le numéro de téléphone doit être renseigné\n";
			valid = false;
		} else {
			if(telephone.length() != 10) {
				msg += "Le numéro de téléphone ne respecte pas le format standard(10 chiffres)\n";
				valid = false;
			}
			if(!telephone.matches("[0-9]+")) {
				msg += "Le numéro de téléphone ne respecte pas le format standard(10 chiffres)\n";
				valid = false;
			}
		}
		
		// Gestion du cass d'erreur pseudo null ou champ vide
		if(rue == null || rue.equalsIgnoreCase("")) {
			msg += "Le nom de rue doit être renseigné\n";
			valid = false;
		}
	}
	
	public static synchronized UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManager();
		}
		
		return utilisateurManager;
	}

}
