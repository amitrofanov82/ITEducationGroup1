package app.notepad.model.records;

public class Note extends Record {
	private String typeRecord = "Note";

	public Note(long ID) {
		super(ID);
	}

	public Note(long ID, String text) {
		super(ID, text);
	}

	public Note(long ID, String dateCreateStr, String text) {
		super(ID,dateCreateStr, text);
	}

	@Override
	public String toString() {
		String string = "";
		return string += typeRecord + "#" + " ID:" + ID + " Date create:" + dateCreateStr + "\nText:" + text;
	}

}
