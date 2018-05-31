package mitrofanov82.edu.javagroup1.angry_chess.model.engine;

import org.junit.Assert;
import org.junit.Test;

import mitrofanov82.edu.javagroup1.angry_chess.persistence.Player;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;

public class EngineTheFirstTest {

	@Test
	public void testPlayersAreTheSame() throws ChessModelException {
		// when
		long id = 1L;
		IPlayer p1 = new Player("Vasya", 1200);
		IPlayer p2 = new Player("Black Masha", 1200);
		
		//expect
		IPlayer expBlackPlayer = new Player("Black Masha", 1200);
		String expWhitePlayName = p1.getName();
		
		//execute
		EngineTheFirst testedEngine = new EngineTheFirst();
		IGame result = testedEngine.createNewGame(id, p1, p2);
		
		//check
		Assert.assertEquals(expBlackPlayer, result.getBlackPlayer());
		Assert.assertEquals(expWhitePlayName, result.getPlayerToMove().getName());
	}
	
	@Test
	public void testFiguresAreAtStartingPositions() {
		//то же самое по сути, только тест другой
	}
	
	@Test
	public void testExceptionIfSecondGameSameId() {
		
	}
	

}
