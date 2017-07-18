package examples22.shapes;

public class Kvadrat extends Shape {
	private double side;
	
	public Kvadrat(){
		super("kvadrat");
		side = Math.random()*10;
	}
	
	public double getPerimetr() {
		return side * 4;
	}

}
