package com.epam.newsmanagement.exception;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Database layer exception
 *         </p>
 *
 */
public class DaoException extends NewsException {

	private static final long serialVersionUID = 1L;
	private Exception hiddenException;

	public DaoException(String msg) {
		super(msg);
	}

	public DaoException(String msg, Exception e) {
		super(msg);
		hiddenException = e;
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public Exception getHiddenException() {
		return hiddenException;
	}

}
