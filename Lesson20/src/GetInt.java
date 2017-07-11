import java.util.Scanner;
///изобретение велосипеда, конечно. Попдобные проверки в будущем будут использоваться готовые из Джавы.
///Потому сейчас я всего этого не ожидаю в заданиях.
///Но хорошо сделан велосипед. 
public class GetInt {
    public static int get() {
	Scanner take = new Scanner(System.in);

	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}
	// take.close();

	return Integer.parseInt(input);
    }

	///раз уж этот класс у тебя предназначен для ввода целого числа для внешних пользователей, то чек лучше прайаит сделать. Внешнему миру число надо, а чек - внутренний функцонал
    public static boolean check(String input) {
	//если ничего не введено или длина больше максимальной длины для int
	if (input.length() < 1 || input.length() > 11) {
	    return false;
	}

	for (int i = 0; i < input.length(); i++) {
	    //если первый символ минус и он не единственный, продолжить, в противном случае - false
	    if (i == 0 && input.charAt(i) == '-') {
		if (input.length() > 1) {
		    continue;
		} else {
		    return false;
		}
	    }
	    boolean exist = false;
	    for (char j = '0'; j <= '9'; j++) {
		//совпадает ли каждый поседующий с арабскими цифрами
		if (j == input.charAt(i)) {
		    exist = true;
		    break;
		}
	    }
	    if (!exist) {
		return false;
	    }
	}
	if (input.length() > 8) {
	    //преобразовать строку во временную переменную типа long для сравнения с минимальным и максимальным значением
	    Long one = Long.parseLong(input);
	    if (one < -2147483648 || one > 2147483647) {
		return false;
	    }
	}
	return true;
    }
}