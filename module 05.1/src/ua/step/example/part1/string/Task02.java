package ua.step.example.part1.string;

/**
 * 
 * Escape последовательности
 *
 */
public class Task02
{
    public static void main(String[] args)
    {
        String s = "a\n+\r$\tb@";
        System.out.println(s);

        // использование двойных кавычек в строке требует экранирования
        s = "\"Коты не спрашивают, они просто берут все, что им надо.\"";
        System.out.println(s);

        // использование обратного слэша в строке требует экранирования
        String text = "\"Символ, которому предшествует наклонная черта влево (\\), "
                + "является escape-последовательностью и имеет особое значение в компиляторе.\"";
        System.out.println(text);
    }
}
