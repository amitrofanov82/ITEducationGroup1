package examples34.notepad;

import java.util.Scanner;

public class NotepadApp {
	
	private static Notepad notepad = new Notepad();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mainMenu(sc);
	}

	private static void mainMenu(Scanner sc) {
		System.out.println("Выбирай:");
		System.out.println("1. Записи");
		System.out.println("2. Памятки");
		System.out.println("3. До свидания");
		while (true){
			String choice = sc.nextLine();
			switch (choice){
			case "1":
				noteMenu(sc);
				break;
			case "2":
				reminderMenu(sc);
				break;
			default:
				return;
			}
		}
		
		
	}

	private static void noteMenu(Scanner sc) {
		System.out.println("Чё делать с заметками:");
		System.out.println("1. добавить");
		System.out.println("2. удалить");
		System.out.println("3. В главное меню");
		while (true){
			String choice = sc.nextLine();
			switch (choice){
			case "1":
				addNote(sc);
				break;
			case "2":
				removeNote(sc);
				break;
			default:
				return;
			}
		}
	}

	private static void removeNote(Scanner sc) {
		System.out.println("Введите ID");
		String idAsString = sc.nextLine();
		long id = Long.parseLong(idAsString);
		notepad.removeRecord(id);
	}

	private static void addNote(Scanner sc) {
		System.out.println("Введите текст");
		Note note = new Note(sc.nextLine());
		notepad.addRecord(note);
	}

	private static void reminderMenu(Scanner sc) {
		System.out.println("Памятки пока не готовы");
	}

}





















