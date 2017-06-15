package homework13;

import java.util.Scanner;

public class Chess {
	
	static String[][] chessBoard;
	static final String[] PIECES = {"WP", "WR", "WH", "WB","WQ", "WK",
			"BP", "BR", "BH", "BB","BQ", "BK"}; 
	
	
	public static void main(String[] args) {
		boolean exitProg = false;
		initBoard();
		printBoard();
		
		Scanner scanner = new Scanner(System.in);
		

		while (!exitProg) {
			String fromCoord, toCoord;
			System.out.println("Please enter from LETTER and NUMBER coordinates:");
			fromCoord = scanner.nextLine();
			System.out.println("Please enter to LETTER and NUMBER coordinates:");
			toCoord = scanner.nextLine();
			makeMove(fromCoord, toCoord);
			//меняет доску
			printBoard();
			//добавить выход из цикла по желанию пользователя.
			int exit;
			System.out.print("Are you ready to exit? Push - 0: ");
			exit = scanner.nextInt();
			scanner.nextLine();
			if (exit == 0) {
				exitProg = true;
			}
		}
		
	}


	private static void makeMove(String fromCoord, String toCoord) {
		int fromLetter, fromNumber, toLetter, toNumber ;
		fromLetter = (int)(fromCoord.charAt(0));
		fromNumber = (int)(fromCoord.charAt(1));
		toLetter = (int)(toCoord.charAt(0));
		toNumber = (int)(toCoord.charAt(1));
		chessBoard[toLetter - 64][toNumber - 48] = chessBoard[fromLetter - 64][fromNumber - 48];
		chessBoard[fromLetter - 64][fromNumber - 48] = null;
	}


	private static void initBoard() {
		chessBoard = new String[9][9];
		for (int i = 1; i < 9; i++) {
			chessBoard[2][i] = PIECES[0];
			chessBoard[7][i] = PIECES[6];
		}
		for (int i = 1; i < 6; i++) {
			chessBoard[1][i] = PIECES[i];
			chessBoard[8][i] = PIECES[i+6];
		}
		int type = 1;
		for(int i = 1; i < 9; i++) {
			chessBoard[0][i] = (String)(type + " ");
			type++;
		}
		char temp = 'A';
		for(int i = 1; i < 9; i++) {
			chessBoard[i][0] = (String)(temp + " ");
			temp++;
		}
		chessBoard[1][6] = PIECES[3];
		chessBoard[8][6] = PIECES[9];
		chessBoard[1][7] = PIECES[2];
		chessBoard[8][7]= PIECES[8];
		chessBoard[1][8] = PIECES[2];
		chessBoard[8][8] = PIECES[7];
	}
	
	public static void printBoard(){
		for (int i = 0; i < chessBoard.length; i++){
			for (int j = 0; j<chessBoard[i].length; j++){
				if (chessBoard[i][j] == null) {
					System.out.print("  " + " | ");
				} else {
					System.out.print(chessBoard[i][j] + " | ");
				}
			}
			System.out.println();
		}
	}
	
}