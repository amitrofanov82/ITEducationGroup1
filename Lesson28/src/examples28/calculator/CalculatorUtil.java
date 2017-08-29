package examples28.calculator;

import java.util.LinkedList;
import java.util.List;

public class CalculatorUtil {
	
	public static final String OPERATORS = "+-*/";
	public static final String DIGITS = "0123456789.";
	

	public static Double calculate1(String exp) {
		/*
		  0) создать массив строк 
		  1) смотрим нулевой символ, если + или цифра
		  тогда в массив заносим + или - 
		  2) идем в цикле до след оператора
		  (+/-) 
		  3) когда находим s[1]= подсторка s[2] = знак
		 */

		List<String> array = new LinkedList<String>();
		if (exp.charAt(0) == '-') {
			array.add(0, "-");
			
		} else {
			array.add(0, "+");
			if (exp.charAt(0)!='+'){
				exp="+"+exp;
			}
		}
		int chisloStartIdx = 1;
		for (int i=chisloStartIdx; i<exp.length(); i++){
			for (int j = chisloStartIdx; j<exp.length(); j++) {
				if (OPERATORS.contains(exp.substring(j, j+1))
						|| (j == exp.length()-1) 	
					){
					String chisloNew;
					if (j == exp.length()-1) {
						chisloNew = exp.substring(chisloStartIdx, j+1);
						i=j+1;
						array.add(chisloNew);
						break;
					} else {
						chisloNew = exp.substring(chisloStartIdx, j);
					}
					array.add(chisloNew);
					array.add(exp.substring(j, j+1));
					chisloStartIdx = j + 1;
					i = chisloStartIdx;
					break;
				}
			}
		}
		System.out.println(array);
		double result = 0;
		for (int i =0; i<array.size(); i=i+2) {
			if (array.get(i).equals("+")) {
				result = result + Double.parseDouble(array.get(i+1));
			} else if (array.get(i).equals("-")) {
				result = result - Double.parseDouble(array.get(i+1));
			} else if (array.get(i).equals("*")) {
				result = result * Double.parseDouble(array.get(i+1));
			} else if (array.get(i).equals("/")) {
				result = result / Double.parseDouble(array.get(i+1));
			}	
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Double result = calculate1("2-2*22");
		System.out.println(result);
	}

}

























