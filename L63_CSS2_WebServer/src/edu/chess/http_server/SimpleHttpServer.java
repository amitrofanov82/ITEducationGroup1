package edu.chess.http_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by yar 09.2009 Upgrade by IlyaBeetle 01.2018
 * 
 * @author yar, IlyaBeetle
 * @version 0.1
 */
public class SimpleHttpServer {

	private ServerSocket ss = null;

	// Constructor
	public SimpleHttpServer() {
		try {
			this.ss = new ServerSocket(8080);
		} catch (IOException e) {
			System.err.println("[Ошибка создания порта сервера]");
			System.err.println("\n\n");
			e.printStackTrace();
			System.err.println("\n\n");
		}
	}

	// Launcher magic
	public void launch() {
		long timeStartServer = System.currentTimeMillis();
		while (true) {
			try {
				Socket s = ss.accept();
				/* Console */
				System.out.println("[Клиент принят]");

				new Thread(new SocketProcessor(s)).start();

				// Сервер работает 10 мин
				if (timeOutHttpServer(timeStartServer)) {
					ss.close();
					System.exit(1);
				}
			} catch (Throwable e) {
				System.err.println("\n\n");
				e.printStackTrace();
				System.err.println("\n\n");
			}
		}
	}

	/**
	 * 
	 * @param timer
	 * @return
	 */
	boolean timeOutHttpServer(long timeStartServer) {
		long timeNow = System.currentTimeMillis();
		if (timeNow > (timeStartServer + 6000000)) {
			return true;
		}
		return false;
	}

	/**
	 * Класс основной магии.
	 */
	private static class SocketProcessor implements Runnable {

		private Socket s;
		private InputStream is;
		private OutputStream os;

		private SocketProcessor(Socket s) throws Throwable {
			this.s = s;
			this.is = s.getInputStream();
			this.os = s.getOutputStream();
		}

		public void run() {
			/* Console */
			System.out.println("[Сервер HTTP получил запрос]");
			try {
				// *************************************************************
				String[] request = readInputHeaders();

				String requestResourceName = ResourceURLParserUtils.whatIsRequestResource(request[0]);

				// при пустом запросе всегда возвращать главную.
				if (requestResourceName == "") {
					requestResourceName = "index.html";
				}

				String fileType = ResourceURLParserUtils.whatIsTypeResource(requestResourceName);

				
				ResourceToBytesFromFile resourceContent = new ResourceToBytesFromFile();
				byte[] respondeBody = resourceContent.getResource(requestResourceName);
				writeResponse(new ResourceToBytesFromFile().getResource(requestResourceName), fileType);
				// *************************************************************
			} catch (Throwable e) {
				System.err.println("[Проблема в потоке http сервера]");
				System.err.println("\n\n");
				e.printStackTrace();
				System.out.println("\n\n");
			} finally {
				try {
					s.close();
				} catch (Throwable t) {
					System.err.println("[Проблема c закрытием сокета http сервера]");
					System.err.println("\n\n");
					t.printStackTrace();
					System.err.println("\n\n");
				}
			}
			/* Console */System.out.println("[Обработка клиента завершена]" + "\n\n\n");
		}

		/**
		 * Этод метод читает из потока заголовок запроса.
		 * 
		 * @return - возвращает масив строк содержаший заголовк запроса.
		 */
		private String[] readInputHeaders() {
			/* Console */System.out.println("[Чтение запроса серверу]");

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String[] arrayHeader = new String[100];// С запасом =)
			int counter = 0;
			while (true) {
				try {
					// ******************************************************
					arrayHeader[counter] = br.readLine();
					System.out.println("\t{" + arrayHeader[counter] + "}");
					// Проверка на конец данных
					if (arrayHeader[counter] == null || arrayHeader[counter].trim().length() == 0) {
						break;
					}
					counter++;
					// ******************************************************
				} catch (IOException e) {
					System.err.println("[Проблема чтения входяшего потока]");
					System.err.println("\n\n");
					e.printStackTrace();
					System.err.println("\n\n");
				}

			}

			/* Console */System.out.println("[Сервер HTTP прочитал заголовок]");
			return arrayHeader;
		}

		/**
		 * Этот метод формирует ответ клиенту, в виде шоловы ответа и запрашиваемого
		 * ресурса.
		 * 
		 * @param resourse
		 *            - масив байт запрошеного ресурса.
		 * @param mimeType
		 *            - тип передоваемого ресурса.
		 * @throws Throwable
		 *             - при ошибке записи в поток.
		 */
		private void writeResponse(byte[] resourse, String mimeType) throws Throwable {
			/* Console */System.out.println("[Создание ответа сервера]");
			
			String response = "";
			response += "HTTP/1.1 200 OK\r\n";
			response += "Server: YarServer/+IlyaBeetle\r\n";
			response += "Content-Type: " + mimeType + "\r\n";
			response += "Content-Length: " + resourse.length + "\r\n";
			response += "Connection: close\r\n\r\n";

			System.out.println("\t{" + "HTTP/1.1 200 OK" + "}");
			System.out.println("\t{" + "Server: Simple HTTP Server v0.1" + "}");
			System.out.println("\t{" + "Content-Type: " + mimeType + "}");
			System.out.println("\t{" + "Content-Length: " + resourse.length + "}");
			System.out.println("\t{" + "Connection: close" + "}");
			System.out.println("\t{}");

			os.write(response.getBytes(/*нужна АСКИ-совм. кодировка*/));
			os.write(resourse);
			os.flush();
		}

	}
}