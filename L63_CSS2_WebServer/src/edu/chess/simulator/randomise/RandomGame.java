package edu.chess.simulator.randomise;

import java.io.Serializable;
import java.util.ArrayList;

import edu.chess.simulator.interfaces.FigureType;
import edu.chess.simulator.interfaces.GameResultType;
import edu.chess.simulator.interfaces.IGame;
import edu.chess.simulator.interfaces.IPlayer;

public class RandomGame implements IGame,Serializable {
	private static final long serialVersionUID = -4197405815354926362L;
	IPlayer playerToMove;
	IPlayer whitePlayer;
	IPlayer blackPlayer;
	ArrayList<String> historyLog;
	
	GameResultType gameStatus;
	FigureType[][] figuresOnBord;
	
	
	public RandomGame(){
		this.blackPlayer = new RandomPlayer();
		this.whitePlayer = new RandomPlayer();
		//***
		if(Math.random()> 0.5) {
			this.playerToMove = getBlackPlayer();
		}else {
			this.playerToMove = getWhitePlayer();
		}
		//***
		this.historyLog = randomHistoryLog();
		//***
		this.gameStatus = GameResultType.IN_PROGRESS;
		//***
		this.figuresOnBord = randomBord();
	}

	private FigureType[][] randomBord() {
		FigureType[][] array  = {
				{FigureType.BLACK_ROOK,FigureType.BLACK_KNIGHT,FigureType.BLACK_BISHOP,FigureType.BLACK_QUEEN,FigureType.BLACK_KING,FigureType.BLACK_BISHOP,FigureType.BLACK_KNIGHT,FigureType.BLACK_ROOK},
				{FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN},
				{null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null},
				{FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN},
				{FigureType.WHITE_ROOK,FigureType.WHITE_KNIGHT,FigureType.WHITE_BISHOP,FigureType.WHITE_QUEEN,FigureType.WHITE_KING,FigureType.WHITE_BISHOP,FigureType.WHITE_KNIGHT,FigureType.WHITE_ROOK}};					
		return array;
	}

	private ArrayList<String> randomHistoryLog() {
		ArrayList<String> temp = new ArrayList<>();
		if(Math.random()>0.5) {
		temp.add("Игрок " +getBlackPlayer().getName() + " пошёл пить чай\n");
		temp.add("Игрок " +getWhitePlayer().getName() + " не понимает что происходит\n");
		}else {
			temp.add("Игрок " +getWhitePlayer().getName() + " пошёл пить чай\n");
			temp.add("Игрок " +getBlackPlayer().getName() + " не понимает что происходит\n");	
		}
		return temp;
	}

	@Override
	public IPlayer getPlayerToMove() {
		return playerToMove;
	}

	@Override
	public GameResultType getGameResult() {
		return gameStatus;
	}

	@Override
	public FigureType[][] getCurrentPosition() {
		return figuresOnBord;
	}

	@Override
	public IPlayer getWhitePlayer() {
		return whitePlayer;
	}

	@Override
	public IPlayer getBlackPlayer() {
		return blackPlayer;
	}

	@Override
	public ArrayList<String> getHistoryLog() {
		return historyLog;
	}

}
