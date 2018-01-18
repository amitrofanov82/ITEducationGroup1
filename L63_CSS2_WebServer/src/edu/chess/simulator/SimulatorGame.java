package edu.chess.simulator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import edu.chess.simulator.interfaces.IGame;
import edu.chess.simulator.randomise.RandomGame;

/**
 * Класс имитирует движок игры в шахматы, создовая каждую минуту случайную
 * стартовую игру.
 *
 */
public class SimulatorGame extends Thread {
	// Fields
	ServerSocket socket;
	Socket client;
	ObjectInputStream streamToTake;
	ObjectOutputStream streamToSent;
	IGame inputGame;

	// Constructor
	public SimulatorGame() {
		try {
			// Создаём порт который случшает команды
			socket = new ServerSocket(1024);
			client = socket.accept();
			// Устанавливаем потоки отправки и приёма
			streamToTake = new ObjectInputStream(client.getInputStream());
			streamToSent = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			socket.setSoTimeout(60000);// Таймаут ожидания клиета в открытом сокете.
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {

			try {
				// Оправляем в порт 1024 каждую минуту новую рандомную игру, и даже пробуем
				// забрать ответ после ожидания.
				sendRandomGame();
				Thread.sleep(60000);
				takeRandomGame();
			} catch (ClassNotFoundException | IOException | InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	// Демастрационный метод
	private void takeRandomGame() throws ClassNotFoundException, IOException {
		inputGame = (IGame) streamToTake.readObject();
	}

	/**
	 * Метод создает случайную игру и отправляет клиенту.
	 * 
	 * @throws IOException
	 */
	private void sendRandomGame() throws IOException {
		IGame newRandomGame = new RandomGame();
		streamToSent.writeObject(newRandomGame);
		streamToSent.flush();
	}

}
