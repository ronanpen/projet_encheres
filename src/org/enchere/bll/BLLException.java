package org.enchere.bll;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre
 */
public class BLLException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<ErrorCode> errorCodes = new ArrayList<>();

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
		this.errorCodes.add(errorCode);
	}
	
	public List<ErrorCode> getErrorCodes() {
		return this.errorCodes;
	}
}
