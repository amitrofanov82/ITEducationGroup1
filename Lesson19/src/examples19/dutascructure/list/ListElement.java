package examples19.dutascructure.list;

public class ListElement {
	private int value;
	private ListElement nextElement;
	
	public void write(int value){
		this.value = value;
	}
	
	public int read(){
		return value;
	}
	
	public void setNextElement(ListElement ref){
		this.nextElement = ref;
	}
	
	public ListElement getNextElement(){
		return nextElement;
	}

}
