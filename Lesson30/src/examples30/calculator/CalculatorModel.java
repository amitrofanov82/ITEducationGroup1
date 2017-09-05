package examples30.calculator;

public interface CalculatorModel {
	
	void plus(); //изменяет внутреннее состояние объекта.
	//may be String. Как промежуточное выражение.
	
	void minus();
	void multiply();
	void divide();
	void plusMinus();
	void inverseNumber();
	void equalsNow();
	void percent();
	void sqrt();
	void enterDigit(char digit);
	void enterDigit(int digit);
	void clear();
	void clearError();
	void deleteLastEnteredDigit();
	void memoryRestore();
	void memorySave();
	void memoryClear();
	
	/**
	 * @return to, что было бы на экране реального калькулятора после аналогичных команд
	 */
	String toString();
	
	//дополнитиеьные 
	double calculateExpression(String exp);
	double callJavaMath(String methodName, Object[] args);
	
	

}
