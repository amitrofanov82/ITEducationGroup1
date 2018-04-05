package com.simple.contact.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.simple.contact.exception.DaoException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost/contacts";
	public static final String USER = "****************";
	public static final String PASSWORD = "*************";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() throws DaoException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new DaoException("can not get connection", e);
		}
		return connection;
	}

	public static Connection getConnection() throws DaoException {
		return instance.createConnection();
	}

}
