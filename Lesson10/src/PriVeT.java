
public class PriVeT {
	
	public static void main(String[] args) {
		char[] charArray = {'p','R','i','V','e','T'};
		for(int i = 0; i < charArray.length; i++){
		//	if(charArray[i] >= 'a')
			if(charArray[i] >= 97 && charArray[i] <= 122)
			{
				charArray[i] = (char) (charArray[i] - 32);
			//	charArray[i] -= 'A' - 'a';
			}
		}
		
		for(int i = 0; i < charArray.length; i++){
			System.out.print(charArray[i]);
		}
	}
}
