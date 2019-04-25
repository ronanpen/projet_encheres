package org.enchere.bll;

import org.enchere.bll.util.CheckInputHelper;
import org.enchere.bo.Utilisateur;
import org.enchere.dal.DALException;
import org.enchere.dal.DAOFactory;
import org.enchere.dal.UtilisateurDAO;
import org.mindrot.jbcrypt.BCrypt;

public class UtilisateurManager {
	private static final int NB_ROUNDS = 13;
	private static UtilisateurManager utilisateurManager;
	private UtilisateurDAO utilisateurDAO;
	
	private UtilisateurManager() {
		// Initialisation de la dao d'utilisateur
		this.utilisateurDAO = DAOFactory.getUtilisateurImpl();
	}
	
	
	/**
	 * Utilis� pour cr�er un utilisateur aupr�s du serveur
	 * @param pseudo Pseudo de l'utilisateur
	 * @param nom Nom de l'utilisateur
	 * @param prenom Pr�nom de l'utilisateur
	 * @param email Mail de l'utilisateur
	 * @param telephone T�l�phone de l'utilisateur
	 * @param rue Le nom de la rue de l'utilisateur
	 * @param codePostal Le code postal de l'utilisateur
	 * @param ville La ville de l'utilisateur
	 * @param motDePasse Le mot de passe de l'utilisateur
	 * @param motDePasse2 La confirmation du mot de passe de l'utilisateur
	 * @return l'id utilisateur valoris� par le syst�me de persistance 
	 * 			ou null si l'op�ration d'ajout � �chou�e
	 * @throws BLLException
	 */
	public Integer inscription(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String motDePasse2) throws BLLException {
		// V�rification des informations renseign�es par l'utilisateur
		verificationTotale(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, motDePasse2);
		
		// Cr�ation d'un utilisateur avec les informations renseign�es
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		
		// Hash du mot de passe
		utilisateur.setMotDePasse(BCrypt.hashpw(motDePasse, BCrypt.gensalt(NB_ROUNDS)));
		
		Integer idUtilisateur = null;
		try {
			idUtilisateur = this.utilisateurDAO.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException("Impossible d'ajouter l'utilisateur", e);
		}
		
		return idUtilisateur;
	}


	/**
	 * Utilis� pour cr�er la connexion aupr�s du serveur
	 * @param identifiant Identifiant de l'utilisateur (Pseudo ou mail)
	 * @param motDePasse Mot de passe de l'utilisateur
	 * @return null si aucun utilisateur trouv� ou mot de passe incorrect,<br> 
	 * 			sinon id utilisateur valoris� par le syst�me de persistance
	 * @throws BLLException
	 */
	public Integer connexion(String identifiant, String motDePasse, boolean seSouvenirDeMoi) throws BLLException {	
		Utilisateur utilisateur = new Utilisateur();
		boolean mail = true;
		
		// V�rification si l'identifiant est un mail ou un pseudo
		try {
			CheckInputHelper.isMailValid(identifiant);
		} catch(BLLException blle) {
			mail = false;
		}
		
		// V�rification des informations renseign�s
		verificationConnexion(identifiant, motDePasse, mail, utilisateur);
		
		Integer idUtilisateur = null;
		try {
			idUtilisateur = this.utilisateurDAO.verificationConnexion(utilisateur, mail);
		} catch (DALException e) {
			throw new BLLException("Utilisateur ou mot de passe incorrect", e);
		}
		
		// TODO Syst�me de sauvegarde de donn�e utilisateur
		// if(seSouvenirDeMoi)
		
		return idUtilisateur;
	}
	
	/**
	 * Utilis� pour v�rifier les informations de connexion
	 * @param identifiant Identiant de l'utilisateur (Pseudo ou mail)
	 * @param motDePasse Mot de passe de l'utilisateur
	 * @param isMail Si l'identifiant est un mail
	 * @param utilisateur Instance d'utilisateur � valoriser
	 */
	private void verificationConnexion(String identifiant, String motDePasse, boolean isMail, Utilisateur utilisateur) {
		// Si pr�sence de pseudo comme identifiant
		if(!isMail) {
			// Gestion du cas d'erreur pseudo 
			try {
				CheckInputHelper.isUsernameValid(identifiant);
			} catch(BLLException blle) {
				blle.printStackTrace();
			}
			
			utilisateur.setPseudo(identifiant);
		} else {
			utilisateur.setEmail(identifiant);
		}
		
		// Gestion du cas d'erreur mot de passe 
		try {
			CheckInputHelper.isPasswordValid(motDePasse);
		} catch(BLLException blle) {
			blle.printStackTrace();
		}
		
		utilisateur.setMotDePasse(motDePasse);
	}
	
	/**
	 * Utilis� pour v�rifier les informations d'un utilisateur
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
	 * @throws BLLException
	 */
	private void verificationTotale(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, String motDePasse2) throws BLLException{
		boolean error = false;
		
		// Gestion du cass d'erreur pseudo
		try {
			CheckInputHelper.isUsernameValid(pseudo);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}

		
		// Gestion du cas d'erreur nom
		try {
			CheckInputHelper.isSurnameValid(nom);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		// Gestion du cas d'erreur prenom
		try {
			CheckInputHelper.isNameValid(prenom);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		// Gestion du cas d'erreur email
		try {
			CheckInputHelper.isMailValid(email);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		// Gestion du cas d'erreur telephone
		try {
			CheckInputHelper.isPhoneNumberValid(telephone);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		// Gestion du cas d'erreur nom de rue
		try {
			CheckInputHelper.isRoadValid(rue);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		// Gestion du cas d'erreur code postal
		try {
			CheckInputHelper.isPostalCodeValid(codePostal);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		// Gestion du cas d'erreur ville
		try {
			CheckInputHelper.isTownValid(ville);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		//Gestion du cass d'erreur mot de passe
		try {
			CheckInputHelper.isPasswordValid(motDePasse);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		//Gestion du cass d'erreur mot de passe 2
		try {
			CheckInputHelper.isPasswordValid(motDePasse2);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		//Gestion du cass d'erreur mot de passe identiques
		try {
			CheckInputHelper.isPasswordSame(motDePasse, motDePasse2);
		} catch(BLLException blle) {
			blle.printStackTrace();
			error = true;
		}
		
		if(error) {
			throw new BLLException("V�rification des donn�es de l'utilisateur �chou�e");
		}
	}
	
	public static synchronized UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManager();
		}
		
		return utilisateurManager;
	}

}
