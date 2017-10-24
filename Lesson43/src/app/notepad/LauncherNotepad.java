package app.notepad;

import app.notepad.model.Notepad;

public class LauncherNotepad {

	public static void main(String[] args) throws Exception {
		Notepad notepadModel = new Notepad();
		NotepadWindow notepadUI = new NotepadWindow(notepadModel);
		notepadUI.startNotepadUI();
		/*Thread.sleep(2000);
		notepadUI.setVisible(false);
		Thread.sleep(2000);
		notepadUI.setVisible(true);
		Thread.sleep(2000);
		notepadUI.setVisible(false);*/
		
		
	}

}
