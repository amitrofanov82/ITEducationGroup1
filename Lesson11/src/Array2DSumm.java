
public class Array2DSumm {
	
	
	public static void main(String[] args) {
		int[][] array2D;
		int rows = 5, columns = 3;
		array2D = new int[rows][columns];
		int s=0;
		
		for (int i = 0; i < rows; i++){
			for (int j = 0; j<columns; j++){
				array2D[i][j] = (int) (Math.random()*201 -100);
			}
		}
		print2dv2(array2D);
		for (int i = 0; i < rows; i++){
			for (int j = 0; j<columns; j++){
				s += array2D[i][j];
			}
		}
		System.out.println(s);
		
	}
	
	
	public static void print2d(int[][] arrayToPrint){
		for (int i = 0; i < arrayToPrint.length; i++){
			for (int j = 0; j<arrayToPrint[i].length; j++){
				System.out.print(arrayToPrint[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	//исправить дома
	public static void print2dv2(int[][] arrayToPrint){
		for (int j = 0; j<arrayToPrint.length; j++){
			for (int i = 0; i<arrayToPrint[j].length; i++){
				System.out.print(arrayToPrint[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
	

}
