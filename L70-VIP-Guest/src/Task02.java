
/**
 * 
 * Регулярные выражения
 *
 */
public class Task02
{
    public static void main(String[] args)
    {
        String email = "sadouski@itstep.org";
        // + обозначает «один или несколько экземпляров непосредственно
        // предшествующего элемента
        // | обозначает «или». Подвыражения, объединенные этим способом,
        // называются альтернативами (alternatives)
        String regular = ".+\\.(com|ua|ru)";
        System.out.println(email.matches(regular));
    }
}