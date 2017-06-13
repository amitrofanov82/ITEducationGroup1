package examples;

import java.util.Scanner;

public class Chess1 {
	
	static String[][] chessBoard;
	static final String[] PIECES = {"WP", "WR", "WH", "WB","WQ", "WK",
			"BP", "BR", "BH", "BB","BQ", "BK"}; 
	
	
	public static void main(String[] args) {
		initBoard();
		printBoard();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			int fromCoord, toCoord;
			System.out.println("Please enter FROM coordinates:");
			fromCoord = scanner.nextInt();
			System.out.println("Please enter TO coordinates:");
			toCoord = scanner.nextInt();
			makeMove(fromCoord, toCoord);
			//меняет доску
			printBoard();
			//добавить выход из цикла по желанию пользователя.
		}
		
	}


	private static void makeMove(int fromCoord, int toCoord) {
		//из фромКоорд достать 2 координаты
		//из туКоорд достать 2 координаты
		//в массиве chessBoard переставить нужный стринг в нужное место
		//на месте где была строка-фигура поставить chessBoard[i][j]=null
	}


	private static void initBoard() {
		chessBoard = new String[8][8];
		for (int i = 0; i < 8; i++) {
			chessBoard[1][i] = PIECES[0];
			chessBoard[6][i] = PIECES[6];
		}
		for (int i = 0; i < 5; i++) {
			chessBoard[0][i] = PIECES[i+1];
			chessBoard[7][i] = PIECES[i+7];
		}
		chessBoard[0][5] = PIECES[3];
		chessBoard[7][5] = PIECES[9];
		chessBoard[0][6] = PIECES[2];
		chessBoard[7][6] = PIECES[8];
		chessBoard[0][7] = PIECES[2];
		chessBoard[7][7] = PIECES[7];
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





