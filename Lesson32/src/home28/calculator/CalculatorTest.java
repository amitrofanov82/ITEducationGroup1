
/**
 * 
 */
package home28.calculator;

/**
 * @author Alexander Neznaev
 *
 */
public class CalculatorTest {
    
    public static String test1 (CalculatorModel calc) {
	calc.clear();
	calc.plus();
	calc.enterDigit(9);
	calc.plus();
	calc.enterDigit(1);
	calc.plusMinus();
	calc.divide();
	calc.plus();
	calc.enterDigit(2);
	calc.enterDigit(2);
	calc.enterDigit(2);
	calc.enterDigit(2);
	calc.deleteLastEnteredDigit();
	calc.deleteLastEnteredDigit();
	calc.deleteLastEnteredDigit();
	calc.multiply();
	calc.equalsNow();
	calc.sqrt();
	calc.equalsNow();
	calc.divide();
	calc.enterDigit(0);
	calc.plus();
	calc.enterDigit(9);
	calc.enterDigit('.');
	calc.enterDigit(0);
	calc.enterDigit('.');
	calc.enterDigit(0);
	calc.plus();
	calc.enterDigit(1);
	calc.equalsNow();
	return calc.toString();
    }
    
    public static String test2 (CalculatorModel calc) {
	calc.clear();
	calc.enterDigit(1);
	calc.plusMinus();
	calc.minus();
	calc.enterDigit(5);
	calc.multiply();
	calc.enterDigit(1);
	calc.plusMinus();
	calc.equalsNow();
	calc.multiply();
	calc.equalsNow();
	calc.memorySave();
	calc.enterDigit(4);
	calc.enterDigit('.');
	calc.enterDigit(5);
	calc.multiply();
	calc.enterDigit(1);
	calc.enterDigit(0);
	calc.divide();
	calc.memoryRestore();
	calc.plus();
	calc.enterDigit(3);
	calc.plusMinus();
	calc.equalsNow();
	return calc.toString();
    }
    
    public static String testString (CalculatorModel calc) {
	calc.calculateExpression("-3+4.5*10/((-1-5)*-1)^2");
	return calc.toString();
    }
    
    public static String test3 (CalculatorModel calc) {
	calc.memoryClear();
	calc.clear();
	calc.enterDigit(9);
	calc.plus();
	calc.enterDigit(6);
	calc.percent();
	calc.enterDigit(6);
	return calc.toString();
    }
}