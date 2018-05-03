package com.simple.contact.dao;

import java.util.List;

import com.simple.contact.entity.Contact;
import com.simple.contact.exception.DaoException;

public interface IContactDao {

	Long save(Contact contact) throws DaoException;

	void update(Contact contact) throws DaoException;

	List<Contact> loadAll() throws DaoException;

}
