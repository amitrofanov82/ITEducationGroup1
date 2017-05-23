package homeworks;

public class SimpleNumber {
	
	public static void main(String[] args) {
		int N = 1231231;
		boolean etoChisloNeprostoe = false;
		
		
		for (int i = 2 ; i<N; i++) {
			if (N % i == 0) {
				//N не простое
				System.out.println(" не простое");
				etoChisloNeprostoe = !false;
				break;
				//System.exit(0);
			}
		}
		if (!etoChisloNeprostoe) {
			System.out.println("простое");
		}
		
	}
	
	

	
}
