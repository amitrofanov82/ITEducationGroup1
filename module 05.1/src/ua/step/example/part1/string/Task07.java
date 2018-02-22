package ua.step.example.part1.string;

/**
 * 
 * Получение символа из строки по индексу.
 *
 */
public class Task07
{
    public static void main(String[] args)
    {
        String testString = "Котёнок";
        // метод возвращает третий символ из строки
        int index = 2;
        char myChar = testString.charAt(index); 
        System.out.println(myChar);

        // FIXME написать прорграмму, которая выведет каждую букву из строки
        // testString в отдельной строке
        // Подсказка: в парасетре метода можно использовать переменную из цикла for 
    }
}
