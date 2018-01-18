package edu.chess;

import edu.chess.simulator.SimulatorGame;
import edu.chess.web.ClientGame;

public class LauncherWebChess {

	public static void main(String[] args) {

		new Thread() {

			public void run() {
				System.out.println("[Запуск потока симулятора]");
				new SimulatorGame().start();
			}
		}.start();

		new Thread() {
			public void run() {
				System.out.println("[Запуск потока сервера]");
				new ClientGame().start();
			}
		}.start();

	}

}
