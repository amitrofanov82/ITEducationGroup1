package examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputExample {
	public static void main(String[] args) {
		//char inChar;
		int  inInt;
		double inDouble;
		
		System.out.println("message to out");
		System.err.println("message to err");
		
		/*BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));*/
		
		Scanner scanner = new Scanner(System.in);
		inDouble = scanner.nextDouble();
		inInt = scanner.nextInt();
		System.out.println(inDouble);
		System.out.println(inInt);
		//System.in.....
	}
}
