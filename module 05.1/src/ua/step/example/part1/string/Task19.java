package ua.step.example.part1.string;

/**
 * 
 * Удаение начальных и конечных пробелов
 *
 */
public class Task19
{
    public static void main(String[] args)
    {
        String cat = "     кот в пробелах        ";
        // метод trim возвращает новую строку в которой все пробельные сиволы в
        // начале и в концуе удалены. Пробелы в середине строки не удаляются.
        System.out.println("_" + cat.trim() + "_");
    }
}