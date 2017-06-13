package homework12;
/*/  Переворачивание блинов счастливой стороной вверх!  ///
//////////  Autor: Artsem Grudinskiy  /////////////////////
/////////  E-mail:finemirel@gmail.com  ////////////////////
/////  Number telephone: +375 29 741 45 92;  /////////////
/////////////////////////////////////////////////////////*/


public class Bliny {

	public static void main(String[] args) {
		
		int l = 20;

		char[] strokaChar = new char[l];
		System.out.print("Stek: \t");
		for (int i = 0; i < strokaChar.length; i++ ) {	
			if(Math.random() > 0.5) {
				strokaChar[i] = '+'; // Счастливая сторона
			}
			else {
				strokaChar[i] = '-'; // Несчастливая сторона
			}
			System.out.print(strokaChar[i] + " ");
		}
		System.out.println();
		int counter = 1;
		for(int i = 0; i < strokaChar.length - 1; i++) {
			if(strokaChar[i] != strokaChar[i + 1]) {
				for(int j = 0; j < i + 1; j++) {
					strokaChar[j] = strokaChar[i + 1];
				}
				System.out.print(counter + " :\t");
				print1(strokaChar);
				counter++;
			}			
		}
		
		if(strokaChar[0] == '-') {
			System.out.print(counter + " :\t");
			for (int i = 0; i < strokaChar.length; i++ ) {
				strokaChar[i] = '+';
			}
			print1(strokaChar);
		}
		
		
	}
	
	public static void print1(char[] array) {
		for (int i = 0; i < array.length; i++ ) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	
}