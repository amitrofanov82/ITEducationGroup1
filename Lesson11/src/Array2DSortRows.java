import javax.swing.plaf.synth.SynthSeparatorUI;

public class Array2DSortRows {
	
	
	public static void main(String[] args) {
		/*//тестирование сортировки:
		int[] arrToSort = {4, 3, 2, 1};
		sortArray(arrToSort);*/
		

		int[][] array2D;
		int rows = 3, columns = 4;
		array2D = new int[rows][columns];
		for (int i = 0; i < rows; i++){
			for (int j = 0; j<columns; j++){
				array2D[i][j] = (int) (Math.random()*201 -100);
			}
		}
		print2d(array2D);
		System.out.println();
		sort2dArrayByMaxElement(array2D);
		print2d(array2D);

	}
	
	
	public static void print2d(int[][] arrayToPrint){
		for (int i = 0; i < arrayToPrint.length; i++){
			for (int j = 0; j<arrayToPrint[i].length; j++){
				System.out.print(arrayToPrint[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	//сортировка выбором:
	public static void sortArray(int[] array){
		for (int i=0; i< array.length; i++) {
			for (int j=i; j< array.length; j++) {
				if (array[i] > array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		for (int i = 0; i< array.length; i++){
			System.out.print(array[i] + " | ");
		}
		System.out.println();
	}
	
	
	public static void sort2dArrayByMaxElement(int[][] array2d){
		for (int i=0; i< array2d.length; i++) {
			for (int j=i; j< array2d.length; j++) {
				if (maxElement(array2d, i) > maxElement(array2d, j)){
					int[] temp = array2d[i];
					array2d[i] = array2d[j];
					array2d[j] = temp;
				}
			}
		}
	}


	private static int maxElement(int[][] array2d, int i) {
		int maxElement = array2d[i][0];
		
		for (int j=0; j<array2d[i].length; j++){
			if (array2d[i][j]>maxElement){
				maxElement = array2d[i][j];
			}
		}
		return maxElement;
	}
	

}































