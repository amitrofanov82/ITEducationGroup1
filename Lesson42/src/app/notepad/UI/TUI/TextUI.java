package app.notepad.UI.TUI;

public class TextUI {
	
	public static void starting() {
		System.out.println("Running the program...");
	}

	public static void invalidInput() {
		System.out.println("Invalid Input!");
	}
	
	public static void mainMenuWithEmptyNotepad() {
		System.out.println("What do you want to do?");
		System.out.println("\t1.Create a note");
		System.out.println("\t2.Create a reminder");
		System.out.println("\t0.Exit the program");
		System.out.println("\n");
	}
	public static void mainMenuWithDontEmptyNotepad() {
		System.out.println("What do you want to do?");
		System.out.println("\t1.Create a note");
		System.out.println("\t2.Create a reminder");
		System.out.println("\t3.Show records");
		System.out.println("\t0.Exit the program");
		System.out.println("\n");
	}

	public static void chekFileNotepad() {
		System.out.println("Checking notepad file...");
	}

	public static void ReadFile() {
		System.out.println("Reading file...");
	}

	public static void createFileByDefaultPath() {
		System.out.println("Creating the default file...");	
	}

	public static void ExitMenu() {
		System.out.println("Are you sure you want to quit?");
		System.out.println("\t1.Yes");
		System.out.println("\t2.No");
		
	}

	public static void menuShowRecords() {
		System.out.println("What do you want?");
		System.out.println("\t1.See Records");
		System.out.println("\t2.See Notes");
		System.out.println("\t3.See Reminders");
		System.out.println("\t4.Remove Record by ID");
		System.out.print("");
		System.out.println("\t0.Nothing");
	}

	public static void specifyDifferentPath() {
		System.out.println("Would you like to specify a different path?");
		System.out.println("\t1.Yes");
		System.out.println("\t2.No");	
	}

	public static void fileNotFound() {
		System.out.println("File not found!");
	}

	public static void setUserPath() {
		System.out.println("Please specify a different path!");
	}

	public static void inputTextNote() {
		System.out.println("Please enter note text.");
	}

	public static void inputTextReminder() {
		System.out.println("Please enter reminder text.");
	}
	public static void inputDateReminder() {
		System.out.println("Please enter reminder date.");
	}

	public static void showAllRecords(String showAllRecords) {
		System.out.println("\n\n===============================\n");
		System.out.println(showAllRecords);
		System.out.println("\n\n===============================\n");
		
	}

	public static void choisePeriod() {
		System.out.println("\t1.Display for the period.");
		System.out.println("\t2.Return.");	
		
	}

	public static void showAllRecordsByPeriod(String showAllReminderForPeriod) {
		//TODO
		
	}

	public static void menuRemove() {
		System.out.println("Please enter ID record for remove\n");
	}

	public static void chekRemove(long ID) {
		System.out.println("You really want to delete the record with the ID:"+ ID);
		
	}

	public static void errorWriteFile() {
		System.out.println("An unknown error occurred, the file was not written!");
		
	}



}
