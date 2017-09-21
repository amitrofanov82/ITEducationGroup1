package examples35.exception.newsamples;

import java.util.Scanner;
import java.util.Set;

public class NotepadApp {
	
	public static void main(String[] args) {
		//System.out.println(Math.sqrt(-1));
		NotepadConsoleUI ui1 = new NotepadConsoleUI();
		NotepadConsoleUI ui2 = new NotepadConsoleUI();
		NotepadConsoleUI ui3 = new NotepadConsoleUI();
		
		try {
			ui1.start();
		} catch (RuntimeException e) { //RuntimeException сюда же
			if (e.getMessage()
					.equals("Пропала связь с блокнотом, forever")) {
				System.out.println("Стратую запасной блокнот");
				ui2.setNotepad(ui1.getNotepad());
				try {
					ui2.start();
				} catch (Exception e1) {
					try {
						ui3.start();
					} catch (Exception e2) {
						System.out.println("Блокноты кончились");
						System.exit(1);
					}
				}
			} else {
				System.out.println("странное исключение");
			}
		} catch (Exception e4) {
			System.out.println("Непонятная жесть");
			System.exit(1);
		}
	}



}





















