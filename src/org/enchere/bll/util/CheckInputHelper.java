package org.enchere.bll.util;

import java.util.regex.Pattern;

import org.enchere.bll.BLLException;
import org.enchere.bll.ErrorCode;

public class CheckInputHelper {
	
	/**
	 * Utilis� pour v�rifier si la chaine de caract�re est nulle ou vide
	 * @param inputToCheck Chaine de caract�re � v�rifier
	 * @param errorMessage Message d'erreur � afficher si la v�rification �choue
	 * @throws BLLException Si la chaine est nulle ou vide
	 */
	public static void checkInput(String inputToCheck, String errorMessage) throws BLLException{
		if(inputToCheck == null || inputToCheck.equalsIgnoreCase("")) {
			throw new BLLException(errorMessage);
		}
	}
	
	/**
	 * Utilis� pour v�rifier la longueur d'une chaine de caract�re sans minimum de taille
	 * @param inputToCheck Chaine de caract�re � v�rifier
	 * @param maxLength Taille maximum de la chaine
	 * @param errorMessage Message d'erreur � afficher si la v�rification �choue
	 * @throws BLLException Si la chaine est plus grande que <code>maxLength</code>
	 */
	public static void checkInputLength(String inputToCheck, int maxLength, String errorMessage) throws BLLException{
		checkInputLength(inputToCheck, 0, maxLength, errorMessage);
	}
	
	/**
	 * Utilis� pour v�rifier la longueur d'un chaine de caract�re
	 * @param inputToCheck Chaine de caract�re � v�rifier
	 * @param minLength Taille minimum de la chaine
	 * @param maxLength Taille maximum de la chaine
	 * @param errorMessage Message d'erreur � afficher si la v�rification �choue
	 * @throws BLLException Si la chaine est plus petite que <code>minLength</code> ou plus grande que <code>maxLength</code>
	 */
	public static void checkInputLength(String inputToCheck, int minLength, int maxLength, String errorMessage) throws BLLException{
		if(inputToCheck.length() > maxLength && inputToCheck.length() < minLength) {
			throw new BLLException(errorMessage);
		}
	}
	
	/**
	 * Utilis� pour v�rifier si les mots de passe sont identiques
	 * @param password Mot de passe de l'utilisateur 
	 * @param password_2 Confirmation du mot de passe de l'utilisateur
	 * @throws BLLException Si les mots de passe ne sont pas identiques
	 */
	public static void isPasswordSame(String password, String password_2) throws BLLException{
		if(!password.equals(password_2)) throw new BLLException(ErrorCode.MOT_DE_PASSE_NON_IDENTIQUES);
	}
	
	/**
	 * Utilis� pour v�rifier si le mot de passe est valide
	 * @param password Mot de passe de l'utilisateur
	 * @throws BLLException Si le mot de passe n'est pas renseign� ou inf�rieur � 8 caract�res
	 * 			ou bien sup�rieur � 60 caract�res
	 */
	public static void isPasswordValid(String password) throws BLLException {
		checkInput(password, "Le mot de passe doit �tre renseign�");
		
		checkInputLength(password, 8, 60, "Le mot de passe est inf�rieur � 8 caract�res");
		
		//TODO V�rification pr�sence minuscule, majuscule, chiffre, caracract�re sp�ciale
	}
	
	/**
	 * Utilis� pour v�rifier si le pseudo de l'utilisateur est valide
	 * @param username Pseudo de l'utilisateur
	 * @throws BLLException Si le pseudo n'est pas renseign� ou sup�rieur � 30 caract�res
	 */
	public static void isUsernameValid(String username) throws BLLException{
		checkInput(username, "Le pseudo doit �tre renseign�");
		
		checkInputLength(username, 30, "Le pseudo doit faire moins de 30 caract�res");
	}
	
	/**
	 * Utilis� pour v�rifier si le nom de l'utilisateur est valide
	 * @param surname Nom de l'utilisateur
	 * @throws BLLException Si le nom n'est pas renseign� ou sup�rieur � 30 caract�res
	 */
	public static void isSurnameValid(String surname) throws BLLException{
		checkInput(surname, "Le nom doit �tre renseign�");
		
		checkInputLength(surname, 30, "Le nom doit faire moins de 30 caract�res");
	}
	
	/**
	 * Utilis� pour v�rifier si le pr�nom de l'utilisateur est valide
	 * @param name Pr�nom de l'utilisateur
	 * @throws BLLException Si le pr�nom n'est pas renseign� ou sup�rieur � 30 caract�res
	 */
	public static void isNameValid(String name) throws BLLException{
		checkInput(name, "Le pr�nom doit �tre renseign�");
		
		checkInputLength(name, 30, "Le pr�nom doit faire moins de 30 caract�res");
	}
	
	/**
	 * Utilis� pour v�rifier si le mail de l'utilisateur est valide
	 * @param email Mail de l'utilisateur
	 * @throws BLLException Si le mail n'est pas renseign� ou sup�rieur � 20 caract�res<br>
	 * 			ou encore n'est pas au bon format (########@####.###).<br>
	 * 			L'extension du nom de domaine ne doit pas exc�der 7 caract�res
	 */
	public static void isMailValid(String email) throws BLLException{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
			                "[a-zA-Z0-9_+&*-]+)*@" + 
			                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
			                "A-Z]{2,7}$";
		
		checkInput(email, "Le mail doit �tre renseign�");
		
		checkInputLength(email, 20, "Le mail doit faire moins de 20 caract�res");
		
		// V�rification mail valide
		if(!Pattern.matches(emailRegex, email)) throw new BLLException(ErrorCode.MAIL_INVALIDE);
	}
	
	/**
	 * Utilis� pour v�rifier si le num�ro de t�l�phone renseign� est valide
	 * @param phoneNumber Num�ro de t�l�phone de l'utilisateur
	 * @throws BLLException Si le num�ro de t�l�phone n'est pas au format 
	 */
	public static void isPhoneNumberValid(String phoneNumber) throws BLLException{
		String phoneNumberRegex = "[0-9]+";
		
		checkInputLength(phoneNumber, 10, 10, "Le num�ro de t�l�phone doit faire 10 caract�res");
		
		// V�rification t�l�phone valide
		if(!Pattern.matches(phoneNumberRegex, phoneNumber)) throw new BLLException(ErrorCode.NUMERO_TELEPHONE_INVALIDE);
	}
	
	/**
	 * Utilis� pour v�rifier si le nom de la rue renseign� est valide
	 * @param road Le nom de la rue de l'utilisateur
	 * @throws BLLException Si le nom de la rue n'est pas renseign� ou sup�rieure � 30 caract�res
	 */
	public static void isRoadValid(String road) throws BLLException{
		checkInput(road, "Le nom de rue doit �tre renseign�");
		
		checkInputLength(road, 30, "Le nom de rue doit faire moins de 30 caract�res");
	}
	
	/**
	 * Utilis� pour v�rifier si le code postal renseign� est valide
	 * @param postalCode Code postal de l'utilisateur
	 * @throws BLLException Si le code postal n'est pas renseign� ou sup�rieure � 10 caract�res<br> 
	 * 			ou encore n'est pas au bon format (#####)
	 */
	public static void isPostalCodeValid(String postalCode) throws BLLException{
		checkInput(postalCode, "Le code postal doit �tre renseign�");
		
		checkInputLength(postalCode, 10, "Le code postal doit faire moins de 10 caract�res");
		
		if(!Pattern.matches("[0-9]+{5}", postalCode)) throw new BLLException(ErrorCode.CODE_POSTAL_INVALIDE);
	}
	
	/**
	 * Utilis� pour v�rifier si la ville renseign� est valide
	 * @param town Ville de l'utilisateur
	 * @throws BLLException Si la ville n'est pas renseign� ou sup�rieure � 30 caract�res
	 */
	public static void isTownValid(String town) throws BLLException{
		checkInput(town, "La ville doit �tre renseign�");
		
		checkInputLength(town, 30, "La ville doit faire moins de 30 caract�res");
	}
}
