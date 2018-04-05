package com.simple.contact.exception;

public class UtilException extends RuntimeException {

	private static final long serialVersionUID = 6035683695952091257L;

	private Exception hiddenException;

	public UtilException(String msg) {
		super(msg);
	}

	public UtilException(String msg, Exception e) {
		super(msg);
		hiddenException = e;
	}

	public Exception getHiddenException() {
		return hiddenException;
	}
}
