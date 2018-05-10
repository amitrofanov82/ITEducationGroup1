package com.epam.newsmanagement.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * @author Mikhail_Sadouski
 *
 *         Contains helpful methods for dao layer
 *
 */
public final class DatabaseUtil {

	private static final Logger logger = Logger.getLogger(DatabaseUtil.class);

	private DatabaseUtil() {

	}

	/**
	 * Builds part of query, where ids in identifiers array. Return such String
	 * as "IN (id[0], id[1], ...)"
	 * 
	 * @param identifiers
	 * @return delete sql query string
	 */
	public static String buildQueryPart(Long[] identifiers) {
		StringBuilder builder = new StringBuilder();
		builder.append(" IN (");

		for (int index = 0; index < identifiers.length; index++) {
			builder.append(identifiers[index]).append(",");
		}

		builder.deleteCharAt(builder.length() - 1).append(")");
		return builder.toString();
	}

	/**
	 * Close Statement and Connection
	 * 
	 * @param resultSet
	 * @param statement
	 * 
	 */
	public static void close(Statement statement, Connection connection) {

		if (null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error("Can't close statement", e);
			}
		}

		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Can't close connection", e);
			}
		}
	}

	/**
	 * Close ResultSet, Statement and Connection
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 * 
	 */
	public static void close(ResultSet resultSet, Statement statement,
			Connection connection) {

		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("Can't close result set", e);
			}
		}

		close(statement, connection);
	}
}
