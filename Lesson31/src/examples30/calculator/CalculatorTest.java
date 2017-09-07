package examples30.calculator;

public class CalculatorTest {
	
	public static boolean test(CalculatorModel calc) {
		calc.clear();
		calc.enterDigit(9);
		calc.plus();
		calc.enterDigit(1);
		calc.plus();
		System.out.println(calc);
		return calc.toString().equals("10.0");
	}
	
	public static boolean test2(CalculatorModel calc) {
		calc.clear();
		calc.enterDigit(9);
		calc.plus();
		calc.enterDigit(2);
		calc.plus();
		System.out.println(calc);
		return calc.toString().equals("11.0");
	}
	
}
