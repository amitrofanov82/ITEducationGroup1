//Посчитать n-й член последовательности Фибоначи рекурсивным методом 
package homework12;

///+, только там вроде ещё 0 первый долже быть, хотя это уже не принципиально с точки зрения джавы. 
import java.util.Scanner;

public class Fibonachi {

	public static void main(String[] args) {
		Scanner take = new Scanner(System.in);
		long toFib;
		do {
			System.out.print("Input Fibonacci number: ");
			toFib = take.nextInt();
		} while (toFib < 1 || toFib > 100);

		System.out.println(fib(toFib));

		System.out.println(fib2(toFib));
	}

	private static long fib(long n) {
		if (n < 3) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	private static long fib2(long n) {
		long sum1 = 1, sum2 = 1;
		for (int i = 2; i < n; i++) {
			sum1 += sum2;
			sum2 = sum1 - sum2;
		}
		return sum1;
	}
}