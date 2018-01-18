package edu.chess.web;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import edu.chess.simulator.interfaces.IGame;
import edu.chess.simulator.randomise.RandomGame;
import edu.chess.web.page_crearors.PageCreator;
import edu.chess.web.page_crearors.PageCreatorForHttpServer;

public class ClientGame extends Thread {
	// Fields
	private Socket socetToServer;
	private ObjectOutputStream streamToSent;
	private ObjectInputStream streamToTake;
	private IGame inputGame;

	// Constructors
	public ClientGame() {
		try {
			// Конектимся к серверу
			socetToServer = new Socket("", 1024);
			// Устанавливаем потоки отправки и приёма
			streamToSent = new ObjectOutputStream(socetToServer.getOutputStream());
			streamToTake = new ObjectInputStream(socetToServer.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Methods
	public void run() {
		while (true) {
			try {
				// Приняли игру, сделали странички,
				takeRandomGame();
				createPageGame();
				// sendRandomGame();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Создаёт html странички отображающие игру.
	 */
	private void createPageGame() {
		testInConsole(inputGame);
		new PageCreator(inputGame).createPages();
		new PageCreatorForHttpServer(inputGame).createPages(); // - для http-server
	}

	/**
	 * Принимает из потока, соеденённого с сервером рандомной игры, какую-то игру.
	 * 
	 * @throws ClassNotFoundException - косяк при обратной серилизации, если не тот класс.
	 * @throws IOException - косяк с потоком от сервера.
	 */
	private void takeRandomGame() throws ClassNotFoundException, IOException {
		inputGame = (IGame) streamToTake.readObject();
	}

	/**
	 * Пока не используется.
	 * 
	 * @throws IOException
	 *             - если проблемы с записью в поток.
	 */
	@SuppressWarnings("unused")
	private void sendRandomGame() throws IOException {
		IGame newRandomGame = new RandomGame();
		streamToSent.writeObject(newRandomGame);
		streamToSent.flush();
	}

	/**
	 * Метод для тестирования данных.
	 * 
	 * @param game
	 *            - игру которую нужно вывести в консоль.
	 */
	private void testInConsole(IGame game) {
		System.out.println("Игрок " + game.getWhitePlayer().getName() + " играет белыми");
		System.out.println("Игрок " + game.getBlackPlayer().getName() + " играет черными");
		System.out.println("Сейчас ходит " + game.getPlayerToMove().getName());
		int digit = 8;// Для отображения кординат
		System.out.println(
				"  " + "   A   " + "   B   " + "   C   " + "   D   " + "   E   " + "   F  " + "   G   " + "   H   ");
		for (int i = 0; i < 8; i++) {
			System.out.print(digit + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print("[" + game.getCurrentPosition()[i][j] + "]\t");
			}
			System.out.print("" + digit);
			digit--;
			System.out.println();
		}
		System.out.println(
				"  " + "   A   " + "   B   " + "   C   " + "   D   " + "   E   " + "   F  " + "   G   " + "   H   ");
		System.out.println(game.getHistoryLog());

	}

}
