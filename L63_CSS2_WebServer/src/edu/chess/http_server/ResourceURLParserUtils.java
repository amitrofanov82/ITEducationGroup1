package edu.chess.http_server;

public class ResourceURLParserUtils {
	/**
	 * Метод читает из Стартовой Строки что за ресурс попросили.
	 * 
	 * @param StartLine - стартовая сторока.
	 * @return - путь, имя и формат файла.
	 */
	public static String whatIsRequestResource(String StartLine) {
		/* Console */System.out.println("[Парсинг ресурса из стартовой строки серверу {" + StartLine + "}]");
		String result = "";
		// пример - GET /picture.png HTTP/1.1
		for (int i = 0; i < StartLine.length(); i++) {
			if (StartLine.charAt(i) == '/') {
				i++;
				while (StartLine.charAt(i) != ' ') {
					result += StartLine.charAt(i);
					i++;
				}
				return result;
			}
		}
		/* Console */System.out.println("[Запрашиваемый ресурс " + result + "]");
		return result;
	}

	/**
	 * Метод выделяет из сигнатуры ресурса какой формат имее файл.
	 * @param request - сигнатура файла.
	 * @return - строку с названием формата
	 */
	public static String whatIsFormatResource(String request) {

		// Чтение формата запрашиваемого файла
		String format = "";
		for (int i = request.length() - 1; i > 0; i--) {
			if (request.charAt(i) == '.') {
				break;
			}
			format = request.charAt(i) + format;
		}
		return format;
	}

	/**
	 * Метод определяет какого типа запрашиваемый файл.
	 * @param requestResource - сигнатура файла.
	 * @return - тип файла.
	 */
	public static String whatIsTypeResource(String requestResource) {

		String format = whatIsFormatResource(requestResource);

		/* Console */System.out.println("[Определение типа запрашиваемого файла]");

		switch (format) {
		// text
		case "html": {
			return "text/html";
		}
		case "css": {
			return "text/css";
		}
		case "js": {
			return "text/javascript";
		}
		case "php": {
			return "text/php";
		}
		case "xml": {
			return "text/xml";
		}
		// image
		case "gif": {
			return "image/gif";
		}
		case "png": {
			return "image/png";
		}
		case "jpg": {
			return "image/jpeg";
		}
		case "jpeg": {
			return "image/jpeg";
		}
		case "bmp": {
			return "image/bitmap";// не точно!!!!
		}
		case "ico": {
			return "image/vnd.microsoft.icon";
		}
		// other
		case "zip": {
			return "application/zip";
		}
		case "gzip": {
			return "application/gzip";
		}
		case "torrent": {
			return "application/x-bittorrent";
		}
		case "doc": {
			return "application/msword";
		}
		case "xdoc": {
			return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		}
		case "xls": {
			return "application/vnd.ms-excel";
		}
		case "xlsx": {
			return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}
		case "ppt": {
			return "application/vnd.ms-powerpoint";
		}
		case "pptx": {
			return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
		}
		}

		return "/";// значение по умолчанию
	}

}
