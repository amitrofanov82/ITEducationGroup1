package Game.PetsLife;

import java.util.Scanner;

/**
 * Класс клас конструктор для создания объекта "Pet". <br>
 * <br>
 * Содержит методы:<br>
 * {@link Game.PetsLife.Pet.CheakDeath} - Метод проверяет уверен ли пользователь
 * в выборе.<br>
 * {@link Game.PetsLife.Pet.Death} - Метод запуска остановки програмы. <br>
 * {@link Game.PetsLife.Pet.Eating} - Метод выполняет механизм кормежки, в
 * соотвествии с <b>type</b> питомца. <br>
 * {@link Game.PetsLife.Pet.Play} - <br>
 * 
 * {@link Game.PetsLife.Pet.PrintStatus} - Метод выводит статус свойств питомца.
 * <br>
 * {@link Game.PetsLife.Pet.ReturnPetType} - Метод возвращает свойство обекта
 * <b>type</b> <br>
 * {@link Game.PetsLife.Pet.HowDoYou} - <br>
 * 
 * @param type
 *            <i> - принимает какой питомец будет создан.</i> <br>
 * @param name
 *            <i> - имя создоваемого питомеца.</i> <br>
 *
 * @author Ilya Zhukov
 *
 */

public class Pet {

	Scanner sc = new Scanner(System.in);
	private String type;
	private String name;
	private int happiness = 0;
	private int hunger = 0;
	private int AgeDays = 0;
	private int AgeHours = 0;
	private boolean anger = false;

	// constructor
	public Pet(String type, String name) {
		this.type = type;
		this.name = name;

	}

	/**
	 * Метод выполняет механизм кормежки, в соотвествии с <b>type</b> питомца.
	 * <br>
	 * После ввода типа еды, метод увеличивает или убавляет соответстующие
	 * свойства. <br>
	 * Для остановки кормежки необходимо ввести "<b>stop</b>".<br>
	 * Для для подсказки о кормежке необходимо ввести "<b>help</b>".<br>
	 */
	public void Eating() {
		System.out.println("Для остановки процеса кормёжки введите \"stop\"");
		System.out.println("To stop the feed process, entered \"stop\"");
		System.out.println("Если вам нужна подсказка введите \"help\"");
		System.out.println("If you need a hint, entered  \"help\"");
		while (true) {
			System.out.println("\r" + "Что кушаем?");
			System.out.println("What eting?");
			System.out.println("meat , fish , fruit , vegetables");
			String foodType = sc.next();

			switch (foodType) {
			case "meat":
				if (Utilits.CheckString(type, "Dragon")) {
					this.hunger = this.hunger + 5;
					this.happiness = this.happiness + 10;
					System.out.println("\"Я люблю мясо, только его будут есть.\"");
					System.out.println("\"I love meat, only they would eat.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Dog")) {
					this.hunger = this.hunger + 5;
					this.happiness = this.happiness + 10;
					System.out.println("\"Мясо, которое я люблю. Я счастлив, когда ем мясо.\"");
					System.out.println("\"Meat I love. I'm happy when I eat meat.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Cat")) {
					this.hunger = this.hunger + 2;
					this.happiness = this.happiness + 5;
					System.out.println("\"Наконец нормальная еда.\"");
					System.out.println("\"Finally a normal meal.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Monkey")) {
					this.hunger = this.hunger - 1;
					// this.happiness = this.happiness;
					System.out.println("\"Извините. Я не ем это.\"");
					System.out.println("\"Excuse me.I do not eat this.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Bird")) {
					this.hunger = this.hunger - 1;
					// this.happiness = this.happiness;
					System.out.println("\"Я не ем это.\"");
					System.out.println("\"I do not eat this.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Fish")) {
					// this.hunger = this.hunger;
					// this.happiness = this.happiness;
					System.out.println("\"Что это плавает в моем аквариуме?\"");
					System.out.println("\"What does this float in my aquarium?\"" + "\r");
				}
				break;

			case "fish":
				if (Utilits.CheckString(type, "Dragon")) {
					this.hunger = this.hunger - 1;
					this.happiness = this.happiness - 5;
					System.out.println("\"Я не ем это, не зли меня!\"");
					System.out.println("\"I do not eat this, do not make me angry!\"" + "\r");
				}
				if (Utilits.CheckString(type, "Dog")) {
					// this.hunger = this.hunger;
					this.happiness = this.happiness - 1;
					System.out.println("\"Я не ем это.\"");
					System.out.println("\"I do not eat this.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Cat")) {
					this.hunger = this.hunger + 5;
					this.happiness = this.happiness + 10;
					System.out.println("\"Рыбка, рыбка, рыбка...\" *Ном! *Ном! *Ном!...");
					System.out.println("\"Fish, fish, fish...\" *Yum! *Yum! *Yum!..." + "\r");
				}
				if (Utilits.CheckString(type, "Monkey")) {
					this.hunger = this.hunger - 1;
					// this.happiness = this.happiness;
					System.out.println("\"Извините. Я не ем это.\"");
					System.out.println("\"Excuse me.I do not eat this.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Bird")) {
					this.hunger = this.hunger - 1;
					// this.happiness = this.happiness;
					System.out.println("\"Я не ем это.\"");
					System.out.println("\"I do not eat this.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Fish")) {
					this.hunger = this.hunger - 2;
					this.happiness = this.happiness - 5;
					System.out.println("\"AAAAAA, мертвая рыба!\"");
					System.out.println("\"AAAAAA, the dead fish!\"" + "\r");
				}
				break;

			case "fruit":
				if (Utilits.CheckString(type, "Dragon")) {
					this.hunger = this.hunger - 1;
					this.happiness = this.happiness - 5;
					System.out.println("\"Я не ем это, не зли меня!\"");
					System.out.println("\"I do not eat this, do not make me angry!\"" + "\r");
				}
				if (Utilits.CheckString(type, "Dog")) {
					this.hunger = this.hunger + 1;
					this.happiness = this.happiness + 3;
					System.out.println("\"Вкусно, но мало\"");
					System.out.println("\"Tasty, but not enough\"" + "\r");
				}
				if (Utilits.CheckString(type, "Cat")) {
					this.hunger = this.hunger + 1;
					this.happiness = this.happiness + 3;
					System.out.println("\"Ну, сойдет. \"");
					System.out.println("\"Well, that's okay too.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Monkey")) {
					this.hunger = this.hunger + 10;
					this.happiness = this.happiness + 10;
					System.out.println("\"Я люблю фрукты!\"");
					System.out.println("\"I love fruit!\"" + "\r");
				}
				if (Utilits.CheckString(type, "Bird")) {
					this.hunger = this.hunger + 1;
					this.happiness = this.happiness + 3;
					System.out.println("\"Нас и здесь не плохо кормят.\"");
					System.out.println("\"We are also well fed here\"" + "\r");
				}
				if (Utilits.CheckString(type, "Fish")) {
					// this.hunger = this.hunger;
					// this.happiness = this.happiness;
					System.out.println("\"Что это плавает в моем аквариуме?\"");
					System.out.println("\"What does this float in my aquarium?\"" + "\r");

				}
				break;

			case "vegetables":
				if (Utilits.CheckString(type, "Dragon")) {
					this.hunger = this.hunger - 1;
					this.happiness = this.happiness - 5;
					System.out.println("\"Я не ем это, не зли меня!\"");
					System.out.println("\"I do not eat this, do not make me angry!\"" + "\r");
				}
				if (Utilits.CheckString(type, "Dog")) {
					this.hunger = this.hunger + 1;
					this.happiness = this.happiness + 5;
					System.out.println("\"Пойду поем.\"");
					System.out.println("\"I'll go eat something.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Cat")) {
					this.hunger = this.hunger + 2;
					this.happiness = this.happiness + 1;
					System.out.println("\"Ну, сойдет.\"");
					System.out.println("\"Well, that's okay too.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Monkey")) {
					this.hunger = this.hunger + 5;
					this.happiness = this.happiness + 5;
					System.out.println("\"Очень вкусно. Спасибо\"");
					System.out.println("\"Delicious. Thank you\"" + "\r");
				}
				if (Utilits.CheckString(type, "Bird")) {
					this.hunger = this.hunger + 1;
					// this.happiness = this.happiness;
					System.out.println("\"Кажется, что это съедобно.\"");
					System.out.println("\"It seems like it's edible.\"" + "\r");
				}
				if (Utilits.CheckString(type, "Fish")) {
					this.hunger = this.hunger + 1;
					this.happiness = this.happiness + 1;
					System.out.println("\"Еда?\"");
					System.out.println("\"Food?\"");
				}
				break;

			case "stop":
				return;

			case "help":
				// TODO Homework_Lesson_17.Game.PetsLife.Pet.Eating - help
				System.out.println("In developing");
				break;

			default:
				System.out.println("Dont know such food type" + "\r");
			}
			if (happiness > -20) {
				this.anger = false;
			}
		}

	}

	/**
	 * Метод выводит статус свойств питомца.
	 */
	public void PrintStatus() {
		System.out.println("____________________________");
		System.out.println("Days.Hours = " + AgeDays + "." + AgeHours);
		System.out.println("Name = " + name);
		System.out.println("Type = " + type);
		System.out.println("Hapeenes = " + happiness);
		System.out.println("Hunger = " + hunger);
		System.out.println("____________________________");

	}

	/**
	 * Метод проверки все ли живы. <br>
	 * 
	 * @return <b>true</b> - <i>если <b>hunger</b> меньше -20 или свойство
	 *         <b>anger true</></i><br>
	 *         <b>false.</b> - <i>если <b>hunger</b> больше -20.</i><br>
	 */
	public boolean Death() {
		if (this.hunger < -20) {
			System.out.println("Питомец умер от голода");
			System.out.println("The pet died of hunger");
			return true;
		}
		if (anger) {
			System.out.println("\"Питомец в ярости убежал\"");
			System.out.println("\"The pet ran away in rage\"");
			return true;
		}

		return false;
	}

	/**
	 * Метод проверяет уверен ли пользователь в выборе. <br>
	 * Цикл будет крутиться бесконечно пока пользователь не введет коректно одно
	 * из ключевых слов: <br>
	 * <b>yes</b> или <b>no</b> <br>
	 * После передаёт <b>true</b> или <b>false</b> методу
	 * {@link Game.PetsLife.Pet.Death#Death()}. <br>
	 * 
	 * @return <b>true</b> - если пользователь ввел <b>yes</b>. <br>
	 *         <b>falce</b> - если пользователь ввел <b>no</b>.
	 */
	public boolean CheakDeath() {
		@SuppressWarnings("resource") // что бы не ругалось на сканер
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Вы уверены, что хотите убить питомца?");
			System.out.println("Are you sure you want to kill the pet?" + "\r");
			System.out.println("Для подверждения ведите \"yes\" или \"no\"");
			System.out.println("For confirmation enter \"yes\" or \"no\"");
			String check = sc.nextLine();
			if (Utilits.CheckString(check, "yes")) {
				return true;
			}
			if (Utilits.CheckString(check, "no")) {
				return false;
			}
		}
	}

	/**
	 * 
	 */
	public void Play() {
		// TODO Homework_Lesson_17.Game.PetsLife.Pet.Play()
		if (happiness > -20) {
			if (hunger < 0) {
				System.out.println("It's not funny, feed me!");
				this.happiness = this.happiness - 5;
			} else {
				this.happiness = this.happiness + 10;
				this.hunger = this.hunger - 1;
				System.out.println("It's funny");
			}
		} else {
			System.out.println("\"Ты разозлил меня!\"");
			System.out.println("\"You made me angry!\"");
			this.anger = true;
		}
	}

	/**
	 * 
	 */
	public void HowDoYou() {
		// TODO Homework_Lesson_17.Game.PetsLife.Pet.PrintStatus()
		PrintStatus();
	}

	/**
	 * Метод возвращает свойство обекта <b>type</b> <br>
	 * 
	 * @return - возвращает тип <b>String</b>.
	 */
	public String ReturnPetType() {
		String type = this.type;
		return type;
	}

	/**
	 * Метод после изменяет свойства объекта после каждого хода. Имитируя скуку.
	 */
	public void Aging() {
		this.happiness--;
		this.hunger--;
		if (this.AgeHours < 24) {
			this.AgeHours++;
		} else {
			this.AgeDays++;
			this.AgeHours = 0;
		}

	}

	/**
	 * Метод выводит пользователю, что пора покармить или поиграть с питомцем.
	 * <br>
	 * Если свойства <b>happiness</b> или <b>happiness</b> меньше 0 выводиться
	 * сообщение.
	 */
	public void Alarm() {
		if (!anger) {
			if (this.happiness < 0) {
				if (this.hunger < 0) {
					System.out.println("\"Покорми меня!\"");
					System.out.println("\"Feed me!\"");
				} else {
					System.out.println("\"Поиграй со мной!\"");
					System.out.println("\"Play with me!\"");
				}

			}
		}

	}

}
