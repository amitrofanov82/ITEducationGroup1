package examples28.calculator;

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
	//CE, C, ... все без параметров
	
	//дополнитиеьные 
	double calculateExpression(String exp);
	double callJavaMath(String methodName, Object[] args);
	
	

}
