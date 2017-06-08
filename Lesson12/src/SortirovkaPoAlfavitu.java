
public class SortirovkaPoAlfavitu {
	
	public static void main(String[] args) {
		String stroka = "ghvjhvxcuytr";
		char[] charArray = stroka.toCharArray();
		
		for (int i =0; i < charArray.length; i++){
			for (int j = i; j <  charArray.length; j++){
				if (charArray[i] > charArray[j]){
					char temp = charArray[i];
					charArray[i] = charArray[j];
					charArray[j] = temp;
				}
			}
		}
		System.out.println(charArray);
		System.out.println(new String(charArray));
	}

}
