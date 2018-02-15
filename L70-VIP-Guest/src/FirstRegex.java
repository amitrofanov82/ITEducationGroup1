import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstRegex {
	public static void main(String[] args) {
		String text = "text123123_2342@itstep.org.a.a.a.a.a.a";
		//String text = "\\'";
		//a-zA-Z0-9 int ^s, /\:*?><|"' .
		String regex = ".?";
		//String regex = "^.([^\\s\\,\\\\\\/:\\*\\?><|\\\"\\'@]){1,129}@(([^\\s\\,\\\\\\/:\\*\\?><|\\\"\\'@]){1,129}\\.([^\\s\\,\\\\\\/:\\*\\?><|\\\"\\'@\\.]){1,129}){1,5}";
		boolean match = "".matches(regex);
		//System.out.println(match);
		
        String email = "sadouski@itstep.com.com";
        // + обозначает «один или несколько экземпляров непосредственно
        // предшествующего элемента
        // | обозначает «или». Подвыражения, объединенные этим способом,
        // называются альтернативами (alternatives)
        String regular = "[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))";
        System.out.println(regular);
        System.out.println("sadouski@itstep.org".matches(regular));
        System.out.println("1sadouski@itstep.org".matches(regular));
        System.out.println("sadouski@@itstep.org".matches(regular));
        System.out.println("v.sadouski@itstep..org".matches(regular));
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");
        Matcher m = p.matcher("asdasd");
        while (m.find()){
        	
        }
        
	}
}
