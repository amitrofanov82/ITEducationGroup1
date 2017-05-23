import java.util.ArrayList;
import java.util.Collection;

public class Algorithms {
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long sum=0;
		int progress = 0;
		for (long i = 0; i<=3000000000L;  i++) {
			sum+=i;
			if ((i % 30000000) == 0) {
				System.out.println(progress++ + " %");
			}
			
			
		}
		System.out.println("Sum = " +sum);
		System.out.println("Run time = " + 
		   (System.currentTimeMillis() - startTime)/1000f 
		   + " seconds" );
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void cyklesExample(String[] args) {
		System.out.println("do cikla");
		/*int n=0;
		
		
		
		do {
			System.out.println("inside doWhile");
		}while (false);
		
		while(n<10){
			System.out.println(".");
			n++;
		}
		while(true){
			System.out.println(".");
			if (true){
				break;
			}
		}*/
		
		
		/*
		 * int i = 0;
		 * for (System.out.println("nachalo cikla");true;System.out.println("posredi cikla")){
					if (false){
						break;
					}
		}*/
		
		/*for (int i =9; i>=0; i--){
			System.out.println(i);
			continue;
			if (false){
				break;
			}
			
		}*/
		
		Collection<Integer> kCollection = new ArrayList();
		for (Integer k : kCollection){
			
		}
		
		
		
		
		
		
		System.out.println("posle cikla");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void ifExample(String[] args) {
		double a = 3, b = 4, c = 4, d;
		d = b * b - 4 * a * c;
		if (d < 0) {
			System.out.println("D<0");
		} else if (d == 0) {
			System.out.println("X=" + ((-b / 2 * a)));
		} else {
			System.out.println("X1=" + ((-b + Math.sqrt(d)) / 2 * a));
			System.out.println("X2=" + ((-b - Math.sqrt(d)) / 2 * a));
		}
	}
	
}
