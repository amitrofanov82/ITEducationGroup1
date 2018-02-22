package ua.step.example.part1.string;

/**
 * 
 * Конкатинация строк с вставкой разделителя. Метод добавлен в java 8
 *
 */
public class Task20
{
    public static void main(String[] args)
    {
        String message = String.join("-", "Java", "is", "cool");
        System.out.println(message);
    }
}