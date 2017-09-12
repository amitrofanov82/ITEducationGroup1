/**
 * 
 */
package home28.calculator;

/**
 * @author Alexander Neznaev
 *
 */
public class TestRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
	CalculatorModel calc = new MyCalc(); // = new ???
	
	String result = CalculatorTest.test1(calc);
	System.out.println("test1: " +  result);
	
	result = CalculatorTest.test2(calc);
	System.out.println("test2: " +  result);
	
	result = CalculatorTest.testString(calc);
	System.out.println("testString: " +  result);
	
	result = CalculatorTest.test3(calc);
	System.out.println("test3: " +  result);
    }
}