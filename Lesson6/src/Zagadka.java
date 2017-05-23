
public class Zagadka {
	
	public static void main(String[] args) {
		int a = 2;
		someMethod(a);
		System.out.println(a);
	}
	
	private static void someMethod(int a){
		a = a+1;
		return;
	}

}
