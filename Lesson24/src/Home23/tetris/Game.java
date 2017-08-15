package Home23.tetris;

import GetInput.GetInt;
import Home23.tetris.figures.*;

public class Game {
	private Field field;
	// пока true - фигура ещё доступна для манипуляций
	public static boolean figureInGame;
	// если false - конец игры, заполнение поля
	public static boolean stackIsNtFull;

	public Game() {
		field = new Field();
	}

	public void start() {
		stackIsNtFull = true;

		while (stackIsNtFull) {
			// массив с возможными фигурами
			Figure[] pieces = { new L(), new Line(), new Square(), new T(), new Z() };
			// текущая фигура
			int currentPiece = (int) (Math.random() * pieces.length);
			figureInGame = true;
			// ввод фигуры в игру вверху поля
			field.appearFig(pieces[currentPiece]);
			// System.out.println(field);

			while (figureInGame) {
				// отрисовка поля
				System.out.println(field);
				System.out.println("Possible move:\n1. Left\n2. Right\n3. Rotate" + "\n4. Down\n5. Completly down");

				// выбор пользователя
				switch (GetInt.get()) {
				// перемещение влево
				case (1): {
					field.moveLeft(pieces[currentPiece]);
					field.moveDown(pieces[currentPiece]);
					break;
				}
				// перемещение вправо
				case (2): {
					field.moveRight(pieces[currentPiece]);
					field.moveDown(pieces[currentPiece]);
					break;
				}
				// поворот
				case (3): {
					field.rotate(pieces[currentPiece]);
					field.moveDown(pieces[currentPiece]);
					break;
				}
				// перемещение вниз
				case (4): {
					field.moveDown(pieces[currentPiece]);
					break;
				}
				// перемещение вниз до упора
				case (5): {
					while (figureInGame) {
						field.moveDown(pieces[currentPiece]);
					}
					break;
				}
				default: {
					break;
				}
				}
			}
		}
		System.out.println("Game is over");
	}
}