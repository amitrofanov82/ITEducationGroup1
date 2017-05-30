package teacher.homework.lesson8;

import java.util.Scanner;

public class inputExample {

	public static void main(String[] args) {
		//char inChar;
		int inInt;
		double inDouble;
		
		System.err.println("message err");
		System.out.println("message out");
		//BufferedReader reader=new BufferedReader(new InputSteramReader(System.in);//reader
		
		Scanner scanner=new Scanner(System.in);
		inDouble=scanner.nextDouble();
		inInt=scanner.nextInt();
		System.out.println(inInt);
		System.out.println(inDouble);
	}

}
