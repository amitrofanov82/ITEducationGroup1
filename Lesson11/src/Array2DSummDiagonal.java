
public class Array2DSummDiagonal {
	
	
	public static void main(String[] args) {
		int[][] array2D;
		int rows = 3, columns = 3;
		array2D = new int[rows][columns];
		int s=0;
		
		for (int i = 0; i < rows; i++){
			for (int j = 0; j<columns; j++){
				array2D[i][j] = (int) (Math.random()*201 -100);
			}
		}
		print2d(array2D);
		
		
		/*for (int i = 0; i < rows; i++){
			for (int j = 0; j<columns; j++){
				if (i == j){
					s += array2D[i][j];
				}
			}
		}*/
		
		/*главная диагональ
		 * for (int i = 0; i < rows; i++){
			s += array2D[i][i];
		}*/
		
		//побочная диагональ
		for (int i = 0; i < rows; i++){
			s += array2D[i][array2D.length - i - 1];
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

}































