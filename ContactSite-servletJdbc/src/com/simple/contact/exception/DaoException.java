package com.simple.contact.exception;

public class DaoException extends Exception {
	private static final long serialVersionUID = 3356847180763493775L;
	
	private Exception hiddenException;

	public DaoException(String msg) {
		super(msg);
	}

	public DaoException(String msg, Exception e) {
		super(msg);
		hiddenException = e;
	}

	public Exception getHiddenException() {
		return hiddenException;
	}
}
