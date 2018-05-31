package mitrofanov82.edu.javagroup1.angry_chess.model.engine;

import mitrofanov82.edu.javagroup1.angry_chess.persistence.Player;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;

public class EngineTheFirstTestWithMain {

	public static void main(String[] s) throws ChessModelException {
		// 1. Input data
		long id = 1L;
		IPlayer p1 = new Player("Vasya", 1200);
		IPlayer p2 = new Player("Black Masha", 1200);
		
		// 2. Expected result
		// ожидаем, что черный игрок будет equals игроку с таким же именем и рейтингом
		// ожидаем, что Белый игрок будет как у p1
		IPlayer expBlackPlayer = new Player("Black Masha", 1200);
		String expWhitePlayName = p1.getName();
		long expectedId = id;
		FigureType expectedFigureAtA1 = FigureType.WHITE_ROOK;
		
		// 3. execute tested behaviour
		EngineTheFirst testedEngine = new EngineTheFirst();
		IGame result = testedEngine.createNewGame(id, p1, p2);
		
		// 4. reality==expectation?
		System.out.println(result.getBlackPlayer().equals(expBlackPlayer));
		
		System.out.println(result.getWhitePlayer().
				getName().equals(expWhitePlayName));
		
		System.out.println(result.getGameId() == expectedId);
		
		System.out.println(expectedFigureAtA1.equals(
					result.getCurrentPosition()[0][0]));

		
		
		
	}

}
