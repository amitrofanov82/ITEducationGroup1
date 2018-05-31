package mitrofanov82.edu.javagroup1.angry_chess.model.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits.GameData;
import mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits.ManagerFiguresUtility;
import mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits.RulesModeratorUtility;
import mitrofanov82.edu.javagroup1.angry_chess.model.exceptions.ChessModelRuntimeException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

//Class done and ready to use.

/**
 * Class implement model Angry Chess <br>
 * Name engine: "The First" <br>
 * Version engine: 0.1.1 <br>
 * 
 * @author Ilya Zhukov
 */
public class EngineTheFirst {

    private HashMap<Long, GameData> launchedGames;

    public EngineTheFirst() {
        this.launchedGames = new HashMap<>();
    }

    public IGame createNewGame(long gameId, IPlayer whitePlayer, IPlayer blackPlayer) throws ChessModelException {
        // Check if there is such a game
        if (launchedGames.containsKey(gameId)) {
            throw new ChessModelException("This ID( " + gameId + " ) is already taken");
        }

        GameData newGame = new GameData(gameId, whitePlayer, blackPlayer);
        launchedGames.put(gameId, newGame);
        return newGame;
    }

    public IGame makeMove(IGame game, Coord from, Coord to) throws IncorrectMoveException {
        // Check if there is such a game
        if (!launchedGames.containsKey(game.getGameId())) {
            throw new ChessModelRuntimeException("This game (id:" + game.getGameId() + ") does not exist");
        }

        GameData currentGame = launchedGames.get(game.getGameId());

        if (RulesModeratorUtility.checkMove(currentGame, from, to)) {
            currentGame = ManagerFiguresUtility.makeMove(currentGame, from, to);
            return currentGame;
        } else {
            throw new IncorrectMoveException("Incorrectly move");
        }
    }

    public IGame endGame(IGame game, GameStatusType status) {
        // Check if there is such a game
        if (!launchedGames.containsKey(game.getGameId())) {
            throw new ChessModelRuntimeException("This game (id:" + game.getGameId() + ") does not exist");
        }

        GameData currentGame = launchedGames.get(game.getGameId());

        currentGame.setGameStatus(status);
        currentGame.addRecordToHistoryLog(messageSetStatus(status));
        launchedGames.remove(currentGame.getGameId());
        return currentGame;
    }

    public GameStatusType getGameStatus(long gameId) {
        if (launchedGames.containsKey(gameId)) {
            return launchedGames.get(gameId).getGameStatus();
        } else {
            throw new ChessModelRuntimeException("This game (id:" + gameId + ") does not exist");
        }
    }

    public IGame getGameById(long gameId) {
        if (launchedGames.containsKey(gameId)) {
            return launchedGames.get(gameId);
        } else {
            throw new ChessModelRuntimeException("This game (id:" + gameId + ") does not exist");
        }
    }

    public List<IGame> getCurrentGames() {
        if (!launchedGames.isEmpty()) {
            List<IGame> listGames = new ArrayList<>();
            Set<Long> keySet = launchedGames.keySet();
            for (Long key : keySet) {
                listGames.add(launchedGames.get(key));
            }
            return listGames;
        } else {
            throw new ChessModelRuntimeException("The model does not contain running games");
        }
    }

    private String messageSetStatus(GameStatusType status) {
        if (status == GameStatusType.BLACK_WIN) {
            return "Status of game to changing on \"Black defeated\"";
        }
        if (status == GameStatusType.WHITE_WIN) {
            return "Status of game to changing on \"White defeated\"";
        }
        if (status == GameStatusType.END_GAME_NO_RESULT) {
            return "Status of game to changing on \"End of the game with no result\"";
        }
        if (status == GameStatusType.DRAW) {
            return "Status of game to changing on \"Draw\"";
        }

        if (status == GameStatusType.END_GAME_NO_RESULT) {
            return "Status of game to changing on \"End game no result\"";
        }

        else {
            throw new ChessModelRuntimeException("Invalid request to status for the to end game");
        }
    }

}
























