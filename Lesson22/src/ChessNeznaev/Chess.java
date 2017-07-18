package ChessNeznaev;

public class Chess {
	public static String[][] chessBoard;
	static final String[] PIECESWHITE = { "WP", "WR", "WH", "WB", "WQ", "WK", "WB", "WH", "WR" };
	static final String[] PIECESBLACK = { "BP", "BR", "BH", "BB", "BQ", "BK", "BB", "BH", "BR" };
	static String[] currentUser;
	static String[] opposer;
	public static boolean shah;

	// "\u2659", "\u2656", "\u2658", "\u2657", "\u2655", "\u2654", "\u2657",
	// "\u2658", "\u2656", "\u265f", "\u265c", "\u265d", "\u265e", "\u265b",
	// "\u265a", "\u265e", "\u265d", "\u265c" };
	public static void main(String[] args) {
		initBoard();
		PrintBoard.print2d();
		while (true) {
			do {
				System.out.print("White's move: ");
				GetMove.get();
				currentUser = PIECESWHITE;
				opposer = PIECESBLACK;
			} while (!CheckMove.check());
			makeMove();
			PrintBoard.print2d();

			do {
				System.out.printf("Black's move: ");
				GetMove.get();
				currentUser = PIECESBLACK;
				opposer = PIECESWHITE;
			} while (!CheckMove.check());
			makeMove();
			PrintBoard.print2d();
		}
	}

	private static void makeMove() {
		chessBoard[GetMove.move[3]][GetMove.move[2]] = chessBoard[GetMove.move[1]][GetMove.move[0]];

		if (chessBoard[GetMove.move[1]][GetMove.move[0]] == PIECESWHITE[0] && GetMove.move[3] == 0) {
			chessBoard[GetMove.move[3]][GetMove.move[2]] = PIECESWHITE[4];
		}
		if (chessBoard[GetMove.move[1]][GetMove.move[0]] == PIECESBLACK[0] && GetMove.move[3] == 7) {
			chessBoard[GetMove.move[3]][GetMove.move[2]] = PIECESBLACK[4];
		}

		chessBoard[GetMove.move[1]][GetMove.move[0]] = null;

		win();
		isShah();
	}

	private static void isShah() {
		// найти своего короля
		int digit, letter = 0;
		loop: for (digit = 0; digit < 8; digit++) {
			for (letter = 0; letter < 8; letter++) {
				if (Chess.chessBoard[digit][letter] == opposer[5]) {
					break loop;
				}
			}
		}
		GetMove.move[1] = GetMove.move[3];
		GetMove.move[0] = GetMove.move[2];
		GetMove.move[3] = digit;
		GetMove.move[2] = letter;
		if (CheckMove.check()) {
			System.out.println("We have the shah!");
			shah = true;
		}

		// chessBoard[GetMove.move[1]][GetMove.move[0]] = null;
	}

	private static void initBoard() {
		chessBoard = new String[8][8];
		for (int i = 0; i < 8; i++) {
			chessBoard[0][i] = PIECESBLACK[i + 1];
			chessBoard[1][i] = PIECESBLACK[0];
			chessBoard[6][i] = PIECESWHITE[0];
			chessBoard[7][i] = PIECESWHITE[i + 1];
		}
	}

	private static void win() {
		boolean win = true;
		one: for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (PIECESBLACK[5].equals(chessBoard[i][j])) {
					win = false;
					break one;
				}
			}
		}
		if (win) {
			System.out.println("White won!");
			System.exit(0);
		}
		win = true;
		two: for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (PIECESWHITE[5].equals(chessBoard[i][j])) {
					win = false;
					break two;
				}
			}
		}
		if (win) {
			System.out.println("Black won!");
			System.exit(0);
		}
	}
}