/**
 * 
 * Регулярные выражения
 *
 */
public class Task05
{
    public static void main(String[] args)
    {
        String regular = "[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))";
        System.out.println(regular);
        System.out.println("sadouski@itstep.org".matches(regular));
        System.out.println("1sadouski@itstep.org".matches(regular));
        System.out.println("sadouski@@itstep.org".matches(regular));
        System.out.println("v.sadouski@itstep..org".matches(regular));
    }
}
