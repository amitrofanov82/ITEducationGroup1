package ChessNeznaev;

public class PrintBoard {
    public static void print2d() {
	Letter();
	for (int i = 0; i < 8; i++) {
	    System.out.printf("\n\t    ");
	    Cell(i);
	    System.out.printf("\n\t%d   ", 8 - i); // цифры слева
	    CellFig(i);
	    System.out.printf("   %d\n\t    ", 8 - i); // цифры справа
	    Cell(i);
	}
	Letter();
    }

    private static void Letter() {
	System.out.printf("\n\n");
	System.out.printf("\t\t");
	for (int i = 'A'; i <= 'H'; i++) {
	    System.out.printf("%c\t", i);
	}
	System.out.println();
    }

    private static void CellFig(int i) {
	for (int j = 0; j < 8; j++) {
	    if ((i + j) % 2 != 0) {
		if (Chess.chessBoard[i][j] == null) {
		    System.out.print("||||||||");
		} else {
		    System.out.print("|| " + Chess.chessBoard[i][j] + " ||");
		}
	    } else {
		if (Chess.chessBoard[i][j] == null) {
		    System.out.print("        ");
		} else {
		    System.out.print("   " + Chess.chessBoard[i][j] + "   ");
		}
	    }
	}

    }

    private static void Cell(int black) {
	if (black % 2 == 1) {
	    for (int k = 0; k < 4; k++) {
		System.out.print("||||||||        ");
	    }
	} else {
	    for (int k = 0; k < 4; k++) {
		System.out.print("        ||||||||");
	    }
	}
    }
}