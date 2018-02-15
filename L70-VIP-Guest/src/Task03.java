/**
 * 
 * Регулярные выражения
 *
 */
public class Task03
{
    public static void main(String[] args)
    {
        String regular = "[a-z]+";
        System.out.println("sadouski".matches(regular));
        System.out.println("sadouski@itstep.org".matches(regular));
    }
}