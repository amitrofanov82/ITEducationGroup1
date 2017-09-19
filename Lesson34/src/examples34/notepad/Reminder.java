package examples34.notepad;

import java.util.Date;

public class Reminder extends Record {
	private Date reminderDate;
	
	public Reminder(String message) {
		super(message);
	}

	public Date getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}
}
