package examples.abstractclasses;

public class Krug extends Shape {
	private double r;
	
	public Krug(){
		super("krug");
		System.err.println("Inside Krug constructor");
		r = Math.random()*10;
	}


	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	/*public String getName() {
		return "Krug";
	}*/
	
	@Override
	public double getPerimetr() {
		return r * Math.PI * 2;
	}
	
	public void print() {
		super.print();
		System.out.println(" My r=" + r);
	}


	@Override
	public double getArea() {
		return Math.PI*r*r;
	}

}
