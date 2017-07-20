package ChessNew.conretepieces;

import ChessNew.Board;
import ChessNew.Piece;

public class Horse extends Piece{

	Horse(boolean color){
		super("HORSE", color);
	}
	
	public boolean checkMove(int startX, int intintstartY, 
			int finishX, int finihY, Board board) {
		return true;
	}

}
