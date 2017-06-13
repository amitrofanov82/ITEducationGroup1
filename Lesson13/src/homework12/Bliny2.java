package homework12;


public class Bliny2 {
	public static void main(String[] args) {
		String cake = "++--+-+-+-+-+-+-";
		char[] cakeArr = cake.toCharArray();
		int n = 0;

		for (int i = 0; i < cake.length() - 1; i++) {
			if (cakeArr[i] != cakeArr[i + 1]) {
				n++;
			}
		}
		if (cakeArr[cake.length()-1] == '-') {
			n++;
		}
		System.out.println(n);
	}
}
