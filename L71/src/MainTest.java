
import java.util.*;

public class MainTest {

	private static final int MAGICK_END = -100;

	public static void main(String[] args) {
		final Random random = new Random();
		double startTime = System.currentTimeMillis();
		int size = 70000;
		int position = (Integer.valueOf(random.nextInt(size)));
		int i = 1;
		PlatformerGame game = new PlatformerGame(size, position);
		System.out.println("Начало >>> " + position + " <<<");

		/*
		 * System.out.println(game.currentPosition()); game.jumpLeft();
		 * System.out.println(game.currentPosition()); game.jumpRight();
		 * System.out.println(game.currentPosition()); System.exit(0);
		 */
		/*
		 * while (game.currentPosition() != MAGICK_END) { i =
		 * (Integer.valueOf(random.nextInt(2))); if (i == 1) { game.jumpLeft();
		 * if (game.currentPosition() >= 0) { System.out.println("Влево  - " +
		 * game.currentPosition()); } } else { game.jumpRight(); if
		 * (game.currentPosition() <= size) { System.out.println("Вправо - " +
		 * game.currentPosition()); } } }
		 * 
		 * double timeFinish = System.currentTimeMillis() - startTime;
		 * System.out.println("программа выполнялась " + timeFinish / 1000 +
		 * " секунд"); System.out.println(game.jumps); }
		 */
	}
}
