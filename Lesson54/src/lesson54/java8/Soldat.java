package lesson54.java8;

import java.util.function.Supplier;

public class Soldat {
	
	public int nomer;

	public boolean executeOrder(/*Order*/Supplier<String> o) {
		String executionResult;
		if ((executionResult = o./*execute*/get()) == null){
			return false;
		}
		System.out.println("Soldier " + toString() 
			+ "executed order: " +  executionResult);
		return true;
	}
	
	public int helpOfficersSon(MathFunction func, Double val){
		return (int) func.apply/*calculate*/(val).doubleValue();
	}
	
	@Override
	public String toString() {
		return nomer+"-й";
	}
	
}
