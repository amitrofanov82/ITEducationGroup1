package examples35.exception.newsamples;

import java.util.Date;

public class Reminder extends Record {
	private String reminderDate;
	
	public Reminder(String message) {
		super(message);
	}

	public String getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}
}
