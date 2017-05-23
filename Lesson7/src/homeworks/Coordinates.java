package homeworks;

public class Coordinates {
	
	public static void main(String[] args) {
		int x = 3, y = 4;
		System.out.println("^");
		for (int i = 10; i>0; i--){
			System.out.println("|");
			if (y == i){
				//выводим Х:
				for (int j = 0; j<x-1; j++) {
					System.out.print(" ");
				}
				System.out.println("+");
			}
		}
		System.out.println("|--------------->");
	}
	
}
