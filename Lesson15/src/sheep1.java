public class sheep1 {

	public static void main(String[] args) {

		boolean check[] = { false, false, false, false, false, false, false, false, false, false };
		int n = 1, s = 0, digit = 0;
		for (int i = 1; i < 100; i++) {
			s = n * i;
			int b = digitsInNumber(s); // количество чисел в текущем числе
			for (int k = 0; k < b; k++) {
				// разбиваем число на отдельные цифры
				digit = findDititByIndex(s, k);
				check[digit] = true;
			}
			
			// если массив check содержит true, значит все числа от 0 до 9 уже
			// встречались
			if (checkDigits(check)) {
				System.out.println("Sheep will fall asleep on number " + s);
				//System.out.println("Last number is " + digit);
				break;
			}
			System.out.println("last number " + s);
			printMass(check);
			// если количество циклов перевалит за 100, то у овечки явно
			// бессонница :)
			if (i == 100) {
				System.out.println("insomnia");
				break;
			}
		}

	}

	private static boolean checkDigits(boolean[] check) {
		for (int h = 0; h < check.length; h++) {
			if (check[h]==false) {
				return false;
			}
		}
		return true;
	}

	private static int digitsInNumber(int number) {
		int counter = 0;
		if (number == 0) {
			return 1;
		}
		while (number != 0) {
			number = number / 10;
			counter++;
		}

		return counter;
	}

	private static int findDititByIndex(int number, int index) {
		number = number / (int) (Math.pow(10, index));

		return number % 10;
	}
	
	private static void printMass(boolean[] mass) {
		for (int i=0; i<mass.length; i++){
			System.out.print(mass[i] + "  ");
		}
		System.out.println();
	}
}