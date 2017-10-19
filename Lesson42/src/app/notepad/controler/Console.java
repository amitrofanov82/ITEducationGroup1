package app.notepad.controler;

import java.io.IOException;

import app.notepad.UI.TUI.TextUI;
import app.notepad.model.FileProcessor;
import app.notepad.model.Notepad;
import app.notepad.utilits.console.ConsoleUtilits;

public class Console {
	// Fields

	private final String DEFAULT_PATH = "app/notepad/resources/notepad.ntpd";
	private String userPath = DEFAULT_PATH;
	private Notepad np;

	// Constructor

	public Console() {
	}

	// Master Menus

	private void callMenuMain() {
		while (true) {
			String text;
			String dateReminderStr;

			if (!np.isEmpty()) {
				TextUI.mainMenuWithDontEmptyNotepad();
			} else {
				TextUI.mainMenuWithEmptyNotepad();
			}

			String choise = ConsoleUtilits.readLine();
			switch (choise) {
			case "1":
				TextUI.inputTextNote();
				text = ConsoleUtilits.readLine();
				np.addNewNote(text);
				break;
			case "2":
				TextUI.inputTextReminder();
				text = ConsoleUtilits.readLine();
				TextUI.inputDateReminder();
				dateReminderStr = ConsoleUtilits.inputDateReminder();// FIXME
				np.addNewReminde(text, dateReminderStr);
				break;
			case "3":
				callMenuShowRecords();
				break;
			case "0":
				callMenuExit();
				break;
			default:
				TextUI.invalidInput();
			}
			text = "";
			dateReminderStr = "";
		}
	}

	private void callMenuShowRecords() {
		while (true) {
			TextUI.menuShowRecords();
			String choise = ConsoleUtilits.readLine();
			switch (choise) {
			case "1":
				showAllRecord();
				break;
			case "2":
				callMenuShowNotes();
				break;
			case "3":
				callMenuShowReminders();
				break;
			case "4":
				callMenuRemoveRecord();
				break;
			case "0":
				return;
			default:
				TextUI.invalidInput();
			}
		}
	}

	private void callMenuExit() {

		while (true) {
			TextUI.ExitMenu();
			String choise = ConsoleUtilits.readLine();
			switch (choise) {
			case "1":
				try {
					FileProcessor.fileWrite(userPath, np.toString());
				} catch (IOException e) {
					TextUI.errorWriteFile();
					return;// при ошибке записи не даст нормально выйти из
							// программы
				}
				System.exit(-1);
				break;
			case "2":
				return;
			default:
				TextUI.invalidInput();
			}
		}
	}

	// sub menus

	private void showAllRecord() {
		TextUI.showAllRecords(np.showAllRecords());
	}

	private void callMenuRemoveRecord() {
		while (true) {
			TextUI.menuRemove();
			long ID = ConsoleUtilits.readID();
			while (true) {
				TextUI.chekRemove(ID);
				String choise = ConsoleUtilits.readLine();
				switch (choise) {
				case "1":
					np.removeRecordByID(ID);
					return;
				case "2":
					return;
				default:
					TextUI.invalidInput();
					break;
				}
			}
		}
	}

	/**
	 * In dev
	 */
	private void callMenuShowNotes() {
		TextUI.showAllRecords(np.showAllNotes());
		TextUI.choisePeriod();
		String choise = ConsoleUtilits.readLine();
		switch (choise) {
		case "1":
			String per1 = ConsoleUtilits.inputPeriod();// TODO
			String per2 = ConsoleUtilits.inputPeriod();// TODO
			TextUI.showAllRecordsByPeriod(np.showAllNotesForPeriod(per1, per2));// TODO
			break;
		case "2":
			return;
		default:
			TextUI.invalidInput();
		}
	}

	/**
	 * In dev
	 */
	private void callMenuShowReminders() {
		TextUI.showAllRecords(np.showAllReminders());
		TextUI.choisePeriod();
		String choise = ConsoleUtilits.readLine();
		switch (choise) {
		case "1":
			String per1 = ConsoleUtilits.inputPeriod();// TODO
			String per2 = ConsoleUtilits.inputPeriod();// TODO
			TextUI.showAllRecordsByPeriod(np.showAllReminderForPeriod(per1, per2));// TODO
			break;
		case "2":
			return;
		default:
			TextUI.invalidInput();
		}
	}

	// Special methods

	public void startConsole() {

		TextUI.starting();
		loadingNotepad(false);// TODO
		np = new Notepad();// ЗАГЛУШКА
		callMenuMain();
	}

	private void loadingNotepad(boolean test) {
		// Проверка файла, чтение или создание, передача данных в блокнот
		// цикл{
		// ******если(есть файл){
		// **********если(полон файл){
		// **************считать;
		// **************создать блокнот;
		// **************предать в блокнот;
		// **************выйти из цикла;
		// **********}иначе{
		// **************уточнить путь;
		// ******}иначе{
		// **********уточнить путь;
		// **********если(не уазали){
		// **************создать;
		// **************создать блокнот;
		// **************выйти из цикла;
		// **********}иначе{
		// **************создать по умолчанию;
		// **************создать блокнот;
		// **************выйти из цикла;
		// *******}
		if (test == true) {
			return;
		}
		while (true) {
			if (FileProcessor.chekPathFile(userPath)) {
				if (FileProcessor.fileIsEmpty(userPath)) {

					try {
						np = new Notepad(FileProcessor.fileRead(userPath));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				} else {
					callMenuEditPath();
				}
			} else {
				callMenuEditPath();

				try {
					FileProcessor.createFile(userPath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				np = new Notepad();
				return;
			}
		}
	}

	private void callMenuEditPath() {
		// TODO Auto-generated method stub

	}


	// Getters and Setters
	public String getUserPath() {
		return userPath;
	}

	public void setUserPath(String userPath) {
		this.userPath = userPath;
	}

	public String getDEFAULT_PATH() {
		return DEFAULT_PATH;
	}

}
