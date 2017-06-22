
public class Methods {
	public static void main(String[] args) {
		sum(2, 3);
		
	}

	private static int sum(int i, int j) {
		return i+j;
	}
	
	/*нельзя private static void sum(int i, int j) {
		return i+j;
	}*/ 
	
	private static void sum(int i, int j, int k) {
		return;
	}
	
	private static int sum(int i, int j, int k, boolean b) {
		return i+j;
	}
	
	private static long sum(char i, int j) {
		return i+j;
	}
	
	
	
}
