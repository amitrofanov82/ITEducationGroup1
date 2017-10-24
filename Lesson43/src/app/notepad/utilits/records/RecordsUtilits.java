package app.notepad.utilits.records;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RecordsUtilits {
	//fields
	static Random random = new Random();

	//methods
	/**
	 * A quick and "dangerous" way to get an ID
	 * @return long - Random 7's digits
	 */
	public static long getRandom7Digits() {
		long sixDigits = random.nextLong() % 1000000;
		if (sixDigits < 0) {
			sixDigits *= -1;
		}
		return sixDigits;
	}
	
	/**
	 * @param Daate date
	 * @return String "dd.mm.yyyy hh:mm"
	 */
	public static String convertDate(Date date) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		String dateString = simpleDate.format(date);
		return dateString;
	}

	@SuppressWarnings({ "deprecation", "null" })
	public static Date convertDate(String dateStr) {
		//dd.MM.yyyy HH:mm
		Date date = null;
		date.setMinutes(Integer.parseInt(dateStr.substring(14, 16)));
		date.setHours(Integer.parseInt(dateStr.substring(11, 13)));
		date.setYear(Integer.parseInt(dateStr.substring(6, 10)));
		date.setMonth(Integer.parseInt(dateStr.substring(3, 5)));
		date.setDate(Integer.parseInt(dateStr.substring(0, 2)));
		date.setSeconds(0);
		return date;
	}





}
