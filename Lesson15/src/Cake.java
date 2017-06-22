/*Задача про буквы на торте Где мы обговорили алгоритм решения
 *Сначала всё что можем заполняем впрао-влево, потом щё раз также
 * вверх-вниз. Надо её написать.*/

public class Cake {

	public static void main(String[] args) {
		int x = 6, y = 5; // размеры торта
		int child = 5;
		char children[] = new char[child];
		char cake[][] = new char[x][y]; // торт размерами a*b
				
		for(int i = 0; i < children.length; i++) {
			children[i] = (char)('A' + i);
		}
		probel(cake);	
		location(cake, children);
		printChar(cake);
		
		//1 заполнить всё вправо-влево:
		for (int i=0; i<cake.length; i++){
			for (int j=0; j<cake[i].length; j++) {
				if (cake[i][j] != ' ') {
					//заполнить всё вправо эту букву:
					int k = 1;
					while (j+k < cake[i].length 
							&& cake[i][j+k] == ' ') {
						cake[i][j+k] = cake[i][j];
						k++;
					}
					//влево:
					k = -1;
					while (j+k >= 0 
							&& cake[i][j+k] == ' ') {
						cake[i][j+k] = cake[i][j];
						k--;
					}
				}
			}
		}
		printChar(cake);
		
		//2 заполнить всё вверх-вниз
		for (int i=0; i<cake.length; i++){
			for (int j=0; j<cake[i].length; j++) {
				if (cake[i][j] != ' '){
					//сверху вниз:
					int k = 1;
					while (i+k < cake.length 
							&& cake[i+k][j] == ' ') {
						cake[i+k][j] = cake[i][j];
						k++;
					}
					//снизу вверх:
					k = -1;
					while (i+k >=0 
							&& cake[i+k][j] == ' ') {
						cake[i+k][j] = cake[i][j];
						k--;
					}
				}
			}
		}
		
		printChar(cake);
		
		//Артема код по буквам закоментирован. 
		/*for(int i = 0; i < children.length; i++) {
			filling(cake, children[i]);
		}
		System.out.println();
		printChar(cake);
		
		for (int i = 0; i < x; i++) {
			fillingUpDown(cake);
		}
		System.out.println();
		printChar(cake);*/

	}
	
	//Инициализация массива char -ов пробелами
	public static void probel(char[][] massiv) {
		for(int i = 0; i < massiv.length; i++) {
			for(int j = 0; j < massiv[0].length; j++) {
				massiv[i][j] = ' ';
			}
		}
	}
	
	
	//Метод выводит таблицу char -ов на экран
	public static void printChar(char[][] massiv) {
		for(int i = 0; i < massiv.length; i++) {
			for(int j = 0; j < massiv[0].length; j++) {
				System.out.print("| " + massiv[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Метод раставляет ячейки из масива count в матрицу matrix случайным образом.
	public static void location(char[][] matrix, char[] count) {
		
		for(int i = 0; i < count.length; i++) {
			int s = (int)(Math.random() * matrix.length); //значение кол-ва строк в пределах матрицы
			int t = (int)(Math.random() * matrix[0].length); //значение кол-ва столбцов в пределах матрицы	
			if(matrix[s][t] == ' ') {
				matrix[s][t] = count[i];
			}
			else {
				i--;
			}
		}
		
	}
	
	//Заполняет однотипными символами максимальную область влево -вправо
	//из матрицы не заходя на символы не являющимися пробелами
	public static void filling (char[][] array, char letter) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if((array[i][j] == letter)&&((j + 1) < array[0].length)) {
					int z = (j + 1);
					while( z < array[i].length) {
						if(array[i][z] == ' ') {
							array[i][z] = letter;
							z++;
						}
						else {
							z = array[i].length;
						}
					}									
				}
				if((array[i][j] == letter)&&(j > 0)) {
					int l = (j - 1);
					while( l >= 0) {
						if(array[i][l] == ' ') {
							array[i][l] = letter;
							l--;
						}
						else {
							l = -1;
						}
					}					
				}	
			}
		}		
	}
	
	//Заполняет однотипными символами  область вниз-вверх
		//из матрицы не заходя на символы не являющимися пробелами
	public static void fillingUpDown (char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != ' ') {
					for (int k = i + 1; k < array.length; k++) {
						if (array[k][j] != ' ') {
							break;
						}							
						array[k][j] = array[i][j];
					}
				}
				if ((array[i][j] == ' ')&&((i + 1) < array.length)) {
					int n = i+1;
					for (int z = j; z < array[i].length; z++) {
						if ((array[n][z] != ' ')&&((n) < array.length)) {
							array[i][z] = array[i+1][z];
							break;
						}
					}
				}
			}
		}
	}

}