public class sheep2 {

	public static void main(String[] args) {
		int[] numeral = new int[10];
		for (int i = 0; i < numeral.length; i++) {
			numeral[i] = i;
		}
		int number = 1;//(int) (Math.random() * 100);
		int[] dublNumeral = new int[10];
		dublNumeral[0]=-1;
		int dublNumber = number;
		int temp = 0;
		System.out.println(number);
		while ((numeral[0] != dublNumeral[0]) || (numeral[1] != dublNumeral[1]) || (numeral[2] != dublNumeral[2])
				|| (numeral[3] != dublNumeral[3]) || (numeral[4] != dublNumeral[4]) || (numeral[5] != dublNumeral[5])
				|| (numeral[6] != dublNumeral[6]) || (numeral[7] != dublNumeral[7]) || (numeral[8] != dublNumeral[8])
				|| (numeral[9] != dublNumeral[9])) {

			int tempNumber = number;
			while (tempNumber > 0) {
				dublNumeral[tempNumber % 10] = tempNumber % 10;
				tempNumber /= 10;
			}

			number = number + dublNumber;
			temp++;

		}

		for (int i = 0; i < dublNumeral.length; i++) {
			System.out.print(dublNumeral[i] + " ");
		}
		System.out.println();
		System.out.println(temp);
	}

}