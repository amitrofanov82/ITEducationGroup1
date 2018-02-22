package ua.step.homework;

import java.util.Scanner;

/**
 * 
 * Написать программу которая создаст строку в которой все целые числа начиная с
 * 1 выписаны в одну строку «123456789101112131415...». В строке входных данных
 * записано целое число n (1 ≤ n ≤ 1000) — где n позиция цифры, которую вам
 * требуется вывести. По данному числу n выведите цифру на n-й позиции
 * (используется нумерация с 1).
 */
public class Task02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер позиции");
        int position = scanner.nextInt();

    }
}