package ua.step.example.part1.string;
/**
 * 
 * Объединение (канкатинация) строк
 *
 */
public class Task03
{
    public static void main(String[] args)
    {
        String cat = "Кот"; // лиетрал строки
        String name = "Васька"; 
         // конкатинация строк с использование оператора сложения
        String fullname = cat + " " + name;  
        System.out.println(fullname);

        // конкатинация строк с использование метода
        fullname = cat.concat(name);
        System.out.println(cat); // исходная строка не изменилась
        System.out.println(fullname);
    }
}