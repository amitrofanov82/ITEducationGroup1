package com.simple.contact.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -1033890996087089464L;

	private Exception hiddenException;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Exception e) {
		super(msg);
		hiddenException = e;
	}

	public Exception getHiddenException() {
		return hiddenException;
	}

}
