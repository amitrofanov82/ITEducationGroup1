
package Game.PetsLife;

import java.util.Scanner;

/**
 * Надеюсь все в курсе, кто такой тамагочи. Что-то вроде него и пишем.
 * А кто не в курсе и не хочет гуглить всякую ерунду, считайте, что это просто домашнее животное.
 * Надо создать класс, описывающий это домашнее животное.
 * И методы, которые могут быть к этому животному применимы.
 * Методы возможны разные - с параметрами и без, с возвращаемыми значениями и без.
 * Изменяющие состояние животного, или что-то пишущие на экран, или просто возвращающие значения
 * для обработки во внешнем меотде (например в мэйне).
 * Какие у этого животного будут свйства (переменные) и действия - решайте сами.
 * Каким конструктором (или разными конструкторами) его можно создавать - тоже решайте сами.
 * Желательно, чтоб там были какие-нибудь условные алгоритмы, а не просто  принтлн.
 * Например не дам лапу, если голодный, пока не покормят.
 * После создания этого класса напишите в мэйне основную программу,
 * которая даст пользователю с помощью меню выбора купить себе такого питомца
 * с нужными пользователю свойствами. А потом пользователь пусть совершает с ним
 * набор каких захочет действий (покормить, дай лапу, голос, оторвать ногу… ).
 * 
 * 
 * Усложнение - создать два таких зверя, и чтобы в их переменных были ссулки друг на друга.
 * И написать такие методы, которые позволяют одному зверю воздействовать на другого зверя
 * (например укусить, в результате чего второй зверь болеет, и не дает лапу, пока его не вылеччат).
 * @author Ilya Zhukov
 */
public class PetsLife {

	/**
	 * blablabla
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource") // что бы не ругалось на сканер
		Scanner sc = new Scanner(System.in);
		// @ Start menu
		String type = Utilits.SelectingPetType();
		;
		String name = Utilits.CreatePetName();

		// @ Create pet
		Pet pet = new Pet(type, name);

		// @ Game
		boolean flagGame = false;
		while (!flagGame) {

			// @ UI
			Utilits.PrintPet(pet.ReturnPetType());
			//проверка на потребность питомца
			pet.Alarm();
			
			
			System.out.println("\r" + "\"Что будем делать?\"");
			System.out.println("\"What you want doing ?\"");
			System.out.println("\"Кушать\" , \"Играть\" , \"Убивать\" , \"Спросить\" как дела , \"ничего\"");
			System.out.println("\"feed\" , \"play\" , \"kill\" , \"ask\" - how are you doing , \"nothing\"");

			String choise = sc.nextLine();
			if (Utilits.CheckString(choise, "feed")) {
				pet.Eating();
			}

			if (Utilits.CheckString(choise, "play")) {
				pet.Play();
			}

			if (Utilits.CheckString(choise, "kill")) {
				if (pet.CheakDeath()) {
					System.out.println("Прощай убийца!");
					System.out.println("Farewell Killer!");
					flagGame = true;
				}

			}

			if (Utilits.CheckString(choise, "ask")) {
				pet.HowDoYou();

			}

			if (Utilits.CheckString(choise, "stop")) {
				if (pet.Death()) {
					flagGame = true;
				}
			}

			if (Utilits.CheckString(choise, "nothing")) {
				System.out.println("Прошел час");
				System.out.println("An hour has passed");
			}
			
			
			
			// проверка жив ли питомец
			if (pet.Death()) {
				flagGame = true;
			}
			
			pet.Aging();

		}

	}

}
