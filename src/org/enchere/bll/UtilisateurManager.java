package org.enchere.bll;

import org.enchere.bll.util.CheckInputHelper;
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
	
	
	public Integer inscription(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String motDePasse2) throws BLLException {
		// V�rification des pseudo et mot de passe renseign� par l'utilisateur
		verificationInscription(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, motDePasse2);
		
		// Cr�ation d'un utilisateur avec les informations renseign�es
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, false);
		
		Integer idUtilisateur = null;
		try {
			// TODO Assigner la m�thode � l'id utilisateur
			this.utilisateurDAO.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Impossible d'ajouter l'utilisateur", e);
		}
		
		return idUtilisateur;
	}


	/**
	 * Utilis� pour cr�er la connexion aupr�s du serveur
	 * @param pseudo Pseudo de l'utilisateur
	 * @param motDePasse Mot de passe de l'utilisateur
	 * @throws BLLException
	 * @return null si aucun utilisateur trouv� ou mot de passe incorrect,<br> 
	 * 		sinon id utilisateur valoris� par la BDD
	 */
	public Integer connexion(String pseudo, String motDePasse, boolean seSouvenirDeMoi) throws BLLException {		
		// V�rification des pseudo et mot de passe renseign� par l'utilisateur
		verificationConnexion(pseudo, motDePasse);
		
		// Cr�ation d'un utilisateur avec les informations renseign�es
		Utilisateur utilisateur = new Utilisateur(pseudo, motDePasse);
		
		Integer idUtilisateur = null;
		try {
			idUtilisateur = this.utilisateurDAO.verificationConnexion(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Utilisateur ou mot de passe incorrect", e);
		}
		
		// TODO Syst�me de sauvegarde de donn�e utilisateur
		//if(seSouvenirDeMoi)
		
		return idUtilisateur;
	}
	
	/**
	 * V�rifie les informations saisie lors de la connexion
	 * @return true si les informations sont valide, false sinon
	 */
	private void verificationConnexion(String pseudo, String motDePasse) throws BLLException{
		boolean valid = true;
		String msg = "";
		
		// Gestion du cas d'erreur pseudo null ou champ vide
		if(pseudo == null || pseudo.equalsIgnoreCase("")) {
			msg += "Le pseudo doit �tre renseign�";
			valid = false;
		}
		// Gestion du cas d'erreur mot de passe null ou champ vide
		if(motDePasse == null || motDePasse.equalsIgnoreCase("")) {
			msg += "Le mot de passe doit �tre renseign�";
			valid = false;
		}
		
		if(!valid) {
			throw new BLLException(msg);
		}
	}
	
	/**
	 * V�rifie si les informations saisie lors de l'inscription
	 * @param pseudo Pseudo de l'utilisateur
	 * @param nom Nom de l'utilisateur
	 * @param prenom Pr�nom de l'utilisateur
	 * @param email Mail de l'utilisateur
	 * @param telephone Num�ro de t�l�phone de l'utilisateur au format (0#########)
	 * @param rue Nom de la rue de l'utilisateur
	 * @param codePostal Code postal de l'utilisateur au format (#####)
	 * @param ville Ville de l'utilisateur
	 * @param motDePasse Mot de passe de l'utilisateur
	 * @param motDePasse2 Confirmation du mot de passe de l'utilisateur
	 */
	private void verificationInscription(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, String motDePasse2) throws BLLException{
		// Gestion du cass d'erreur pseudo
		CheckInputHelper.isUsernameValid(pseudo);
		
		// Gestion du cas d'erreur nom
		CheckInputHelper.isSurnameValid(nom);
		
		// Gestion du cas d'erreur prenom
		CheckInputHelper.isNameValid(prenom);
		
		// Gestion du cas d'erreur email
		CheckInputHelper.isMailValid(email);
		
		// Gestion du cas d'erreur telephone
		CheckInputHelper.isPhoneNumberValid(telephone);
		
		// Gestion du cas d'erreur nom de rue
		CheckInputHelper.isRoadValid(rue);
		
		// Gestion du cas d'erreur code postal
		CheckInputHelper.isPostalCodeValid(codePostal);
		
		// Gestion du cas d'erreur ville
		CheckInputHelper.isTownValid(ville);
		
		//Gestion du cass d'erreur mot de passe
		CheckInputHelper.isPasswordValid(motDePasse);
		
		//Gestion du cass d'erreur mot de passe 2
		CheckInputHelper.isPasswordValid(motDePasse2);
		
		//Gestion du cass d'erreur mot de passe identiques
		CheckInputHelper.isPasswordSame(motDePasse, motDePasse2);
	}
	
	public static synchronized UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManager();
		}
		
		return utilisateurManager;
	}

}
