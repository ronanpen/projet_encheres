package org.enchere.bll;

public enum ErrorCode {
	MOT_DE_PASSE_NON_IDENTIQUES(1000, "Les mots de passe ne sont pas identiques"),
	MAIL_INVALIDE(1001, "Le mail ne correspond pas au format standard"),
	NUMERO_TELEPHONE_INVALIDE(1002, "Le numéro de téléphone n'est pas au bon format (##########)"),
	CODE_POSTAL_INVALIDE(1003, "Le code postal n'est pas au bon format(#####)");
	
	private int errorCode;
	private String message = "";
	ErrorCode(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public int getErrorCode() {
		return this.errorCode;
	}
}
