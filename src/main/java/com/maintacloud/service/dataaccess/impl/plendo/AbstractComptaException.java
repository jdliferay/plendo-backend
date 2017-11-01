package com.maintacloud.service.dataaccess.impl.plendo;

public abstract class AbstractComptaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5082510944054481985L;
	
	private String code;
	private String message;
	
	public AbstractComptaException(String code, String message){
		this.message = message;
		this.code = code;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
