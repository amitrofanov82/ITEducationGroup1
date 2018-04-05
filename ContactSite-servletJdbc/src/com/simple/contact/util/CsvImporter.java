package com.simple.contact.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.simple.contact.entity.Contact;
import com.simple.contact.exception.UtilException;

public final class CsvImporter {

	public static final String DELIMETER = ",";

	private CsvImporter() {

	}

	public static List<Contact> importCsv(String filePath) throws UtilException {
		List<Contact> contacts = new ArrayList<Contact>();
		String line = "";
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(filePath));
			while ((line = fileReader.readLine()) != null) {
				String[] fieldValues = line.split(DELIMETER);
				contacts.add(createContact(fieldValues));
			}
		} catch (Exception e) {
			throw new UtilException(e.getMessage(), e);
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return contacts;
	}

	private static Contact createContact(String[] fieldValues) {
		Contact contact = new Contact();
		contact.setName(fieldValues[0]);
		contact.setSurname(fieldValues[1]);
		contact.setLogin(fieldValues[2]);
		contact.setEmail(fieldValues[3]);
		contact.setPhoneNumber(fieldValues[4]);
		return contact;
	}

}
