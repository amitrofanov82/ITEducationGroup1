

public class MoreAboutStrings {

	public static void main(String[] args) {
		String s = "abcd";
		//s = s.replace("d", "defgh");
		//System.out.println(s);
		
		//modify(s);
		s = modify(s);
		System.out.println(s);
	}

	private static String modify(String s) {
		
		s = s.replace("d", "defgh");
		return s;
		
	}
	
}
























