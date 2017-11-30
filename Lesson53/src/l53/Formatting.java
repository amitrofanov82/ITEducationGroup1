package l53;

import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class Formatting {
	
	
	public static void main(String[] args) {
		int a=1,b=2,c=3;
		System.out.println(a + " " + b + " " + c);
		System.out.printf("%d %d %f", a, b, (float)a);
		Formatter fmt = new Formatter(Locale.JAPANESE);
		//fmt.format("%t", new Date());
	}
}
