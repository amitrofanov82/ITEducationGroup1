package examples.abstractclasses;

public class Treugolnik extends Shape {
	@Override
	public String toString() {
		return "I'm " + getName() 
		+ " color is " + getColor()
		+ " area is " + getArea() 
		+ " perimeter is " + getPerimetr();
	}
	
	@Override
	public double getPerimetr() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean equals (Object o) {
		if (! o.getClass().equals(this.getClass())) {
			return false;
		}
		Treugolnik oAsTreugolnik = (Treugolnik) o;
		//boolean b = this.getPerimetr() == ( (Treugolnik) o).getPerimetr();
		//boolean b = this.getPerimetr() == ( (Shape) o).getPerimetr();
		//boolean b = this.getPerimetr() == ( (Kvadrat) o).getPerimetr();
		
		if (oAsTreugolnik.getName() != this.getName()) {
			return false;
		}
		if (oAsTreugolnik.getColor() != this.getColor()) {
			return false;
		}

		//oAsTreugolnik.getPerimetr() == this.getName();
		//oAsTreugolnik.getArea() == this.getArea();

		return true;
	}
	
	public void svoyMethod(){
		
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


























