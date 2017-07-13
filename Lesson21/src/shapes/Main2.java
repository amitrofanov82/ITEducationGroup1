package shapes;

public class Main2 {
	public static void main(String[] args) {
		Treugolnik t = new Treugolnik();
		//t.helloFromGrandFather();
		
		PriamTreg t2 = new PriamTreg();
		//t2.helloFromGrandFather();
		
		Treugolnik t3 = new Treugolnik();
		
		
		Object o = new Object();
		
		
		System.out.println(t);
		System.out.println(t.hashCode());
		System.out.println(t.equals(t3)); //t==t3

	}

}












































