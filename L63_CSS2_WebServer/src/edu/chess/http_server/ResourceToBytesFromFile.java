package edu.chess.http_server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResourceToBytesFromFile {

	/**
	 * Метод ищет и читает запрошеный ресурс из файловой системы и возвращает его массив
	 * байт.
	 * 
	 * @param requestResourse
	 *            - путь, имя, и формат ресурса.
	 * @return - массив байт запрошеного ресурса.
	 */
	public byte[] getResource(String requestResourse) {
		return readFile(requestResourse);
	}

	private byte[] readFile(String requestResourse) {
		/* Console */System.out.println("[Чтение запрашиваемого файла для ответа]");

		File file = new File("./web/pages/" + requestResourse);
		FileInputStream in = null;
		byte[] buffer = null;
		try {
			// *********************************
			in = new FileInputStream(file);
			buffer = new byte[in.available()];
			in.read(buffer, 0, in.available());
			// *********************************

		} catch (FileNotFoundException e) {
			System.err.println("[Нету читаемого файла]");
			System.out.println("\n\n");
			e.printStackTrace();
			System.out.println("\n\n");
			return buffer = new byte[0];
		} catch (IOException e) {
			System.out.println("[Ошибка чтения файла]");
			System.out.println("\n\n");
			e.printStackTrace();
			System.err.println("\n\n");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				System.out.println("[Ошибка закрытия потока чтения]");
				System.err.println("\n\n");
				e.printStackTrace();
				System.err.println("\n\n");
			}
		}

		return buffer;

	}
}
