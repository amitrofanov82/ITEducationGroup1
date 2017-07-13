package examples21.stack;

public class RecrsiaDebug {
	public static void main(String[] args) {
		
		sum(5);
	}
	
	public static int sum(int a) {
		if (a == 1) {
			return 1;
		}
		return a + sum (a-1);
	}
}






















