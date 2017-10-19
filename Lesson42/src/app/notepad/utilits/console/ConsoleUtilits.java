package app.notepad.utilits.console;

import java.util.Scanner;

import app.notepad.UI.TUI.TextUI;

public class ConsoleUtilits {
	private static Scanner sc = new Scanner(System.in);

	public static String readLine() {
		String string = sc.nextLine();
		return string;
	}

	public static String inputDateReminder() {
		while (true) {
			String dateReminderStr = ConsoleUtilits.readLine();
			if (ConsoleUtilits.validateDateReminderStr(dateReminderStr)) {// FIXME
				return dateReminderStr;
			} else {
				TextUI.invalidInput();
			}
		}
	}

	private static boolean validateDateReminderStr(String dateReminderStr) {
		// FIXME
		// "dd.MM.yyyy HH:mm"
		// "0123456789012345"
		if (dateReminderStr == null) {
			{
				return false;
			}
		}
		if (dateReminderStr.length() != 16) {
			return false;
		}
		if (!dateReminderStr.substring(2, 3).equals(".")) {
			return false;
		}
		if (!dateReminderStr.substring(5, 6).equals(".")) {
			return false;
		}
		if (!dateReminderStr.substring(10, 11).equals(" ")) {
			return false;
		}
		if (!dateReminderStr.substring(13, 14).equals(":")) {
			return false;
		}
		try {
			if (Integer.parseInt(dateReminderStr.substring(0, 2)) < 0
					|| Integer.parseInt(dateReminderStr.substring(0, 2)) > 31) {
				return false;
			}
			if (Integer.parseInt(dateReminderStr.substring(0, 2)) < 0
					|| Integer.parseInt(dateReminderStr.substring(3, 5)) > 12) {
				return false;
			}
			if (Integer.parseInt(dateReminderStr.substring(0, 2)) < 2000
					|| Integer.parseInt(dateReminderStr.substring(6, 10)) > 2100) {
				return false;
			}
			if (Integer.parseInt(dateReminderStr.substring(0, 2)) < 0
					|| Integer.parseInt(dateReminderStr.substring(11, 13)) > 23) {
				return false;
			}
			if (Integer.parseInt(dateReminderStr.substring(0, 2)) < 0
					|| Integer.parseInt(dateReminderStr.substring(14)) > 59) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static String inputPeriod() {
		System.out.println("In dev");
		return null;
	}

	public static long readID() {
		long id;
		while (true) {
			String idStr = sc.nextLine();
			try {
				id = Long.parseLong(idStr);
				return id;
			} catch (Exception e) {
				TextUI.invalidInput();
			}
		}
	}

}
