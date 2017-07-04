package examples18.composition;

public class Person {
	
	Auto auto = null;
	String name;
	
	Person(String name){
		this.name = name;
	}
	
	public void buyAuto(String description, boolean buyTires){
		auto = new Auto(description, buyTires);
	}
	

}
