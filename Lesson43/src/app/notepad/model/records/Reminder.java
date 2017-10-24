package app.notepad.model.records;

public class Reminder extends Record {
	private String typeRecord = "Reminder";
	private String dateReminderStr;

	public Reminder(long ID) {
		super(ID);
		this.dateReminderStr = "No date";
	}
	

	public Reminder(long ID, String text) {
		super(ID, text);
		this.dateReminderStr = "No date";
	}
	
	public Reminder(long ID, String text, String dateReminderStr) {
		super(ID, text);
		this.dateReminderStr = dateReminderStr;
	}


	public Reminder(long ID, String dateCreateStr, String dateReminderStr, String text) {
		super(ID, dateCreateStr, text);
		this.dateReminderStr = dateCreateStr;
	}

	@Override
	public String toString() {
		return typeRecord + "#" + " ID:" + ID + " Date create:" + dateCreateStr + "\nDate reminder:" + dateReminderStr
				+ " Text:" + text;
	}

}
