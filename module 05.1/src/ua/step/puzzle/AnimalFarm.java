package ua.step.puzzle;


public class AnimalFarm
{
    public static void main(String[] args)
    {
        String pig = "lenght: 10";
        String dog = "lenght: " + pig.length();
        // Почему не выводится часть строки Animals qre equal:
        System.out.println("Animals qre equal: " + pig == dog);
    }
}
