package ua.step.example.part1.string;

/**
 * 
 * Проверка на пустую строку.
 *
 */
public class Task06
{
    public static void main(String[] args)
    {
        String catname = "";
        // String catname = "cat";
        
        if (catname.isEmpty()) // вызов метода
        {
            System.out.println("Котиков нет, печалька");
        }
        else
        {
            System.out.println("Котик есть, котик не может не есть");
        }
        //FIXME раззкоментируй строку 13 и закоментируй 12 запусти приложение еще раз
    }
}