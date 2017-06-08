
public class Stroki {
	public static void main(String[] args) {
		String stroka = "Hello world";
		int[] a = {1,2};
		char[] cmass = stroka.toCharArray();
		int dlina = stroka.length();
		char simvol = stroka.charAt(1); //'e'
		
		char[] cmass2 = "pRiVet".toCharArray();
		
		String strokaIzMassiva = new String(cmass); 
		
		//Добавляем восклицательный знак в конце:
		char[] newStringChars = new char[stroka.length() + 1];
		for (int i = 0; i < stroka.length(); i++){
			newStringChars[i] = stroka.charAt(i);
		}
		newStringChars[newStringChars.length - 1] = '!';
		String newStringWithZnak = new String(newStringChars);
		
		System.out.println(newStringWithZnak);
		
	}
}
