package examples16;

public class Auto {
	String color;
	int HorsePower;
	static String classDescritpion = "this is auto class"; 
	
	public Auto() {
		if (Math.random() > 0.5){
			this.color = "black";
		} else {
			this.color = "green";
		}
		this.HorsePower = (int)(Math.random()*1200) + 1 ;
	}
	
	
	public Auto(String color, int initPower) {
		this.color = color;
		HorsePower = initPower;
	}
	
	public Auto(Auto original) {
		this.color = original.color;
		this.HorsePower = original.HorsePower;
	}

}
