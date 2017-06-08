//Определить в одномерном числовом массиве A из n элементов типа чар, сколько раз в нем встречается последовательность ‘p’, ‘r’,’i’,’v’,’e’,’t’
//Усложнение - в любом регистре, сохранив при этом оригинальный массив неизменным
//Усложнение 2 - в любом регистре, сохранив при этом оригинальный массив неизменным, и не используя другого массива длинной более 6.

///выглядит примерно так, как я и ожидал. Все правильно. Если только какую мелочь не проглядел. Если на тестах все правильно, то не проглядел
///+. только к инт[] замечание
public class Privet92 {
	private final static int MASSLENGTH = 100000000;

	public static void main(String[] args) {
		char[] mass = /* {'p', 'R', 'i', 'V', 'e', 't'} */new char[MASSLENGTH]; /// инт
																				/// всё
																				/// же
																				/// зря.
																				/// Чар
																				/// правильнее
																				/// и
																				/// по
																				/// смыслу,
																				/// и
																				/// 4
																				/// байта
																				/// против
																				/// двух
		boolean loop = false;

		while (!loop) {
			for (int i = 0; i < MASSLENGTH; i++) {
				mass[i] = (char) (65 + 32 * (int) (Math.random() * 2) + (int) (Math.random() * 26));
			}
			// print(mass);
			long time = System.currentTimeMillis();
			loop = findPrivet(mass);
			System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0);
		}
	}

	private static void print(int[] array) {
		int counter = 0;
		for (int k = 0; k < MASSLENGTH; k++) {
			System.out.print((char) array[k] + "|");
			counter++;
			if (counter % 25 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	private static boolean findPrivet(char[] array) {
		int amount = 0, check = 0;
		char[] privet = { 'P', 'R', 'I', 'V', 'E', 'T' };
		for (int i = 0; i < MASSLENGTH - privet.length; i++) {
			// если найден первый символ последовательности в любом регистре
			if (array[i] == privet[0] || array[i] == privet[0] + 32) {
				check = 1;
				// проверить последовательно идущие за ним
				for (int j = 1; j < privet.length; j++) {
					if (array[i + j] == privet[j] || array[i + j] == privet[j] + 32) {
						check++;
					}
				}
				// если все 6 символов идут подряд
				if (check == 6) {
					for (int k = 0; k < privet.length; k++) {
						System.out.print((char) array[i + k] + " ");
					}
					System.out.println();
					amount++;
				}
			}
		}
		System.out.println("The sequence privet is encountered " + amount + " times");
		if (amount != 0) {
			return true;
		}
		return false;
	}
}