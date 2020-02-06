package com.proptiger.urlshortner.exception;

public class ProApiException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public ProApiException(String message ){
		super(message);
	}
	public ProApiException(){
		super("exception hit");
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
