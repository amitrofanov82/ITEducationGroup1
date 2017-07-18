package ChessNeznaev;

public class CheckMove {

	public static boolean check() {
		for (int k = 0; k < Chess.currentUser.length; k++) {
			if (Chess.chessBoard[GetMove.move[1]][GetMove.move[0]] == Chess.currentUser[k]) {
				return figures(k);
			}
		}
		System.out.println("Another player's moves!");
		return false;
	}

	private static boolean figures(int k) {
		// нельзя бить "своих"
		if (Chess.chessBoard[GetMove.move[3]][GetMove.move[2]] != null) {
			for (int i = 0; i < Chess.currentUser.length; i++) {
				if (Chess.chessBoard[GetMove.move[3]][GetMove.move[2]] == Chess.currentUser[i]) {
					System.out.println("You can't take your own figure");
					return false;
				}
			}
		}

		if (isOpenToShah()) {
			return false;
		}

		switch (k) {
		case 0: {
			return FigurePossibilities.pawn();
		}
		case 1: {
			return FigurePossibilities.rook();
		}
		case 2: {
			return FigurePossibilities.horse();
		}
		case 3: {
			return FigurePossibilities.bishop();
		}
		case 4: {
			return FigurePossibilities.queen();
		}
		case 5: {
			return FigurePossibilities.king();
		}
		}
		return true;
	}

	// проверка не открывается ли король для шаха
	private static boolean isOpenToShah() {
		String[] color2;
		if (Chess.currentUser == Chess.PIECESWHITE) {
			color2 = Chess.PIECESBLACK;

		} else {
			color2 = Chess.PIECESWHITE;
		}
		// найти своего короля
		int digit, letter = 0;
		loop: for (digit = 0; digit < 8; digit++) {
			for (letter = 0; letter < 8; letter++) {
				if (Chess.chessBoard[digit][letter] == Chess.currentUser[5]) {
					break loop;
				}
			}
		}
		boolean shah = false;
		// проверка не открывается ли король для офицера или ферзя
		if (Math.abs(letter - GetMove.move[0]) == Math.abs(digit - GetMove.move[1])) {
			// движение в сторону увеличения букв
			if (letter < GetMove.move[0]) {
				// движение в сторону увеличения индекса цифр (уменьшается цифра
				// на доске)
				if (digit < GetMove.move[1]) {
					for (int i = GetMove.move[0] + 1, j = GetMove.move[1] + 1; i < 8; i++, j++) {
						if (Chess.chessBoard[j][i] != null) {
							if (Chess.chessBoard[j][i] == color2[3] || Chess.chessBoard[j][i] == color2[4]
									|| Chess.chessBoard[j][i] == color2[6]) {
								shah = true;
								break;
							} else {
								break;
							}
						}
					}
				}
				// движение в сторону уменьшения индекса цифр
				else {
					for (int i = GetMove.move[0] - 1, j = GetMove.move[1] + 1; i >= 0; i--, j++) {
						if (Chess.chessBoard[j][i] != null) {
							if (Chess.chessBoard[j][i] == color2[3] || Chess.chessBoard[j][i] == color2[4]
									|| Chess.chessBoard[j][i] == color2[6]) {
								shah = true;
								break;
							} else {
								break;
							}
						}
					}
				}
			}
			// движение в сторону уменьшения букв
			else {
				// движение в сторону уменьшения цифр
				if (digit > GetMove.move[1]) {
					for (int i = GetMove.move[0] - 1, j = GetMove.move[1] - 1; i >= 0; i--, j--) {
						if (Chess.chessBoard[j][i] != null) {
							if (Chess.chessBoard[j][i] == color2[3] || Chess.chessBoard[j][i] == color2[4]
									|| Chess.chessBoard[j][i] == color2[6]) {
								shah = true;
								break;
							} else {
								break;
							}
						}
					}
				}
				// движение в сторону увеличения цифр
				else {
					for (int i = GetMove.move[0] + 1, j = GetMove.move[1] - 1; i < 8; i++, j--) {
						if (Chess.chessBoard[j][i] != null) {
							if (Chess.chessBoard[j][i] == color2[3] || Chess.chessBoard[j][i] == color2[4]
									|| Chess.chessBoard[j][i] == color2[6]) {
								shah = true;
								break;
							} else {
								break;
							}
						}
					}
				}
			}
		}
		// проверка не открывается ли король для ладьи
		else if (GetMove.move[0] == letter && GetMove.move[1] < digit) {
			for (int i = GetMove.move[1] - 1; i >= 0; i--) {
				if (Chess.chessBoard[i][GetMove.move[0]] != null) {
					if (Chess.chessBoard[i][GetMove.move[0]] == color2[1]
							|| Chess.chessBoard[i][GetMove.move[0]] == color2[4]
							|| Chess.chessBoard[i][GetMove.move[0]] == color2[8]) {
						shah = true;
						break;
					} else {
						break;
					}
				}
			}
		} else if (GetMove.move[0] == letter && GetMove.move[1] > digit) {
			for (int i = GetMove.move[1] + 1; i < 8; i++) {
				if (Chess.chessBoard[i][GetMove.move[0]] != null) {
					if (Chess.chessBoard[i][GetMove.move[0]] == color2[1]
							|| Chess.chessBoard[i][GetMove.move[0]] == color2[4]
							|| Chess.chessBoard[i][GetMove.move[0]] == color2[8]) {
						shah = true;
						break;
					} else {
						break;
					}
				}
			}
		} else if (GetMove.move[0] < letter && GetMove.move[1] == digit) {
			for (int j = GetMove.move[0] - 1; j >= 0; j--) {
				if (Chess.chessBoard[GetMove.move[1]][j] != null) {
					if (Chess.chessBoard[GetMove.move[1]][j] == color2[1]
							|| Chess.chessBoard[GetMove.move[1]][j] == color2[4]
							|| Chess.chessBoard[GetMove.move[1]][j] == color2[8]) {
						shah = true;
						break;
					} else {
						break;
					}
				}
			}
		} else if (GetMove.move[0] > letter && GetMove.move[1] == digit) {
			for (int j = GetMove.move[0] + 1; j < 8; j++) {
				if (Chess.chessBoard[GetMove.move[1]][j] != null) {
					if (Chess.chessBoard[GetMove.move[1]][j] == color2[1]
							|| Chess.chessBoard[GetMove.move[1]][j] == color2[4]
							|| Chess.chessBoard[GetMove.move[1]][j] == color2[8]) {
						shah = true;
						break;
					} else {
						break;
					}
				}
			}
		}

		if (shah) {
			System.out.println("Illegal move. The king is put under attack");
			return true;
		}
		return false;
	}
}