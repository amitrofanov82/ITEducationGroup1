package com.epam.newsmanagement.exception;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         High level project exception
 *         </p>
 */
public class NewsException extends Exception {

	private static final long serialVersionUID = 1L;
	private Exception hiddenException;

	public NewsException(String msg) {
		super(msg);
	}

	public NewsException(String msg, Exception e) {
		super(msg);
		hiddenException = e;
	}

	public NewsException(Throwable cause) {
		super(cause);
	}

	public Exception getHiddenException() {
		return hiddenException;
	}
}
