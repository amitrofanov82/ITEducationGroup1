package edu.chess;

import edu.chess.http_server.SimpleHttpServer;

public class LauncerHTTPServer {

	public static void main(String[] args) {
		new SimpleHttpServer().launch();
	}

}
