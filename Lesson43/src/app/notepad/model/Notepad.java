package app.notepad.model;

import java.util.HashMap;

import app.notepad.model.records.*;
import app.notepad.utilits.records.RecordsUtilits;

public class Notepad {
	// Fields
	private HashMap<Long, Record> hashMapNotepad;

	// Constructors
	public Notepad(HashMap<Long, Record> outHashMapNotepad) {
		this.hashMapNotepad = outHashMapNotepad;
	}

	public Notepad() {
		hashMapNotepad = new HashMap<Long, Record>();
	}

	// Methods add
	public void addNewNote(String text) {
		long newID = RecordsUtilits.getRandom7Digits();
		hashMapNotepad.put(newID, new Note(newID, text));
	}

	public void addNewReminde(String text, String dateReminderStr) {
		long newID = RecordsUtilits.getRandom7Digits();
		hashMapNotepad.put(newID, new Reminder(newID, text, dateReminderStr));
	}

	// Method removed
	public boolean removeRecordByID(long ID) {
		if (hashMapNotepad.containsKey(ID)) {
			hashMapNotepad.remove(ID);
			return true;
		} else {
			return false;
		}
	}

	// Method get
	public Record getNoteByID(long ID) {
		if (hashMapNotepad.containsKey(ID)) {
			return hashMapNotepad.get(ID);
		} else {
			return null;
		}
	}
	
	//Other methods
	public boolean isEmpty() {
		if (hashMapNotepad.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	//Viewers
	
	public String showAllRecords() {
		String stringAllRecords = "";
		Long[] arrayKeys = new Long[hashMapNotepad.size()];
		hashMapNotepad.keySet().toArray(arrayKeys);
		for (int i = 0; i < arrayKeys.length; i++) {
			stringAllRecords += hashMapNotepad.get(arrayKeys[i]).toString() + "\n\n";
		}
		return stringAllRecords;
	}

	public String showAllNotes() {
		String stringAllRecords = "";
		Long[] arrayKeys = new Long[hashMapNotepad.size()];
		hashMapNotepad.keySet().toArray(arrayKeys);
		for (int i = 0; i < arrayKeys.length; i++) {
			if (hashMapNotepad.get(arrayKeys[i]) instanceof Note) {
				stringAllRecords += hashMapNotepad.get(arrayKeys[i]).toString() + "\n\n";
			}
		}
		return stringAllRecords;
	}

	public String showAllReminders() {
		String stringAllRecords = "";
		Long[] arrayKeys = new Long[hashMapNotepad.size()];
		hashMapNotepad.keySet().toArray(arrayKeys);
		for (int i = 0; i < arrayKeys.length; i++) {
			if (hashMapNotepad.get(arrayKeys[i]) instanceof Reminder) {
				stringAllRecords += hashMapNotepad.get(arrayKeys[i]).toString() + "\n\n";
			}
		}
		return stringAllRecords;
	}

	public String showAllReminderForPeriod(String per1, String per2) {
		//TODO
		System.out.println("In Dev");
		return null;
	}

	public String showAllNotesForPeriod(String per1, String per2) {
		//TODO
		System.out.println("In Dev");
		return null;
	}

}
