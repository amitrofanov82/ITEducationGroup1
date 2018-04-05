package com.simple.contact.service.impl;

import java.util.List;

import com.simple.contact.dao.IContactDao;
import com.simple.contact.dao.impl.ContactDao;
import com.simple.contact.entity.Contact;
import com.simple.contact.exception.DaoException;
import com.simple.contact.exception.ServiceException;
import com.simple.contact.service.IContactService;

public class ContactService implements IContactService {

	private IContactDao contactDao = new ContactDao();

	@Override
	public void saveOrUpdate(List<Contact> contacts) throws ServiceException {
		for (Contact contact : contacts) {
			try {
				if (null == contact.getId()) {
					Long contactId = contactDao.save(contact);
					contact.setId(contactId);
				} else {
					contactDao.update(contact);
				}
			} catch (DaoException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}
	}

	@Override
	public List<Contact> loadAll() throws ServiceException {
		try {
			return contactDao.loadAll();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
