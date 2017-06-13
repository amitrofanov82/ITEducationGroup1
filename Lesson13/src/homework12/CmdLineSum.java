
//Написать программу сложения двух чисел, полученых как аргументы командной строки.
package homework12;
///+
public class CmdLineSum {
    public static void main(String[] args) {
	if (args.length != 2) {
	    System.err.println("Usage: Home12.Polindrom <number1> <number2>"); ///Ерр тут не в тему. Аут лучше. Ерр скорее для ситуаций, когда сама программа не может корректно обработать данные, или какой отловленный сбой.  А тут правильное поведение, предсказуемое. Разве что если предполагается использование подобной программы в скриптах автоматизации - тогда ерр может быть в тему. 
	    System.exit(0);
	}

	String check = args[0] + args[1];

	// защита от ввода символов
	check(check);

	System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
    }
    
    
    
///подход то правильный. Когда-то давно так и писали много где. Но в джаве есть инструменты и стандартные классы, которые избавляют от это рутины. Мы их будем примерно через месяц проходить. Если есть желание забежать вперёд - то тема эта называется обработка исключений. Integer.parseInt, кстати, их вполне себе успешно и проверяет сам. Так что в твоей программе уже 2 таких провверки. Только парсИнт реагирует на ошибку не Систе.аутом, а этими исключениями, о которых через месяц.
    private static void check(String input) {
	String numbers = "0123456789";

	for (int i = 0; i < input.length(); i++) {
	    boolean exist = false;
	    for (int j = 0; j < numbers.length(); j++) {
		if (numbers.charAt(j) == input.charAt(i)) {
		    exist = true;
		    break;
		}
	    }
	    if (!exist) {
		System.err.println("Only numbers are supported!");
		System.exit(0);
	    }
	}
    }
}