package com.simple.contact.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simple.contact.exception.DaoException;

public final class DatabaseUtil {

	private DatabaseUtil() {

	}

	/**
	 * Close Statement and Connection
	 * 
	 * @param resultSet
	 * @param statement
	 * @throws DaoException
	 * 
	 */
	public static void close(Statement statement, Connection connection)
			throws DaoException {

		if (null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close statement", e);
			}
		}

		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close connection", e);
			}
		}
	}

	/**
	 * Close ResultSet, Statement and Connection
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 * @throws DaoException
	 * 
	 */
	public static void close(ResultSet resultSet, Statement statement,
			Connection connection) throws DaoException {

		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DaoException("Can't close result set", e);
			}
		}

		close(statement, connection);
	}
}
