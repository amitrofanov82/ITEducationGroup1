
public class Sortirovka {
	
	
	public static void main(String[] args) {
		int[] massiv = {7,9,2,3,1}; 
		int n = massiv.length;
		print(massiv);
		System.out.println();
		
		for (int i = 0; i<n-1; i++){
			//найти минимум, который предыдущего минимума:
			int min = massiv[i];
			int minIndex = i;
			for (int j = i; j<=n-1; j++){
				if (massiv[j] < min){
					min = massiv[j];
					minIndex = j;
				}
			}
			System.out.println("Минимум = " + min);
			
			//поставить его на позицию i:
			int temp = massiv[i];
			massiv[i] = min;
			massiv[minIndex] = temp;
			print(massiv);
			System.out.println();
		}
		print(massiv);
		
	}
	
	
	private static void print(int[] massiv){
		for(int n = 0; n < massiv.length; n++)
			System.out.print(massiv[n] + " | ");
	}
}
