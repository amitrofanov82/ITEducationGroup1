package examples34.notepad;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Notepad {
	private Set<Record> records = new HashSet<Record>();
	
	public void addRecord(Record r){
		records.add(r);
	}
	

	public void removeRecord(long id){
		Iterator<Record> it = records.iterator();
		while (it.hasNext()){
			Record tempRecord = it.next();
			//if (it.next().getId() == id) {
			if (tempRecord.getId() == id) {
				//it.remove();
				records.remove(tempRecord);
				return;
			}
		}
	}
	
	public Set<Note> getAllNotes(){
		Set<Note> result = new HashSet<Note>();
		for (Record r : records) {
			if (r instanceof Note) {
				result.add((Note) r);
			}
		}
		return result;
	}
	
	public Set<Reminder> getAllReminders(){
		Set<Reminder> result = new HashSet<Reminder>();
		for (Record r : records) {
			if (r instanceof Reminder) {
				result.add((Reminder) r);
			}
		}
		return result;
	}
}























