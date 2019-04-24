package org.enchere.bll.util;

import java.util.regex.Pattern;

import org.enchere.bll.BLLException;

public class CheckInputHelper {
	
	public static void checkInput(String inputToCheck, String errorMessage) throws BLLException{
		if(inputToCheck == null || inputToCheck.equalsIgnoreCase("")) {
			throw new BLLException(errorMessage);
		}
	}
	
	public static void checkInputLength(String inputToCheck, int maxLength, String errorMessage) throws BLLException{
		checkInputLength(inputToCheck, 0, maxLength, errorMessage);
	}
	
	public static void checkInputLength(String inputToCheck, int minLength, int maxLength, String errorMessage) throws BLLException{
		if(inputToCheck.length() > maxLength && inputToCheck.length() < minLength) {
			throw new BLLException(errorMessage);
		}
	}
	
	public static void isPasswordSame(String password, String password_2) throws BLLException{
		if(password.equals(password_2)) throw new BLLException("Les mots de passe ne sont pas indentiques");
	}
	
	public static void isPasswordValid(String password) throws BLLException {
		checkInput(password, "Le mot de passe doit être renseigné");
		
		checkInputLength(password, 8, 60, "Le mot de passe est inférieur à 8 caractères");
		
		//TODO Vérification présence minuscule, majuscule, chiffre, caracractère spéciale
	}
	
	public static void isUsernameValid(String username) throws BLLException{
		checkInput(username, "Le pseudo doit être renseigné");
		
		checkInputLength(username, 30, "Le pseudo doit faire moins de 30 caractères");
	}
	
	public static void isSurnameValid(String surname) throws BLLException{
		checkInput(surname, "Le nom doit être renseigné");
		
		checkInputLength(surname, 30, "Le nom doit faire moins de 30 caractères");
	}
	
	public static void isNameValid(String name) throws BLLException{
		checkInput(name, "Le prénom doit être renseigné");
		
		checkInputLength(name, 30, "Le prénom doit faire moins de 30 caractères");
	}
	
	public static void isMailValid(String email) throws BLLException{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
			                "[a-zA-Z0-9_+&*-]+)*@" + 
			                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
			                "A-Z]{2,7}$";
		
		checkInput(email, "Le mail doit être renseigné");
		
		checkInputLength(email, 20, "Le mail doit faire moins de 20 caractères");
		
		// Vérification mail valide
		if(!Pattern.matches(emailRegex, email)) throw new BLLException("Le mail ne correspond pas au format standard");
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
		if(!Pattern.matches(phoneNumberRegex, phoneNumber)) throw new BLLException("Le numéro de téléphone n'est pas au bon format (##########)");
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
	 * @throws BLLException Si le code postal n'est pas renseigné ou supérieure à 10 caractères ou encore n'est pas au bon format (#####)
	 */
	public static void isPostalCodeValid(String postalCode) throws BLLException{
		checkInput(postalCode, "Le code postal doit être renseigné");
		
		checkInputLength(postalCode, 10, "Le code postal doit faire moins de 10 caractères");
		
		if(!Pattern.matches("[0-9]+{5}", postalCode)) throw new BLLException("Le code postal n'est pas au bon format(#####)");
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
