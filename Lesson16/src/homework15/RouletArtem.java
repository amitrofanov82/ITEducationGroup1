package homework15;



public class RouletArtem {

	public static void main(String[] args)
			throws java.io.IOException {		
		int money = 100;
		char ignore;
		int bet;
		int table[][] = new int[5][];
		table[0] = new int[13];
		table[1] = new int[14];
		table[2] = new int[13];
		table[3] = new int[3];
		table[4] = new int[6];
		betTable(table);		
		System.out.println("You money : " + money + " $");
		int[][] wheel = new int[2][37];
		rouletteWheel(wheel);
		printRoulette(wheel);
		sdvig(wheel);
		System.out.println();
		printBetTable(table);
		clearConsole();
		System.out.println("Making bets, gentlemen!!!");
		bet = (int)System.in.read();
		do {
			ignore = (char) System.in.read();
		}
		while (ignore != '\n');
		System.out.println(bet - 48);
		sdvig(wheel);
		printRoulette(wheel);
	}
	
	public static void betTable (int[][] array) {
		int temp = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = temp;
				temp++;
			}
		} 
	}
	
	public static void printBetTable (int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1) {
					System.out.printf("%7s","|3\u2083");
				}
				if (array[i][j] == 2) {
					System.out.printf("%4s","|6\u2086");
				}
				if (array[i][j] == 3) {
					System.out.printf("%4s","|9\u2089");
				}
				if (array[i][j] == 4) {
					System.out.printf("%5s","|12\u2081\u2082");
				}
				if (array[i][j] == 5) {
					System.out.printf("%5s","|15\u2081\u2085");
				}
				if (array[i][j] == 6) {
					System.out.printf("%5s","|18\u2081\u2088");
				}
				if (array[i][j] == 7) {
					System.out.printf("%5s","|21\u2082\u2081");
				}
				if (array[i][j] == 8) {
					System.out.printf("%5s","|24\u2082\u2084");
				}
				if (array[i][j] == 9) {
					System.out.printf("%5s","|27\u2082\u2087");
				}
				if (array[i][j] == 10) {
					System.out.printf("%5s","|30\u2083\u2080");
				}
				if (array[i][j] == 11) {
					System.out.printf("%5s","|33\u2083\u2083");
				}
				if (array[i][j] == 12) {
					System.out.printf("%5s","|36\u2083\u2086");
				}
				if (array[i][j] == 13) {
					System.out.printf("%6s","|2к1\u2083\u2087");
				}
				if (array[i][j] == 14) {
					System.out.printf("%3s","0\u2080");
				}
				if (array[i][j] == 15) {
					System.out.printf("%4s","|2\u2082");
				}
				if (array[i][j] == 16) {
					System.out.printf("%4s","|5\u2085");
				}
				if (array[i][j] == 17) {
					System.out.printf("%4s","|8\u2088");
				}
				if (array[i][j] == 18) {
					System.out.printf("%5s","|11\u2081\u2081");
				}
				if (array[i][j] == 19) {
					System.out.printf("%5s","|14\u2081\u2084");
				}
				if (array[i][j] == 20) {
					System.out.printf("%5s","|17\u2081\u2087");
				}
				if (array[i][j] == 21) {
					System.out.printf("%5s","|20\u2082\u2080");
				}
				if (array[i][j] == 22) {
					System.out.printf("%5s","|23\u2082\u2083");
				}
				if (array[i][j] == 23) {
					System.out.printf("%5s","|26\u2082\u2086");
				}
				if (array[i][j] == 24) {
					System.out.printf("%5s","|29\u2082\u2089");
				}
				if (array[i][j] == 25) {
					System.out.printf("%5s","|32\u2083\u2082");
				}
				if (array[i][j] == 26) {
					System.out.printf("%5s","|35\u2083\u2085");
				}
				if (array[i][j] == 27) {
					System.out.printf("%6s","|2к1\u2083\u2088");
				}
				if (array[i][j] == 28) {
					System.out.printf("%7s","|1\u2081");
				}
				if (array[i][j] == 29) {
					System.out.printf("%4s","|4\u2084");
				}
				if (array[i][j] == 30) {
					System.out.printf("%4s","|7\u2087");
				}
				if (array[i][j] == 31) {
					System.out.printf("%5s","|10\u2081\u2080");
				}
				if (array[i][j] == 32) {
					System.out.printf("%5s","|13\u2081\u2083");
				}
				if (array[i][j] == 33) {
					System.out.printf("%5s","|16\u2081\u2086");
				}
				if (array[i][j] == 34) {
					System.out.printf("%5s","|19\u2081\u2089");
				}
				if (array[i][j] == 35) {
					System.out.printf("%5s","|22\u2082\u2082");
				}
				if (array[i][j] == 36) {
					System.out.printf("%5s","|25\u2082\u2085");
				}
				if (array[i][j] == 37) {
					System.out.printf("%5s","|28\u2082\u2088");
				}
				if (array[i][j] == 38) {
					System.out.printf("%5s","|31\u2083\u2081");
				}
				if (array[i][j] == 39) {
					System.out.printf("%5s","|34\u2083\u2084");
				}
				if (array[i][j] == 40) {
					System.out.printf("%6s","|2к1\u2083\u2089");
				}
				if (array[i][j] == 41) {
					System.out.printf("%18s","|   первая12\u2084\u2080");
				}
				if (array[i][j] == 42) {
					System.out.printf("%18s","|    вторая12\u2084\u2081 ");
				}
				if (array[i][j] == 43) {
					System.out.printf("%25s","|    третья12\u2084\u2082     |");
				}
				if (array[i][j] == 44) {
					System.out.printf("%12s","|1до18\u2084\u2083");
				}
				if (array[i][j] == 45) {
					System.out.printf("%8s","| чет\u2084\u2084 ");
				}
				if (array[i][j] == 46) {
					System.out.printf("%8s","|черные\u2084\u2085 ");
				}
				if (array[i][j] == 47) {
					System.out.printf("%8s","|красные\u2084\u2086");
				}
				if (array[i][j] == 48) {
					System.out.printf("%10s","| нечет\u2084\u2087 ");
				}
				if (array[i][j] == 49) {
					System.out.printf("%11s","|19до36\u2084\u2088 |");
				}				
			}
			System.out.println();
			System.out.println("------------------------------------------------------------------");
		}
		System.out.println();
	}
	
	public static void rouletteWheel (int[][] array) {
		int number[] = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6,
				27, 13, 36, 11, 30,8, 23, 10, 5, 24, 16, 33, 1,
				20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
		for (int i = 0; i < array[0].length; i++) {
			array[0][i] = number[i];
		}
		array[1][0] = 2;
		for (int i = 1; i < array[1].length; i++) {			
			array[1][i] = i % 2;			
		}		
	}
	
	public static void printRoulette (int[][] array) {
		for (int i = 0; i < array[0].length; i++) {
			System.out.printf("%3d", array[0][i]);
		}
		System.out.println();
		for (int i = 0; i < array[1].length; i++) {
			if(array[1][i] == 2) {
				System.out.printf("%3s", "G");
			}
			if(array[1][i] == 1) {
				System.out.printf("%3s", "R");
			}
			if(array[1][i] == 0) {
				System.out.printf("%3s", "B");
			}			
		}
		System.out.println();
		System.out.printf("%8s", "\u06E9");
		System.out.println();
	}
	
	public static void sdvig (int[][] array) {
		int k = (int)(Math.random()*100);		
		while(k > 0) {			
			int temp = array[0][0];
			for(int i = 0; i < ((array[0].length)-1); i++) {
				array[0][i] = array[0][i+1];			
			}		
			array[0][array[0].length-1] = temp;			
			int data = array[1][0];
			for(int i = 0; i < ((array[1].length)-1); i++) {
				array[1][i] = array[1][i+1];			
			}		
			array[1][array[1].length-1] = data;			
			k--;
		}
	}
	
	public final static void clearConsole() {
	    try {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows")) {
	            Runtime.getRuntime().exec("cls");
	        }
	        else {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e) {
	        //  Handle any exceptions.
	    }
	}
}