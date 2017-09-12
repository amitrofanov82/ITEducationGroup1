/**
 * 
 */
package home28.calculator;

import java.util.LinkedList;

/**
 * @author Alexander Neznaev
 * @see CalculatorModel
 */
public class MyCalc implements CalculatorModel {

	private LinkedList<String> history = new LinkedList<String>();

	private double memory = 0;

	private String screen = new String();
	// lastOperatorToApply
	private char lastOperator = '0';
	// lastResultInMemory - число,которое вводилось до текущего числа или
	// является результатом прошлой операции
	private double lastRes = 0;
	// currentNumber
	private String current = "0";

	private void doOperation(char currentOperator) {
		if ("Infinity".equals(screen)) {
			return;
		}
		// если пользователь нажал другой оператор не вводя число
		if (history.size() != 0 && Polish.OPERATORS.contains(history.getLast()) && "0".equals(current)) {
			history.removeLast();
			history.add("" + currentOperator);
			lastOperator = currentOperator;
			return;
		}
		if (history.size() == 0 && lastRes == 0) {
			history.add(screen);
			history.add("" + currentOperator);
			// отдельный случай, если последнее действие в скобках
		} else if (history.size() != 0 && history.getLast().charAt(0) == '(') {
			history.add("" + currentOperator);
		} else {
			history.add(screen);
			history.add("" + currentOperator);
		}
		// посчитать предудыщую оперцию
		if (lastOperator != '0') {
			lastRes = applyLastOperation();
			screen = "" + lastRes;
			// если не было введено ни одного оператора последний результат
			// равен текущему числу
		} else if (!"0".equals(screen)) {
			lastRes = Double.parseDouble(screen);
		}
		lastOperator = currentOperator;
		current = "0";
	}

	private Double applyLastOperation() {
		switch (lastOperator) {
		case '+':
			return lastRes + Double.parseDouble(current);
		case '-':
			return lastRes - Double.parseDouble(current);
		case '*':
			return lastRes * Double.parseDouble(current);
		case '/':
			return lastRes / Double.parseDouble(current);
		case 's':
			return lastRes / Double.parseDouble(current);
		default:
			break;
		}
		return lastRes;
	}

	@Override
	public void plus() {
		doOperation('+');
	}

	@Override
	public void minus() {
		doOperation('-');
	}

	@Override
	public void multiply() {
		doOperation('*');
	}

	@Override
	public void divide() {
		doOperation('/');
	}

	@Override
	public void plusMinus() {
		if ("Infinity".equals(screen)) {
			return;
		}
		// для нуля нет смысла знак менять
		if (!"0".equals(screen)) {
			if (!"0".equals(current)) {
				current = "-" + current;
			} else {
				current = "-" + lastRes;
			}
			screen = current;
		}
	}

	@Override
	public void inverseNumber() {
		if ("Infinity".equals(screen)) {
			return;
		}
		history.add("(1/" + current + ")");
		current = "" + 1 / (Double.parseDouble(current));
		screen = current;
	}

	@Override
	public void equalsNow() {
		if ("Infinity".equals(screen)) {
			return;
		}
		// если был введён оператор
		if (lastOperator != '0') {
			// если не введено после оператора ещё одно число, операция
			// проводится с этим же числом
			if ("0".equals(current)) {
				if (lastRes == 0) {
					current = screen;
					lastRes = Double.parseDouble(screen);
				} else {
					current = "" + lastRes;
				}
			}
			lastRes = applyLastOperation();
			screen = "" + lastRes;
		}
		lastRes = 0;
		history.clear();
		lastOperator = '0';
		current = "0";
	}

	@Override
	public void percent() {
		if ("Infinity".equals(screen)) {
			return;
		}
		history.add("(" + current + "% from " + lastRes + ")");
		screen = "" + ((lastRes / 100) * Double.parseDouble(current));
		current = "0";
	}

	@Override
	public void sqrt() {
		if ("Infinity".equals(screen)) {
			return;
		}

		history.add("sqrt(" + screen + ")");
		current = "" + Math.sqrt(Double.parseDouble(screen));
		screen = current;
	}

	@Override
	public void enterDigit(char digit) {
		if ("Infinity".equals(screen)) {
			return;
		}
		// особый случай если до этого была нажата кнопка "инверсия знака"
		if (Double.parseDouble(current) == lastRes * -1) {
			current = "0" + digit;
			// нельзя добавить две точки подряд
		} else if (current.contains(".")) {
			return;
		} else {
			if (history.size() != 0 && history.getLast().charAt(0) == '(') {
				history.removeLast();
			}
			current += digit;
			screen = current;
		}
	}

	@Override
	public void enterDigit(int digit) {
		if ("Infinity".equals(screen)) {
			return;
		}
		// особый случай если до этого была нажата кнопка "инверсия знака" или
		// это первый символ
		if ("0".equals(current) || Double.parseDouble(current) == lastRes * -1) {
			if (history.size() != 0 && history.getLast().charAt(0) == '(') {
				history.removeLast();
			}
			current = digit == 0 ? "00" : "" + digit;
			screen = "" + digit;
		} else {
			current += digit;
			screen += digit;
		}
	}

	@Override
	public void clear() {
		history.clear();
		screen = "0";
		lastRes = 0;
		current = "0";
		lastOperator = '0';
	}

	@Override
	public void clearError() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLastEnteredDigit() {
		if ("Infinity".equals(screen)) {
			return;
		}
		if (current.length() <= 1) {
			current = "0";
			return;
		}
		current = current.substring(0, current.length() - 1);
		screen = current;
	}

	@Override
	public void memoryRestore() {
		if ("Infinity".equals(screen)) {
			return;
		}
		current = "" + memory;
		screen = "" + memory;
	}

	@Override
	public void memorySave() {
		if ("Infinity".equals(screen)) {
			return;
		}
		memory = Double.parseDouble(screen);
	}

	@Override
	public void memoryClear() {
		if ("Infinity".equals(screen)) {
			return;
		}
		memory = 0;
	}

	@Override
	public double calculateExpression(String exp) {
		history.add(exp);
		screen = "" + Polish.refactoring(exp);
		return 0;
	}

	@Override
	public double callJavaMath(String methodName, Object[] args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		if ("Infinity".equals(screen)) {
			return "Деление на ноль невозможно";
		} else {
			return history + "\n" + (memory != 0 ? "M" : "") + "\t" + screen;
		}
	}
}