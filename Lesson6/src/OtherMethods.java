
public class OtherMethods {
	
	public static void main(String[] args) {
		double a=1, b=8, c=2;
		//double d=0;
		
		//calculateD(1.0, 2f, 3d);
		//d = calculateD(a, b, c);
		//double x1 = calculateX1(a, b, d);
		//double x2 = calculateX2(a, b, d);
		printAnswer(calculateX1(a, b, calculateD(a, b, c)),
				       calculateX1(a, b, calculateD(a, b, c))
				    );
	}
	
	public static double calculateD(double a, double b, double c){
		//double d;
		//d = b*b -4*a*c;
		return b*b -4*a*c;
	}
	
	public static double calculateX1(double a, double  b, double  discriminant){
		//double x1;
		//x1 = (-b + Math.sqrt(d))/(2*a);
		return (-b + Math.sqrt(discriminant))/(2*a);
	}
	
	private static void printAnswer(double x1, double x2) {
		System.out.println("X1= "  + x1 + " X2 = " +x2);
		
	}

	private static double calculateX2(double a, double  b, double  d){
		double x2;
		x2 = (-b - Math.sqrt(d))/(2*a);
		return x2;
	}


	

	
	
}
