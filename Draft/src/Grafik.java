//найти корень, не испульзуя Math.sqrt()
public class Grafik {
	
	public static void main(String[] args) {
		double S=0, begin=2, end=3, h = 0.01;
		
		//f(x) = sin(x)+ 10:
		for (double i =  begin; i<=end; i+=h){
			double Sh;
			//Sh = (a1 + a2)*h/2:
			Sh = (Math.sin(begin + h*i) + Math.sin(begin + h*(i+1)))*h/2;
			S = S + Sh;		
		}
		System.out.println(S);
	}
	
	
	

	
	
}