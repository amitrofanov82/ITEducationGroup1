package examples37.varargs;

public class VarargExample {
	
	public static void main(String[] args) {
		sum(1,2);
		//sum(1,2,2,2,2.0,2,2,2);
		sum(1.0, 1,2,2,2,2,2,2,2);
		sum(1,2,3,4);
		sum(1,2,3);
	}
	
	static int sum (int a, int b) {
		return a+b;
	}
	
	static int sum (double b, int ...a/*, double ...b*/) {
		return a[0] + a[1];//for...
	}

}



























