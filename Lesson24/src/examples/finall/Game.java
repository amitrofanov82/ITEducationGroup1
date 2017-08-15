package examples.finall;

import GetInput.GetInt;
import Home23.tetris.Field;
import Home23.tetris.Figure;
import Home23.tetris.figures.*;

public final class Game {
	//object fields:
	private final Field field;// = new Field();
	private final int intProperty;// = (int) Math.random()*10;
	private final int[] intArrayProperty = new int[10];
	// static:
	public static final boolean FIGURE_IN_GAME = true;
	private static final Field FIELD_2 = new Field();

	public /*final*/ Game() { //нельзя
		field = new Field();
		intProperty=4;
	}
	
	

	public final void start(final Field f, final int i) {
		final int i2 = 2;
		System.out.println("Game is over");
		//intProperty=5; нельзя
		
	}
}