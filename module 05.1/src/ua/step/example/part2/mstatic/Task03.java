package ua.step.example.part2.mstatic;

/**
 * 
 * Форматирование данных в строке
 *
 */
public class Task03
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.printf("%d", i * j + i + j); // выделение места под
                                                        // число
            }
            System.out.printf("%n"); // новая строка
        }
    }
}
// FIXME исправь пример чтобы в консоле было видно строки и столбцы, как в примере ниже: 
/*
  0  1  2  3  4
  1  3  5  7  9
  2  5  8 11 14
  3  7 11 15 19
  4  9 14 19 24
*/