package examples30.calculator;

public class IndusskijKalkulator implements CalculatorModel {
	
	//boolean enabled=true;
	//boolean readyForInput;
	private String screen = "";
	private String history = "";
	private char lastOperatortoApply = 0;
	private String lastResultInMemory = ""; //число, которое вводилось до текущего числа, или является резульатом прошлой опреации. 
	private String currentNumber = "";
	
	
	

	@Override
	public void plus() {
		if (lastOperatortoApply != 0){
			lastResultInMemory = applyLastOpertion().toString();
			currentNumber = "0";
			lastOperatortoApply = '+';
			screen = lastResultInMemory;
			return;
		}
		lastResultInMemory = currentNumber;
		currentNumber = "0";
		lastOperatortoApply = '+';
		screen = lastResultInMemory;
	}

	private Double applyLastOpertion() {
		switch (lastOperatortoApply) {
		case '+':
			return Double.parseDouble(lastResultInMemory) 
					+ Double.parseDouble(currentNumber);
		case '-':
			return Double.parseDouble(lastResultInMemory) 
					- Double.parseDouble(currentNumber);
		case '*':
			return Double.parseDouble(lastResultInMemory) 
					* Double.parseDouble(currentNumber);
		case '/':
			return Double.parseDouble(lastResultInMemory) 
					/ Double.parseDouble(currentNumber);
		}
		return 0.0;
	}

	@Override
	public void minus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void multiply() {
		// TODO Auto-generated method stub

	}

	@Override
	public void divide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void plusMinus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inverseNumber() {
		// TODO Auto-generated method stub

	}

	@Override
	public void equalsNow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void percent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sqrt() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDigit(char digit) {
		currentNumber = currentNumber + digit;
		screen = currentNumber; 
	}

	@Override
	public void enterDigit(int digit) {
		currentNumber = currentNumber + digit;
		screen = currentNumber;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearError() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLastEnteredDigit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void memoryRestore() {
		// TODO Auto-generated method stub

	}

	@Override
	public void memorySave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void memoryClear() {
		// TODO Auto-generated method stub
	}

	@Override
	public double calculateExpression(String exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double callJavaMath(String methodName, Object[] args) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString(){
		return screen;
		/*if (Math.random() > 0.5) {
			return "10";
		} else {
			return "11";
		}*/
	} 

}
