package ua.step.homework;

import java.util.Scanner;

/**
 * 
 * Ввести с клавиатуры строку текста, а затем один символ. Показать на экран
 * индексы и количество совпадений (ищем вхождения символа в строку).
 *
 */
public class Task01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        System.out.println("Введите символ");
        String value = scanner.nextLine();
    }
}