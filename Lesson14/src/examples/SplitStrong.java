package examples;

public class SplitStrong {
	
	public static void main(String[] args) {
		String strokaIzslov = "Mama myla ramu";
		//String[] slova = split(strokaIzslov);
		//print(strokaIzslov.split(" "));
		System.out.println((strokaIzslov.substring(5, 9)));
		
		String abc = new String("" + "as");
		
		
		
		
	}

	private static String[] split(String strokaIzslov) {
		String[] result = null;
		int slova = 1;
		for (int i=0; i < strokaIzslov.length(); i++){
			if (strokaIzslov.charAt(i) == ' '){
				slova++;
			}
		}
		result = new String[slova];
		int previousSpaceIdx = -1;
		int newWordIdx = 0;
		for (int i=0; i < strokaIzslov.length(); i++){
			if (strokaIzslov.charAt(i) == ' '){
				//создать новую строку:  new String(charArray)
				char[] currentWord = new char[i - previousSpaceIdx-1];
				for (int j = previousSpaceIdx+1; j < i; j++) {
					currentWord[j-previousSpaceIdx+1] 
							= strokaIzslov.charAt(j);
					System.out.println(strokaIzslov.charAt(j));
				}
				System.out.println(currentWord);
				//добавить её в результат
				result[newWordIdx] = new String(currentWord);
				newWordIdx++;
				//обновить previousSpaceIdx
				previousSpaceIdx = i;
			}
		}
		//добавить последнее слово, после котрого не было прообела.
		return result;
	}
	
	private static void print(String[] massiv){
		for(int n = 0; n < massiv.length; n++)
			System.out.print(massiv[n] + " | ");
	}

}
