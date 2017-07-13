package shapes;

public class Treugolnik extends Shape {
	
	public String toString() {
		return "I'm " + getName() 
		+ " color is " + getColor()
		+ " area is " + getArea() 
		+ " perimeter is " + getPerimetr();
	}
	
	public boolean equals (Object o) {
		if (! o.getClass().equals(this.getClass())) {
			return false;
		}
		Treugolnik oAsTreugolnik = (Treugolnik) o;
		/*if (o instanceof Treugolnik) {
			
		};*/ 
		
		return false;
	}
	
}
