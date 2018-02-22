package ua.step.puzzle;

public class Hello
{
    public static void main(String[] args)
    {
        String s1 = "hello";
        final String s2 = "hel";
        String s3 = "lo";
        String s4 = "hello";
        System.out.println(s1 == s4);
        System.out.println(s1 == s2 + s3);
        System.out.println(s1 == s2 + "lo");
    }

}
