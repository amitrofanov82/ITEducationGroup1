
public class cake {
	public static void main(String[] args) {
		String cake = "++--+-+-+-+-+-+-";
		char[] cakeArr = cake.toCharArray();
		int n = 0;

		for (int i = 0; i < cake.length() - 1; i++) {
			if (cakeArr[i] != cakeArr[i + 1]) {
				n++;
			}
			if (cakeArr[i] == cake.length() && cakeArr[i] == '-') {

				n++;

			}
		}
		System.out.println(n);
	}
}
