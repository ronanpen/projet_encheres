package org.enchere.bll;

/**
 * @author Alexandre
 */
public class BLLException extends Exception {
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;

	public BLLException() {
	}

	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable cause) {
		super(message, cause);
	}

	public BLLException(ErrorCode errorCode) {
		super(errorCode.getErrorCode() + " - " + errorCode.getMessage());
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return this.errorCode;
	}
}
