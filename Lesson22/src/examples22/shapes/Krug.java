package examples22.shapes;

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
	
	public double getPerimetr() {
		return r * Math.PI * 2;
	}
	
	public void print() {
		super.print();
		System.out.println(" My r=" + r);
	}

}
