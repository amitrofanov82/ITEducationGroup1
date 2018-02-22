package ua.step.example.part1.string;

/**
 * 
 * Получение подстроки из строки
 *
 */
public class Task14
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        String string = "Клекот";
        // возвращает подстроку начиная с 3 индекса (4 символа) включительно
        String world = string.substring(3);
        System.out.println(world);

        // возвращает подстроку начиная с 1 индекса включительно(2 символа) и до
        // 4 индекса исключительно
        String beast = "скотина";
        System.out.println(beast.substring(1, 4));

        // FIXME получи слово стратегия из строки ниже, используя метод
        // substring
        String strategy = "контрстратегия";
    }
}