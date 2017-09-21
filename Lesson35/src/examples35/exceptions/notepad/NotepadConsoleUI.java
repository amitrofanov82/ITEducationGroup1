package examples35.exceptions.notepad;

import java.util.Scanner;
import java.util.Set;

public class NotepadConsoleUI {
	
	private Notepad notepad;
	private Scanner sc = new Scanner(System.in);
	
	public NotepadConsoleUI(){
		notepad = new Notepad();
		
	}
	
	public NotepadConsoleUI(Notepad notepad){
		this.notepad = notepad;
	}
	
	public void start() {
		this.mainMenu();
	}
	
	private void mainMenu() {
		while (true){
			System.out.println();
			System.out.println("===========================");
			System.out.println("ГЛАВНОЕ МЕНЮ");
			System.out.println("===========================");
			System.out.println("Выбирай:");
			System.out.println("1. Записи");
			System.out.println("2. Памятки");
			System.out.println("3. До свидания");
			String choice = sc.nextLine();
			switch (choice){
			case "1":
				noteMenu();
				break;
			case "2":
				reminderMenu();
				break;
			default:
				return;
			}
		}
		
		
	}

	private void noteMenu() {
		while (true){
			System.out.println();
			System.out.println("===========================");
			System.out.println("МЕНЮ ЗАМЕТОК");
			System.out.println("===========================");
			System.out.println("Чё делать с заметками:");
			System.out.println("1. добавить");
			System.out.println("2. удалить");
			System.out.println("3. В главное меню");
			System.out.println("4. Показать все");
			String choice = sc.nextLine();
			switch (choice){
			case "1":
				addNote();
				break;
			case "2":
				removeNote();
				break;
			case "4":
				printAllNotes();
				break;
			default:
				return;
			}
		}
	}

	private void reminderMenu() {
		while (true){
			System.out.println();
			System.out.println("===========================");
			System.out.println("МЕНЮ ЗАМЕТОК");
			System.out.println("===========================");
			System.out.println("Чё делать с заметками:");
			System.out.println("1. добавить");
			System.out.println("2. удалить");
			System.out.println("3. В главное меню");
			System.out.println("4. Показать все");
			String choice = sc.nextLine();
			switch (choice){
			case "1":
				addReminder();
				break;
			case "2":
				removeReminder();
				break;
			case "4":
				printAllReminders();
				break;
			default:
				return;
			}
		}
	}
	
	private void removeNote() {
		System.out.println("Введите ID");
		String idAsString = sc.nextLine();
		long id = Long.parseLong(idAsString);
		notepad.removeRecord(id);
	}

	private void addNote() {
		System.out.println("Введите текст");
		Note note = new Note(sc.nextLine());
		notepad.addRecord(note);
	}
	
	private void removeReminder() {
		System.out.println("Введите ID");
		String idAsString = sc.nextLine();
		long id = Long.parseLong(idAsString);
		notepad.removeRecord(id);
	}

	private void addReminder() {
		System.out.println("Введите текст");
		Reminder reminder = new Reminder(sc.nextLine());
		System.out.println("Когда это надо?");
		reminder.setReminderDate(sc.nextLine());
		notepad.addRecord(reminder);
	}
	
	private void printAllNotes() {
		Set<Note> set = notepad.getAllNotes();
		for (Note note : set){
			System.out.println(note);
		}
	}
	
	private void printAllReminders() {
		Set<Reminder> set = notepad.getAllReminders();
		for (Reminder reminder : set){
			System.out.println(reminder);
		}
	}
	
}
