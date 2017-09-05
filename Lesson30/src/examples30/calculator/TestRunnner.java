package examples30.calculator;

public class TestRunnner {

	public static void main(String[] args) {
		CalculatorModel calc = new IndusskijKalkulator();
		boolean result = CalculatorTest.test(calc);
		System.out.println("test1: " + result);
		boolean result2 = CalculatorTest.test2(calc);
		System.out.println("test2: " + result2);

	}

}
