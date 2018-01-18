package edu.chess.web.page_crearors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.chess.simulator.interfaces.FigureType;
import edu.chess.simulator.interfaces.IGame;

public class PageCreatorForHttpServer {

	IGame game;

	public PageCreatorForHttpServer(IGame inputGame) {
		this.game = inputGame;
	}

	public void createPages() {
		createMainPage();
		createFirstPlayerPage();
		createSecondPlayerPage();

	}
	
	

	private void createMainPage() {

		// Заполнение огловления;
		String tempStringHead = "<!DOCTYPE html>" + "\n";
		tempStringHead += "<html>" + "\n";
		tempStringHead += "<head>" + "\n";
		tempStringHead += "<meta charset=\'UTF-8\'>" + "\n";
		tempStringHead += "<link rel=\'icon\' type=\'image/png\' href=\'/resources/favicon.png\'/>" + "\n";
		tempStringHead += "<title>Simulation Web Chess</title>" + "\n";
		//tempStringHead += "<script type=\'text/javascript\'>" + "\n";
		//tempStringHead += "var interval = setInterval(\'location.reload(true)\', 10000);" + "\n";
		//tempStringHead += "</script>" + "\n";
		tempStringHead += "</head>" + "\n";

		// Заполнение тела;
		String tempStringBody = "";
		tempStringBody += "<body text=\'#8B4513\' bgcolor=\'gray\' background = \'/resources/background.png\'>"
				+ "\n";

		// Разметка контента и запонение;
		tempStringBody += "<div align=\'center\'>" + "\n";
		tempStringBody += "<table width=\'890px\' height=\'810px\' background=\'/resources/tablebg.png\'>" + "\n";

		// Начало первой строкии контента;
		tempStringBody += "<tr>" + "\n";

		// Блок "Игроки";
		tempStringBody += "<td>" + "\n";
		tempStringBody += "<div title=\'players\'>" + "\n";
		// Игрок 1;
		tempStringBody += "<h2 align=\'left\'>" + "\n";
		tempStringBody += "Игрок " + "<a target=\'_blank\' " + "title=\'profile\' href = \'"
				+ game.getWhitePlayer().getName() + ".html\'>" + game.getWhitePlayer().getName() + "</a>"
				+ " играет белыми";
		tempStringBody += "</h2>" + "\n";
		// Игрок 2;
		tempStringBody += "<h2 align=\'right\'>" + "\n";
		tempStringBody += "Игрок " + "<a target=\'_blank\' " + "title=\'profile\' href = \'"
				+ game.getBlackPlayer().getName() + ".html\'>" + game.getBlackPlayer().getName() + "</a>"
				+ " играет черными";
		tempStringBody += "</h2>" + "\n";
		//
		tempStringBody += "</div>" + "\n";
		tempStringBody += "</td>" + "\n";

		// Блок "Кто ходит";
		tempStringBody += "<td>" + "\n";
		tempStringBody += "<div title=\'whoMove\'>" + "\n";
		tempStringBody += "<h3 align=\'center\'>" + "\n";
		tempStringBody += "Ходит: " + game.getPlayerToMove().getName() + "\n";
		tempStringBody += "</h3>" + "\n";
		//
		tempStringBody += "</div>" + "\n";
		tempStringBody += "</td>" + "\n";

		// Конец первой строки контента;
		tempStringBody += "</tr>\n";

		// Начало второй строки контента;
		tempStringBody += "<tr>" + "\n";

		// Блок "Доска"
		tempStringBody += "<td>" + "\n";
		tempStringBody += "<div title=\'board\'>" + "\n";
		tempStringBody += "<table border=\'2px\'>" + "\n";
		tempStringBody += "<td>" + "\n";
		// Создание доски;
		tempStringBody += createBoard() + "\n";
		tempStringBody += "</td>" + "\n";
		//
		tempStringBody += "</table>" + "\n";
		tempStringBody += "</div>" + "\n";
		tempStringBody += "</td>" + "\n";

		// Блок "История";
		tempStringBody += "<td valign=\'top\'>" + "\n";
		tempStringBody += "<div title=\'history\'>" + "\n";
		tempStringBody += "<h2>History:</h2>" + "\n";
		// Создание списка;
		tempStringBody += "<ul>" + "\n";
		tempStringBody += formatHistory(game.getHistoryLog()) + "\n";
		tempStringBody += "</ul>" + "\n";
		tempStringBody += "</div>" + "\n";
		tempStringBody += "</td>" + "\n";

		// Конец второй строки контента;
		tempStringBody += "</tr>" + "\n";

		// Конец блока контент;
		tempStringBody += "</table>" + "\n";
		tempStringBody += "</div>" + "\n";

		// Конец документа;
		tempStringBody += "</body>" + "\n";
		tempStringBody += "</html>" + "\n";
		// Сохранение документа;
		savePage(tempStringHead + tempStringBody, "index");
	}

	private void createFirstPlayerPage() {
		// Игрок белыми;
		// Заполнение огловления;
		String tempStringHead = "<!DOCTYPE html>" + "\n";
		tempStringHead += "<html>" + "\n";
		tempStringHead += "<head>" + "\n";
		tempStringHead += "<meta charset=\'UTF-8\'>" + "\n";
		tempStringHead += "<link rel=\'icon\' type=\'image/png\' href=\'/resources/favicon.png\'/>" + "\n";
		tempStringHead += "<title>Profile Player " + game.getWhitePlayer().getName() + "</title>" + "\n";
		// tempStringHead += "<script type=\'text/javascript\'>" + "\n";
		// tempStringHead += "var interval = setInterval(\'location.reload(true)\',
		// 10000);" + "\n";
		// tempStringHead += "</script>" + "\n";
		tempStringHead += "</head>" + "\n";

		// Заполнение тела;
		String tempStringBody = "";
		tempStringBody += "<body text=\'#8B4513\' bgcolor=\'gray\' background = \'/resources/background.png\'>"
				+ "\n";

		// Разметка контента и запонение;
		tempStringBody += "<div align=\'center\'>" + "\n";
		tempStringBody += "<table width=\'890px\' height=\'810px\' background=\'/resources/tablebg.png\'>" + "\n";

		// Начало блока контент;
		tempStringBody += "<tr>" + "\n";
		tempStringBody += "<td>" + "\n";
		tempStringBody += "<div align=\'center\'>" + "\n";

		// Табличка игрока
		tempStringBody += "<table width=\'890px\' height=\'810px\' cellspacing=\'0\'>" + "\n";
		tempStringBody += "<tr>" + "\n";

		tempStringBody += "<td valign=\'top\'>" + "\n";
		tempStringBody += "<img align=\'left\' width=\'300px\'" + " height=\'300px\'" + " alt=\'Player Avatar\'"
				+ " src=\'/resources/avatars/avatar" + (digitRanfom()) + ".png\'>" + "\n";

		tempStringBody += "<p>" + "\n";
		tempStringBody += "Этот игрок белый как зефирка." + "\n";
		tempStringBody += "</p>" + "\n";
		tempStringBody += "</td>" + "\n";

		tempStringBody += "<td valign=\'top\'>" + "\n";
		tempStringBody += "<h3>" + "\n";
		tempStringBody += "Rating:" + "\n";
		tempStringBody += "</h3>" + "\n";
		tempStringBody += "<h4>" + "\n";
		tempStringBody += "Rating point: 0" + "\n";
		tempStringBody += "</h4>" + "\n";
		tempStringBody += "<ul>" + "\n";
		tempStringBody += "<li>" + "\n";
		tempStringBody += "<p>" + "\n";
		tempStringBody += "Какая - то игра" + "\n";
		tempStringBody += "<p>" + "\n";
		tempStringBody += "</li>" + "\n";
		tempStringBody += "</ul>" + "\n";
		tempStringBody += "</td>" + "\n";

		tempStringBody += "</tr>" + "\n";
		tempStringBody += "</table>" + "\n";
		tempStringBody += "</td>" + "\n";

		// Конец блока контент;
		tempStringBody += "</div>" + "\n";
		tempStringBody += "</tr>" + "\n";
		tempStringBody += "</table>" + "\n";
		tempStringBody += "</div>" + "\n";

		// Конец документа;
		tempStringBody += "</body>" + "\n";
		tempStringBody += "</html>" + "\n";

		// Сохранение документа;
		savePage(tempStringHead + tempStringBody, game.getWhitePlayer().getName());
	}

	private void createSecondPlayerPage() {
		// Игрок черными;
		// Заполнение огловления;
		String tempStringHead = "<!DOCTYPE html>" + "\n";
		tempStringHead += "<html>" + "\n";
		tempStringHead += "<head>" + "\n";
		tempStringHead += "<meta charset=\'UTF-8\'>" + "\n";
		tempStringHead += "<link rel=\'icon\' type=\'image/png\' href=\'/resources/favicon.png\'/>" + "\n";
		tempStringHead += "<title>Profile Player " + game.getBlackPlayer().getName() + "</title>" + "\n";
		// tempStringHead += "<script type=\'text/javascript\'>" + "\n";
		// tempStringHead += "var interval = setInterval(\'location.reload(true)\',
		// 10000);" + "\n";
		// tempStringHead += "</script>" + "\n";
		tempStringHead += "</head>" + "\n";

		// Заполнение тела;
		String tempStringBody = "";
		tempStringBody += "<body text=\'#8B4513\' bgcolor=\'gray\' background = \'/resources/background.png\'>"
				+ "\n";

		// Разметка контента и запонение;
		tempStringBody += "<div align=\'center\'>" + "\n";
		tempStringBody += "<table width=\'890px\' height=\'810px\' background=\'/resources/tablebg.png\'>" + "\n";

		// Начало блока контент;
		tempStringBody += "<tr>" + "\n";
		tempStringBody += "<td>" + "\n";
		tempStringBody += "<div align=\'center\'>" + "\n";

		// Табличка игрока
		tempStringBody += "<table width=\'890px\' height=\'810px\' cellspacing=\'0\'>" + "\n";
		tempStringBody += "<tr>" + "\n";

		tempStringBody += "<td valign=\'top\'>" + "\n";
		tempStringBody += "<img align=\'left\' width=\'300px\'" + " height=\'300px\'" + " alt=\'Player Avatar\'"
				+ " src=\'/resources/avatars/avatar" + (digitRanfom()) + ".png\'>" + "\n";

		tempStringBody += "<p>" + "\n";
		tempStringBody += "Мысли этого игрока чернее чем твой кофе." + "\n";
		tempStringBody += "</p>" + "\n";
		tempStringBody += "</td>" + "\n";

		tempStringBody += "<td valign=\'top\'>" + "\n";
		tempStringBody += "<h3>" + "\n";
		tempStringBody += "Rating:" + "\n";
		tempStringBody += "</h3>" + "\n";
		tempStringBody += "<h4>" + "\n";
		tempStringBody += "Rating point: 0" + "\n";
		tempStringBody += "</h4>" + "\n";
		tempStringBody += "<ul>" + "\n";
		tempStringBody += "<li>" + "\n";
		tempStringBody += "<p>" + "\n";
		tempStringBody += "Какая - то игра" + "\n";
		tempStringBody += "<p>" + "\n";
		tempStringBody += "</li>" + "\n";
		tempStringBody += "</ul>" + "\n";
		tempStringBody += "</td>" + "\n";

		tempStringBody += "</tr>" + "\n";
		tempStringBody += "</table>" + "\n";
		tempStringBody += "</td>" + "\n";

		// Конец блока контент;
		tempStringBody += "</div>" + "\n";
		tempStringBody += "</tr>" + "\n";
		tempStringBody += "</table>" + "\n";
		tempStringBody += "</div>" + "\n";

		// Конец документа;
		tempStringBody += "</body>" + "\n";
		tempStringBody += "</html>" + "\n";

		// Сохранение документа;
		savePage(tempStringHead + tempStringBody, game.getBlackPlayer().getName());
	}
	
	private void savePage(String string, String namePage) {
		try {
			File file = new File("./web/pages/" + namePage + ".html");
			FileWriter writer = new FileWriter(file, false);
			writer.write(string);
			writer.flush();
			writer.close();
			System.out.println("[Файл " + namePage + ".html создан в web/pages/]");
			writer = null; // снижение потребляемой памяти на 2-3%,
			file = null; // при вызовах раз в 2 сек.
		} catch (IOException e) {
			System.err.println("[Error writing page]");
			System.err.println("\n\n");
			e.printStackTrace();
			System.err.println("\n\n");
		}

	}

	private String createBoard() {
		String tempStringTableBoard = "";
		boolean lastColorBlack = true;
		int digitBoard = 8;

		// Таблица доски;
		tempStringTableBoard += "<table>" + "\n";
		tempStringTableBoard += "<tr>" + "\n";

		// Первая строка символьных кардинат;
		tempStringTableBoard += lettersOnTheBoard();

		tempStringTableBoard += "</tr>" + "\n";

		// Основные строки с автоотрисовкой цифровой кординаты;
		for (int y = 0; y < 8; y++) {

			tempStringTableBoard += "<tr>" + "\n";

			// Ячейка кординаты
			tempStringTableBoard += "<td>" + "\n";
			tempStringTableBoard += "<h3 align=\'center\'>" + digitBoard + "</h3>" + "\n";
			tempStringTableBoard += "</td>" + "\n";

			// Ячейки доски на одной строке;
			for (int x = 0; x < 8; x++) {

				// Ячейка доски
				tempStringTableBoard += "<td bgcolor=";
				if (lastColorBlack) {
					tempStringTableBoard += "\'white\'>" + "\n";
					lastColorBlack = false;
				} else {
					tempStringTableBoard += "\'black\'>" + "\n";
					lastColorBlack = true;
				}

				// Установка фигуры
				tempStringTableBoard += "<img alt=\'" + game.getCurrentPosition()[y][x] + "\'" + "src=\'"
						+ classifierFigures(game.getCurrentPosition()[y][x]) + "\'>" + "\n";
			}

			// Отрисовка правых цифровых кардинат
			tempStringTableBoard += "<td>" + "\n";
			tempStringTableBoard += "<h3 align=\'center\'>" + digitBoard + "</h3>" + "\n";
			tempStringTableBoard += "</td>" + "\n";

			digitBoard--;

			// Коректировка клеток
			if (digitBoard % 2 == 0) {
				lastColorBlack = true;
			} else {
				lastColorBlack = false;
			}

			tempStringTableBoard += "</tr>" + "\n";
		}
		tempStringTableBoard += "<td>" + "\n";
		tempStringTableBoard += "</td>" + "\n";

		tempStringTableBoard += lettersOnTheBoard();

		// Конец таблицы доски;
		tempStringTableBoard += "</table>" + "\n";

		return tempStringTableBoard;
	}

	private String lettersOnTheBoard() {
		String tempString = "";
		char letterBoard = 'a';

		// Пустоая ячейка 0-ой кординаты;
		tempString += "<td>" + "\n";
		tempString += "</td>" + "\n";

		for (int i = 0; i < 8; i++) {
			tempString += "<td height=\'30px\'>" + "\n";
			tempString += "<h3 align=\'center\'>" + letterBoard + "</h3>" + "\n";
			tempString += "</td>" + "\n";

			letterBoard++;
		}
		letterBoard = 'a';// Обнуление буквенной кординаты;

		return tempString;
	}

	private String classifierFigures(FigureType figureType) {
		if (figureType == null) {
			return "/resources/figures/null.png";
		}
		switch (figureType) {
		case BLACK_PAWN: {
			return "/resources/figures/bpawn.png";
		}
		case BLACK_ROOK: {
			return "/resources/figures/brook.png";
		}
		case BLACK_KNIGHT: {
			return "/resources/figures/bknight.png";
		}
		case BLACK_BISHOP: {
			return "/resources/figures/bbishop.png";
		}
		case BLACK_QUEEN: {
			return "/resources/figures/bqueen.png";
		}
		case BLACK_KING: {
			return "/resources/figures/bking.png";
		}
		case WHITE_PAWN: {
			return "/resources/figures/wpawn.png";
		}
		case WHITE_ROOK: {
			return "/resources/figures/wrook.png";
		}
		case WHITE_KNIGHT: {
			return "/resources/figures/wknight.png";
		}
		case WHITE_BISHOP: {
			return "/resources/figures/wbishop.png";
		}
		case WHITE_QUEEN: {
			return "/resources/figures/wqueen.png";
		}
		case WHITE_KING: {
			return "/resources/figures/wking.png";
		}
		default: {
			return "";
		}
		}
	}

	// Utility methods
	private String formatHistory(ArrayList<String> arrayList) {
		String tempHistory = "";
		Iterator<String> iter = arrayList.iterator();
		while (iter.hasNext()) {
			tempHistory += "<li>" + iter.next() + "</li>" + "\n";
		}
		return tempHistory;
	}

	private int digitRanfom() {
		return (int) (Math.random() * 10);
	}

}
