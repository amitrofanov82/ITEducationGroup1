import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Transormer {

	
	
	
	
	
	public static void main(String[] args) {
		String text = "22-2222-222-123 sfkjg,./ffe\n sadg 34-5678-982 905546 90-456-23 5435-23-45";
		String regex = "(\\d{2})-(\\d{4})-(\\d{3})";
		System.out.println(text.replaceAll(regex, "$3/$2/$1"));
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()){
			System.out.println(m.group());
			text=text.replace(m.group(), f(m.group()));
		}

	}

	private static CharSequence f(String group) {
		
		return null;
	}

}
