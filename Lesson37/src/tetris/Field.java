package tetris;

public class Field {
	// константы для направлений
	private final int DOWN = 0, RIGHT = 1, LEFT = -1;
	// размер игрового поля
	public boolean[][] field = new boolean[21][11];
	// очки
	private int score;
	// координаты левого верхнего края массива, содержащего фигуру
	private int[] curFigPl = new int[2];

	public int[] getCurFigPl() {
		return curFigPl;
	}

	public void setCurFigPl(int i, int j) {
		curFigPl[0] = i;
		curFigPl[1] = j;
	}

	// пока true - фигура ещё доступна для манипуляций
	public boolean figureInGame;
	// если false - конец игры, заполнение поля
	public boolean stackIsNtFull;

	public Field() {
		stackIsNtFull = true;
		score = 0;
	}

	public void move(Figure figure, int direction) {

		// копирование карты фигуры во временный массив coord
		boolean[][] map = figure.getMap();

		// стирание фигуры
		eraseFig(map);

		
		for (int i = curFigPl[0]; i < map.length + curFigPl[0]; i++) {
			for (int j = curFigPl[1]; j < map[0].length + curFigPl[1]; j++) {
				if (map[i - curFigPl[0]][j - curFigPl[1]]) {
					switch (direction) {
					case DOWN: {
						if (i == field.length - 1 || field[i + 1][j]) {
							// отрисовка текущей фигуры
							drawFig(map);
							// проверка не собралась ли линия
							lineCheck();
							figureInGame = false;
							return;
						}
						break;
					}
					case RIGHT: {
						if (j == field[0].length - 1 || field[i][j + 1]) {
							// отрисовка текущей фигуры
							drawFig(map);
							return;
						}
						break;
					}
					case LEFT: {
						if (j == 0 || field[i][j - 1]) {
							// отрисовка текущей фигуры
							drawFig(map);
							return;
						}
					}
					default:
						break;
					}
				}
			}
		}
		switch (direction) {
		case DOWN: {
			// смещение фигуры вниз
			curFigPl[0]++;
			break;
		}
		case RIGHT: {
			// смещение фигуры вправо
			curFigPl[1]++;
			break;
		}
		case LEFT: {
			// смещение фигуры влево
			curFigPl[1]--;
			break;
		}
		default:
			break;
		}

		drawFig(map);
	}

	// поворот
	public void rotate(Figure figure) {

		boolean[][] map = figure.getMap();

		eraseFig(map);

		figure.rotate(this);
		map = figure.getMap();

		drawFig(map);
	}

	// ввод фигуры в игру вверху поля
	public void appearFig(Figure figure) {
		if (!drawFig(figure.getMap())) {
			stackIsNtFull = false;
			figureInGame = false;
			return;
		}
	}

	// нарисовать фигуру
	private boolean drawFig(boolean[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j]) {
					if (!field[i + curFigPl[0]][j + curFigPl[1]]) {
						field[i + curFigPl[0]][j + curFigPl[1]] = true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	// стереть фигуру
	private void eraseFig(boolean[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j]) {
					if (field[i + curFigPl[0]][j + curFigPl[1]]) {
						field[i + curFigPl[0]][j + curFigPl[1]] = false;
					}
				}
			}
		}
	}

	// поиск "собранных" линий
	private void lineCheck() {
		int series = 0;

		for (int i = field.length - 1; i >= 0; i--) {
			boolean full = true;
			for (int j = 0; j < field[i].length; j++) {
				if (!field[i][j]) {
					full = false;
				}
			}
			if (full) {
				// чем больше линий собралось одновременно, тем больше прибавка
				// счёта
				series++;
				score += series;
				for (int j = 0; j < field[i].length; j++) {
					field[i][j] = false;
				}
				for (int k = i; k > 0; k--) {
					for (int j = 0; j < field[k].length; j++) {
						field[k][j] = field[k - 1][j];
					}

				}
				i++;
			}
		}
	}

	@Override
	public String toString() {
		String output = "\n\nScore: " + score + "\n";
		for (int i = 0; i < field.length; i++) {
			output += "\t\t\t\t";
			if (i != 0) {
				output += "*";
			} else {
				output += " ";
			}
			for (int j = 0; j < field[i].length; j++) {
				output += (!field[i][j]) ? " " : "X";
			}
			if (i != 0) {
				output += "*";
			} else {
				output += " ";
			}
			output += "\n";
		}
		output += "\t\t\t\t**";
		for (int i = 0; i < field[0].length; i++) {
			output += "*";
		}
		return output;
	}
}