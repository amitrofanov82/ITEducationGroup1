package ChessNeznaev;

public class FigurePossibilities {
    public static boolean pawn() {
	int start, choose;
	if (Chess.currentUser == Chess.PIECESWHITE) {
	    start = 6;
	    choose = -1;
	} else {
	    start = 1;
	    choose = 1;
	}
	// если пешка в стартовой позиции - может сделать один шаг вперёд или
	// два
	if (GetMove.move[1] == start && GetMove.move[2] == GetMove.move[0]
		&& ((GetMove.move[3] == GetMove.move[1] + choose * 2
			&& Chess.chessBoard[GetMove.move[3]][GetMove.move[2]] == null
			&& Chess.chessBoard[GetMove.move[1] + choose][GetMove.move[2]] == null)
			|| GetMove.move[3] == GetMove.move[1] + choose
				&& Chess.chessBoard[GetMove.move[3]][GetMove.move[2]] == null)) {
	    return true;
	}
	// если пешка никого не бьёт, единственный возможный ход - один шаг
	// вперёд
	else if (GetMove.move[2] == GetMove.move[0] && GetMove.move[3] == GetMove.move[1] + choose
		&& Chess.chessBoard[GetMove.move[3]][GetMove.move[2]] == null) {
	    return true;
	}
	// если есть кого побить
	else if (GetMove.move[3] == GetMove.move[1] + choose
		&& (GetMove.move[2] == GetMove.move[0] + 1 || GetMove.move[2] == GetMove.move[0] - 1)
		&& Chess.chessBoard[GetMove.move[3]][GetMove.move[2]] != null) {
	    return true;
	}
	System.out.println("Wrong move");
	return false;
    }

    public static boolean rook() {
	// не натыкается ли ладья на "препятствия" на своём пути
	if (GetMove.move[0] == GetMove.move[2] && GetMove.move[1] < GetMove.move[3]) {
	    for (int i = GetMove.move[1] + 1; i < GetMove.move[3]; i++) {
		if (Chess.chessBoard[i][GetMove.move[0]] != null) {
		    System.out.println("You can not jump over");
		    return false;
		}
	    }
	} else if (GetMove.move[0] == GetMove.move[2] && GetMove.move[1] > GetMove.move[3]) {
	    for (int i = GetMove.move[1] - 1; i > GetMove.move[3]; i--) {
		if (Chess.chessBoard[i][GetMove.move[0]] != null) {
		    System.out.println("You can not jump over");
		    return false;
		}
	    }
	} else if (GetMove.move[0] < GetMove.move[2] && GetMove.move[1] == GetMove.move[3]) {
	    for (int i = GetMove.move[0] + 1; i < GetMove.move[2]; i++) {
		if (Chess.chessBoard[GetMove.move[1]][i] != null) {
		    System.out.println("You can not jump over");
		    return false;
		}
	    }
	} else if (GetMove.move[0] > GetMove.move[2] && GetMove.move[1] == GetMove.move[3]) {
	    for (int i = GetMove.move[0] - 1; i > GetMove.move[2]; i--) {
		if (Chess.chessBoard[GetMove.move[1]][i] != null) {
		    System.out.println("You can not jump over");
		    return false;
		}
	    }
	}

	// если ладья "пытается" ходить не по прямой
	if (GetMove.move[0] != GetMove.move[2] && GetMove.move[1] != GetMove.move[3]) {
	    System.out.println("Wrong move");
	    return false;
	}
	return true;
    }

    public static boolean horse() {
	if ((GetMove.move[0] == GetMove.move[2] + 1 || GetMove.move[0] == GetMove.move[2] - 1)
		&& (GetMove.move[1] == GetMove.move[3] - 2 || GetMove.move[1] == GetMove.move[3] + 2)) {
	    return true;
	} else if ((GetMove.move[0] == GetMove.move[2] + 2 || GetMove.move[0] == GetMove.move[2] - 2)
		&& (GetMove.move[1] == GetMove.move[3] - 1 || GetMove.move[1] == GetMove.move[3] + 1)) {
	    return true;
	}
	System.out.println("Wrong move");
	return false;
    }

    public static boolean bishop() {
	// System.out.println(move[0] + " " + move[2] + "/" + move[1] + " " +
	// move[3]);
	if (Math.abs(GetMove.move[2] - GetMove.move[0]) == Math.abs(GetMove.move[3] - GetMove.move[1])) {
	    int dirLet, dirNum;
	    // движение в сторону увеличения букв
	    if (GetMove.move[0] < GetMove.move[2]) {
		dirLet = 1;
	    }
	    // движение в сторону уменьшения букв
	    else {
		dirLet = -1;
	    }
	    // движение в сторону уменьшения цифр
	    if (GetMove.move[1] < GetMove.move[3]) {
		dirNum = 1;
	    }
	    // движение в сторону увеличения цифр
	    else {
		dirNum = -1;
	    }

	    for (int i = 1; GetMove.move[1] + i * dirNum != GetMove.move[3]; i++) {
		if (Chess.chessBoard[GetMove.move[1] + i * dirNum][GetMove.move[0] + i * dirLet] != null) {
		    System.out.println("You can not jump over");
		    return false;
		}
	    }
	    return true;
	}
	System.out.println("Wrong move");
	return false;
    }

    public static boolean queen() {
	// ферзь пытается идти по прямой
	if (Math.abs(GetMove.move[2] - GetMove.move[0]) == Math.abs(GetMove.move[3] - GetMove.move[1])) {
	    int dirLet, dirNum;
	    // движение в сторону увеличения букв
	    if (GetMove.move[0] < GetMove.move[2]) {
		dirLet = 1;
	    }
	    // движение в сторону уменьшения букв
	    else {
		dirLet = -1;
	    }
	    // движение в сторону уменьшения цифр
	    if (GetMove.move[1] < GetMove.move[3]) {
		dirNum = 1;
	    }
	    // движение в сторону увеличения цифр
	    else {
		dirNum = -1;
	    }

	    for (int i = 1; GetMove.move[1] + i * dirNum != GetMove.move[3]; i++) {
		if (Chess.chessBoard[GetMove.move[1] + i * dirNum][GetMove.move[0] + i * dirLet] != null) {
		    System.out.println("You can not jump over");
		    return false;
		}
	    }
	    return true;
	}
	// ферзь пытается идти по диагонали
	else {
	    if (GetMove.move[0] == GetMove.move[2] && GetMove.move[1] < GetMove.move[3]) {
		for (int i = GetMove.move[1] + 1; i < GetMove.move[3]; i++) {
		    if (Chess.chessBoard[i][GetMove.move[0]] != null) {
			System.out.println("You can not jump over");
			return false;
		    }
		}
		return true;
	    } else if (GetMove.move[0] == GetMove.move[2] && GetMove.move[1] > GetMove.move[3]) {
		for (int i = GetMove.move[1] - 1; i > GetMove.move[3]; i--) {
		    if (Chess.chessBoard[i][GetMove.move[0]] != null) {
			System.out.println("You can not jump over");
			return false;
		    }
		}
		return true;
	    } else if (GetMove.move[0] < GetMove.move[2] && GetMove.move[1] == GetMove.move[3]) {
		for (int i = GetMove.move[0] + 1; i < GetMove.move[2]; i++) {
		    if (Chess.chessBoard[GetMove.move[1]][i] != null) {
			System.out.println("You can not jump over");
			return false;
		    }
		}
		return true;
	    } else if (GetMove.move[0] > GetMove.move[2] && GetMove.move[1] == GetMove.move[3]) {
		for (int i = GetMove.move[0] - 1; i > GetMove.move[2]; i--) {
		    if (Chess.chessBoard[GetMove.move[1]][i] != null) {
			System.out.println("You can not jump over");
			return false;
		    }
		}
		return true;
	    }
	}
	System.out.println("Wrong move");
	return false;
    }

    public static boolean king() {
	if (!((GetMove.move[2] == GetMove.move[0] + 1 || GetMove.move[2] == GetMove.move[0] - 1
		|| GetMove.move[2] == GetMove.move[0])
		&& (GetMove.move[3] == GetMove.move[1] + 1 || GetMove.move[3] == GetMove.move[1] - 1
			|| GetMove.move[3] == GetMove.move[1]))) {
	    System.out.println("Wrong move");
	    return false;
	}

	return true;
    }
}