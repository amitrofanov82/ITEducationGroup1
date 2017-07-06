package examples19.dutascructure.list;

public class ListOfInteger {

	private int numberOfElements;
	ListElement firstElement;
	
	public ListOfInteger(){
		numberOfElements = 0;
		firstElement =null;
	}
	
	public boolean insertBefore(int value, int index){
		System.out.println("inserting " + value 
				+ " " + index + "when number=" + numberOfElements);
		if (index < 0 || index > numberOfElements) {
			return false;
		}
		if (numberOfElements == 0){
			ListElement newElement = new  ListElement();
			newElement.write(value);
			newElement.setNextElement(null);
			numberOfElements++;
			return true;
		}
		if (index == 0){
			ListElement newElement = new  ListElement();
			newElement.write(value);
			newElement.setNextElement(firstElement);
			firstElement=newElement;
			numberOfElements++;
			return true;
		} 
		ListElement tempElement = firstElement;
		for (int i =1; i<index; i++){
			tempElement = tempElement.getNextElement();
		}
		ListElement newElement = new  ListElement();
		newElement.write(value);
		newElement.setNextElement(tempElement.getNextElement());
		tempElement.setNextElement(newElement);
		numberOfElements++;
		return true;
	}
	
	
	public int get(int index){
		return 0;
	}
	
	public boolean set(int value, int index){

		
		return true;
	}
	

	
	public int remove(int value, int index){
		return 0;
	}
	
	public void printList(){
		if (firstElement == null) {
			System.out.println("[ ]");
			return;
		}
		ListElement nextElement = firstElement;
		System.out.print("[");
		while (nextElement!=null){
			System.out.print(nextElement.read() + " | ");
			nextElement = nextElement.getNextElement();
		}
		System.out.println("]");
	}

}



















