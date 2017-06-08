
public class RekursivnyjFaktorial {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(factorial(n));
	}

	/**
	 * etot method ne prednaznachen dla otricatelnyh chisel
	 */
	private static int factorial(int n) {
		if(n > 1){
			return n * factorial(n-1);
		} else {
			return 1;
		}

	}
	
	
	
	
	
	
	
	
	
}
