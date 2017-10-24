package app.notepad.model.records;

import java.util.Date;
import app.notepad.utilits.records.RecordsUtilits;

public abstract class Record {
	private String typeRecord = "Record";
	protected long ID;
	protected Date dateCreate;
	protected String dateCreateStr;
	protected String text;

	public Record(long ID) {
		this.dateCreate = new Date();
		this.dateCreateStr = RecordsUtilits.convertDate(dateCreate);
		this.ID = ID;
		this.text = "";
	}
	public Record(long ID, String text) {
		this.dateCreate = new Date();
		this.dateCreateStr = RecordsUtilits.convertDate(dateCreate);
		this.ID = ID;
		this.text = text;
	}

	public Record(long ID, String dateCreateStr, String text) {
		this.ID = ID;
		this.dateCreateStr = dateCreateStr;
		this.text = text;
	}

	

	@Override
	public String toString(){
		String string ="";
		return string += typeRecord+ "#" + " ID:"+ID+" Date create:" + dateCreateStr+"\nText:"+text;
	}
}
