package ua.step.example.part1.string;

/**
 * 
 * Проверка содержит ли строка подстроку.
 *
 */
public class Task08
{
    public static void main(String[] args)
    {
        String testString = "котёнок";
        // метод contains возвращает true если строка для которой он был вызван
        // содержит подстроку кот
        if (testString.contains("кот"))
        {
            System.out.println("Котёнок - это маленький кот!");
        }
        // метод contains - регистрозависимый
        if (testString.contains("Кот"))
        {
            System.out.println("Котёнок все же маленький кот!");
        }
    }
}
