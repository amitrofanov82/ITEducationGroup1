package examples.abstractclasses;

public class Kvadrat extends Shape {
	private double side;
	
	public Kvadrat(){
		super("kvadrat");
		side = Math.random()*10;
	}
	
	public double getPerimetr() {
		return side * 4;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
