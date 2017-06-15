package examples;


public class StringSort {
	
	
	public static void main(String[] args) {
		String[] massiv = {"vasya", "vasaa", "bakya", "sasya"}; 
		int n = massiv.length;
		print(massiv);
		System.out.println();
		
		for (int i = 0; i<n-1; i++){
			//найти минимум, который предыдущего минимума:
			String min = massiv[i];
			int minIndex = i;
			for (int j = i; j<=n-1; j++){
				if (checkStringIsLessThanMinimum(massiv[j], min)){
					min = massiv[j];
					minIndex = j;
				}
			}
			System.out.println("Минимум = " + min);
			
			//поставить его на позицию i:
			String temp = massiv[i];
			massiv[i] = min;
			massiv[minIndex] = temp;
			print(massiv);
			System.out.println();
		}
		print(massiv);
		
	}
	
	
	private static boolean checkStringIsLessThanMinimum(String string,
																String min) {
		int minStringLength = Math.min(string.length(), min.length());
		
		for (int i = 0; i < minStringLength; i++){
			if (string.charAt(i) < min.charAt(i)) {
				return true;
			}
		}
		return false;
	}


	
	
	
	private static void print(String[] massiv){
		for(int n = 0; n < massiv.length; n++)
			System.out.print(massiv[n] + " | ");
	}
}
