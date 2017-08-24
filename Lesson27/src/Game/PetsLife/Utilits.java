package Game.PetsLife;

import java.util.Scanner;

/**
 * Класс для отдельных методов. <br>
 * <br>
 * Содержит методы: <br>
 * <b>{@link Game.PetsLife.Utilits.CheckString}</b> - проверка на одинаковость
 * даных типа <b>String</b>.<br>
 * <b>{@link Game.PetsLife.Utilits.PrintPet}</b> - выводит изображения питомца,
 * в соответсвии с полученым параметром <b>type</b>. <br>
 * <b>{@link Game.PetsLife.Utilits.CreateApetName}</b> - Запрашивает у
 * пользователя имя питомца, и возвращает его.<br>
 * <b>{@link Game.PetsLife.Utilits.SelectingPetType}</b> - Запрашивает у
 * пользователя тип питомца, и возвращает его.<br>
 */
public class Utilits {

	/**
	 * Метод принимает две переменные типа <b>String</b> и сравнивает их. <br>
	 * При полном совпадении возвращает <b>true</b>, иначе <b>false.</b>
	 * 
	 * @param first
	 *            <br>
	 *            <i>Принимает первое значение для сравнениия.</i>
	 * 
	 * @param second
	 *            <br>
	 *            <i>Принимает второе значение для сравнениия.</i>
	 * 
	 * @return <b>true</b> - <i>При полном совпадении.</i> <br>
	 *         <b>false.</b> - <i>При не совпадении.</i>
	 */
	public static boolean CheckString(String first, String second) {
		char[] firstCharArray;
		char[] secondCharArray;

		firstCharArray = first.toCharArray();
		secondCharArray = second.toCharArray();

		for (int i = 0; i < firstCharArray.length; i++) {
			if (firstCharArray[i] != secondCharArray[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Метод выводит изображения питомца, в соответсвии с полученым параметром <b>type</b>. <br>
	 * @param type - <b>тип String</b>.
	 * 	 */
	public static void PrintPet(String type) {
		// TODO  Homework_Lesson_17.Game.PetsLife.Utilits.PrintStatus()
		return;
	}

	/**
	 * Метод возвращает значение <b>name</b> веденое пользователем.<br>
	 * <br>
	 * Запускается бесконечный цикл.<br>
	 * У пользователя запрашиваеться ввод имени. <br>
	 * После програма требует подверждения, путём ввода <b>yes</b>.<br>
	 * Если пользователь не ввел подверждение, программа запрашивает имя
	 * снова.<br>
	 * После ввода подверждения цикл прерываеться.<br>
	 * Метод оканчивает работу возвращая строку введёную и подверждёную
	 * пользователем.<br>
	 * 
	 * @return - возвращает тип <b>String</b>.
	 */
	public static String CreatePetName() {
		@SuppressWarnings("resource") // что бы не ругалось на сканер
		Scanner sc = new Scanner(System.in);
		String name = null;
		while (true) {
			System.out.println("Как мы будем называть питомца?");
			System.out.println("How shall we call a pet?");
			name = sc.nextLine();
			// Check correct input
			System.out.println("Его имя будет: \"" + name + "\" ?");
			System.out.println("His name is: \"" + name + "\" ?");
			System.out.println("Для подверждения ведите \"yes\" ");
			System.out.println("For confirmation enter \"yes\" ");
			String check = sc.nextLine();
			if (Utilits.CheckString(check, "yes")) {
				break;
			}
		}
		return name;
	}

	/**
	 * Метод возвращает значение <b>type</b> веденое пользователем.<br>
	 * <br>
	 * Запускается бесконечный цикл.<br>
	 * У пользователя запрашиваеться ввод типа питомца. <br>
	 * После проверяеться коректность ввода. <b>yes</b>.<br>
	 * Если пользователь ввел тип питомца коректно, программа прерывает цикл.<br>
	 * Метод оканчивает работу возвращая строку введёную пользователем.<br>
	 * 
	 * @return - возвращает тип <b>String</b>.
	 */
	public static String SelectingPetType() {
		@SuppressWarnings("resource") // что бы не ругалось на сканер
		Scanner sc = new Scanner(System.in);

		String type = null;
		System.out.println("Выберите питомца: ");
		System.out.println("Choise a pet: ");
		while (true) {
			System.out.println("Dragon, Dog, Cat, Monkey, Bird, Fish");
			type = sc.nextLine();

			// Check correct input
			if (Utilits.CheckString(type, "Dragon")) {
				break;
			}
			if (Utilits.CheckString(type, "Dog")) {
				break;
			}
			if (Utilits.CheckString(type, "Cat")) {
				break;
			}
			if (Utilits.CheckString(type, "Monkey")) {
				break;
			}
			if (Utilits.CheckString(type, "Bird")) {
				break;
			}
			if (Utilits.CheckString(type, "Fish")) {
				break;
			}
		}

		return type;
	}
}
