package com.simple.contact.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simple.contact.dao.ConnectionFactory;
import com.simple.contact.dao.IContactDao;
import com.simple.contact.dao.util.DatabaseUtil;
import com.simple.contact.entity.Contact;
import com.simple.contact.exception.DaoException;

public class ContactDao implements IContactDao {

	private static final String SQL_INSERT_CONTACT_QUERY = "INSERT INTO Contact "
			+ "(contact_id, name, surname, login, email, phone) VALUES (contact_seq.nextval, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_CONTACT_QUERY = "UPDATE Contact SET name=?, surname=?, "
			+ "login=?, email=?, phone=? WHERE contact_id= ?";
	private static final String SQL_SELECT_ALL_CONTACTS_QUERY = "SELECT * FROM Contact";

	@Override
	public Long save(Contact contact) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Long contactId = 0L;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(SQL_INSERT_CONTACT_QUERY,
					new String[] { "contact_id" });
			statement.setString(1, contact.getName());
			statement.setString(2, contact.getSurname());
			statement.setString(3, contact.getLogin());
			statement.setString(4, contact.getEmail());
			statement.setString(5, contact.getPhoneNumber());
			int affectedRows = statement.executeUpdate();
			if (affectedRows > 0) {
				rs = statement.getGeneratedKeys();
				if (null != rs && rs.next()) {
					contactId = rs.getLong(1);
				}
			}
		} catch (SQLException e) {
			throw new DaoException("Can't add contact " + e.getMessage(), e);
		} //finally {
			//DatabaseUtil.close(rs, statement, connection);
		//}
		return contactId;
	}

	@Override
	public void update(Contact contact) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(SQL_UPDATE_CONTACT_QUERY);
			statement.setString(1, contact.getName());
			statement.setString(2, contact.getSurname());
			statement.setString(3, contact.getLogin());
			statement.setString(4, contact.getEmail());
			statement.setString(5, contact.getPhoneNumber());
			statement.setLong(6, contact.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Can't update contact" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	@Override
	public List<Contact> loadAll() throws DaoException {
		List<Contact> contacts = new ArrayList<Contact>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_SELECT_ALL_CONTACTS_QUERY);
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("contact_id"));
				contact.setName(rs.getString("name"));
				contact.setSurname(rs.getString("surname"));
				contact.setLogin(rs.getString("login"));
				contact.setEmail(rs.getString("email"));
				contact.setPhoneNumber(rs.getString("phone"));
				contacts.add(contact);
			}
		} catch (SQLException e) {
			throw new DaoException("Can't load all contacts" + e.getMessage(),
					e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return contacts;
	}

}
