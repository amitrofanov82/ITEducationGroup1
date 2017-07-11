import java.util.Scanner;

public class GetString
{
	public static String get()
	{
		Scanner take = new Scanner(System.in);

		String input = take.nextLine();

		while (input.length() < 1 || input.length() > 30)
		{
			System.out.println("Wrong Input. Retry >>");
			input = take.nextLine();
		}
		// take.close();

		return input;
	}
}