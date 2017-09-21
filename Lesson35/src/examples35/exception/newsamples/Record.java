
package examples35.exception.newsamples;

import java.util.Date;

public abstract class Record {

	private static long lastGeneratedId=0;
	private long id=0;
	private String message;
	private Date creationDate;
	
	public Record(String message){
		this.id = lastGeneratedId++;
		this.message = message;
		this.creationDate = new Date();
	}

	public long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	@Override
	public String toString() {
		return ""+id+ " | " + creationDate + " | " + message;
	}

}
