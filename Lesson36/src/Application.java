import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws Exception {

		MainMenu ui = new MainMenu();
		/*
		 * try { ui.start(); } catch (Exception e) { try { ui.start(); } catch
		 * (Exception e1) { try { ui.start(); } catch (Exception e2) { try {
		 * ui.start(); } catch (Exception e3) { System.out.println("nadoelo"); }
		 * } } }
		 */
		
		
		/*int counter = 1;
		while (true) {
			try {
				System.out.println("Попытка номер " + counter);
				ui.start();
				break;
			} catch (NeudachnikException e) {
				counter++;

			} catch (IOException e) {
				System.out.println("IOOOO");
			} catch (Exception e) {
				System.out.println("Плохое исключение, продожение попыток бесполензно");
			}
		}*/
		
		ui.start();

	}
}
