package org.enchere.bll.util;

import java.util.regex.Pattern;

import org.enchere.bll.BLLException;
import org.enchere.bll.ErrorCode;

public class CheckInputHelper {
	
	/**
	 * Utilisé pour vérifier si la chaine de caractère est nulle ou vide
	 * @param inputToCheck Chaine de caractère à vérifier
	 * @param errorMessage Message d'erreur à afficher si la vérification échoue
	 * @throws BLLException Si la chaine est nulle ou vide
	 */
	public static void checkInput(String inputToCheck, String errorMessage) throws BLLException{
		if(inputToCheck == null || inputToCheck.equalsIgnoreCase("")) {
			throw new BLLException(errorMessage);
		}
	}
	
	/**
	 * Utilisé pour vérifier la longueur d'une chaine de caractère sans minimum de taille
	 * @param inputToCheck Chaine de caractère à vérifier
	 * @param maxLength Taille maximum de la chaine
	 * @param errorMessage Message d'erreur à afficher si la vérification échoue
	 * @throws BLLException Si la chaine est plus grande que <code>maxLength</code>
	 */
	public static void checkInputLength(String inputToCheck, int maxLength, String errorMessage) throws BLLException{
		checkInputLength(inputToCheck, 0, maxLength, errorMessage);
	}
	
	/**
	 * Utilisé pour vérifier la longueur d'un chaine de caractère
	 * @param inputToCheck Chaine de caractère à vérifier
	 * @param minLength Taille minimum de la chaine
	 * @param maxLength Taille maximum de la chaine
	 * @param errorMessage Message d'erreur à afficher si la vérification échoue
	 * @throws BLLException Si la chaine est plus petite que <code>minLength</code> ou plus grande que <code>maxLength</code>
	 */
	public static void checkInputLength(String inputToCheck, int minLength, int maxLength, String errorMessage) throws BLLException{
		if(inputToCheck.length() > maxLength && inputToCheck.length() < minLength) {
			throw new BLLException(errorMessage);
		}
	}
	
	/**
	 * Utilisé pour vérifier si les mots de passe sont identiques
	 * @param password Mot de passe de l'utilisateur 
	 * @param password_2 Confirmation du mot de passe de l'utilisateur
	 * @throws BLLException Si les mots de passe ne sont pas identiques
	 */
	public static void isPasswordSame(String password, String password_2) throws BLLException{
		if(!password.equals(password_2)) throw new BLLException(ErrorCode.MOT_DE_PASSE_NON_IDENTIQUES);
	}
	
	/**
	 * Utilisé pour vérifier si le mot de passe est valide
	 * @param password Mot de passe de l'utilisateur
	 * @throws BLLException Si le mot de passe n'est pas renseigné ou inférieur à 8 caractères
	 * 			ou bien supérieur à 60 caractères
	 */
	public static void isPasswordValid(String password) throws BLLException {
		checkInput(password, "Le mot de passe doit être renseigné");
		
		checkInputLength(password, 8, 60, "Le mot de passe est inférieur à 8 caractères");
		
		//TODO Vérification présence minuscule, majuscule, chiffre, caracractère spéciale
	}
	
	/**
	 * Utilisé pour vérifier si le pseudo de l'utilisateur est valide
	 * @param username Pseudo de l'utilisateur
	 * @throws BLLException Si le pseudo n'est pas renseigné ou supérieur à 30 caractères
	 */
	public static void isUsernameValid(String username) throws BLLException{
		checkInput(username, "Le pseudo doit être renseigné");
		
		checkInputLength(username, 30, "Le pseudo doit faire moins de 30 caractères");
	}
	
	/**
	 * Utilisé pour vérifier si le nom de l'utilisateur est valide
	 * @param surname Nom de l'utilisateur
	 * @throws BLLException Si le nom n'est pas renseigné ou supérieur à 30 caractères
	 */
	public static void isSurnameValid(String surname) throws BLLException{
		checkInput(surname, "Le nom doit être renseigné");
		
		checkInputLength(surname, 30, "Le nom doit faire moins de 30 caractères");
	}
	
	/**
	 * Utilisé pour vérifier si le prénom de l'utilisateur est valide
	 * @param name Prénom de l'utilisateur
	 * @throws BLLException Si le prénom n'est pas renseigné ou supérieur à 30 caractères
	 */
	public static void isNameValid(String name) throws BLLException{
		checkInput(name, "Le prénom doit être renseigné");
		
		checkInputLength(name, 30, "Le prénom doit faire moins de 30 caractères");
	}
	
	/**
	 * Utilisé pour vérifier si le mail de l'utilisateur est valide
	 * @param email Mail de l'utilisateur
	 * @throws BLLException Si le mail n'est pas renseigné ou supérieur à 20 caractères<br>
	 * 			ou encore n'est pas au bon format (########@####.###).<br>
	 * 			L'extension du nom de domaine ne doit pas excéder 7 caractères
	 */
	public static void isMailValid(String email) throws BLLException{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
			                "[a-zA-Z0-9_+&*-]+)*@" + 
			                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
			                "A-Z]{2,7}$";
		
		checkInput(email, "Le mail doit être renseigné");
		
		checkInputLength(email, 20, "Le mail doit faire moins de 20 caractères");
		
		// Vérification mail valide
		if(!Pattern.matches(emailRegex, email)) throw new BLLException(ErrorCode.MAIL_INVALIDE);
	}
	
	/**
	 * Utilisé pour vérifier si le numéro de téléphone renseigné est valide
	 * @param phoneNumber Numéro de téléphone de l'utilisateur
	 * @throws BLLException Si le numéro de téléphone n'est pas au format 
	 */
	public static void isPhoneNumberValid(String phoneNumber) throws BLLException{
		String phoneNumberRegex = "[0-9]+";
		
		checkInputLength(phoneNumber, 10, 10, "Le numéro de téléphone doit faire 10 caractères");
		
		// Vérification téléphone valide
		if(!Pattern.matches(phoneNumberRegex, phoneNumber)) throw new BLLException(ErrorCode.NUMERO_TELEPHONE_INVALIDE);
	}
	
	/**
	 * Utilisé pour vérifier si le nom de la rue renseigné est valide
	 * @param road Le nom de la rue de l'utilisateur
	 * @throws BLLException Si le nom de la rue n'est pas renseigné ou supérieure à 30 caractères
	 */
	public static void isRoadValid(String road) throws BLLException{
		checkInput(road, "Le nom de rue doit être renseigné");
		
		checkInputLength(road, 30, "Le nom de rue doit faire moins de 30 caractères");
	}
	
	/**
	 * Utilisé pour vérifier si le code postal renseigné est valide
	 * @param postalCode Code postal de l'utilisateur
	 * @throws BLLException Si le code postal n'est pas renseigné ou supérieure à 10 caractères<br> 
	 * 			ou encore n'est pas au bon format (#####)
	 */
	public static void isPostalCodeValid(String postalCode) throws BLLException{
		checkInput(postalCode, "Le code postal doit être renseigné");
		
		checkInputLength(postalCode, 10, "Le code postal doit faire moins de 10 caractères");
		
		if(!Pattern.matches("[0-9]+{5}", postalCode)) throw new BLLException(ErrorCode.CODE_POSTAL_INVALIDE);
	}
	
	/**
	 * Utilisé pour vérifier si la ville renseigné est valide
	 * @param town Ville de l'utilisateur
	 * @throws BLLException Si la ville n'est pas renseigné ou supérieure à 30 caractères
	 */
	public static void isTownValid(String town) throws BLLException{
		checkInput(town, "La ville doit être renseigné");
		
		checkInputLength(town, 30, "La ville doit faire moins de 30 caractères");
	}
}
