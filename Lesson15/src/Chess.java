

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
			String move;
			System.out.println("Please enter move, or '0' to exit");
			move = scanner.nextLine();
			if (move.charAt(0) == '0') {
				System.out.println("Bye-bye");
				System.exit(0);
			}
			if (makeMove(move)){
				printBoard();
			}
		}
		
	}


	private static boolean makeMove(String move) { //ожидаем е2-е4
		if (validateMoveFormat(move) == false) {
			System.out.println("плохой ход");
			return false;
		}
		int fromRow, fromColumn, toRow, toColumn;
		fromRow = move.charAt(0) - 'a' +1;
		toRow = move.charAt(3) - 'a' +1;
		fromColumn = move.charAt(1) - '1' +1;
		toColumn = move.charAt(4) - '1' +1;
		chessBoard[toRow][toColumn] = chessBoard[fromRow][fromColumn];
		chessBoard[fromRow][fromColumn] = null;
		return true;
	}


	private static boolean validateMoveFormat(String move) {
		if (move.length() !=5) {
			return false;
		}
		if (move.charAt(0) < 'a' || move.charAt(0) > 'h'
		 || move.charAt(3) < 'a' || move.charAt(3) > 'h') {
			return false;
		}
		if (move.charAt(1) < '1' || move.charAt(1) > '8'
		 || move.charAt(4) < '1' || move.charAt(4) > '8') {
			return false;
		}
		return true;
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
		char type = 'A';
		for(int i = 1; i < 9; i++) {
			chessBoard[0][i] = (String)(type + " ");
			type++;
		}
		int temp = 1;
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