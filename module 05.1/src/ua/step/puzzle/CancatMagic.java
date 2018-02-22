package ua.step.puzzle;

/**
 * Ох уж эта магическая канкатинация строк
 */
public class CancatMagic
{
    public static void main(String[] args)
    {
        String one = "one";
        String two = "two";
        // FIXME почему строка кода ниже выдает false, хотя строка ниже true? 
        System.out.println((one + two) == "onetwo");
        System.out.println(("one" + "two") == "onetwo");
    }
}