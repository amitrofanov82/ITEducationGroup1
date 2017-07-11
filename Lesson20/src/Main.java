///одно существенное замечание и 2 незначительных
public class Main {

	public static void main(String[] args) {
		String username = null;
		
		while ((username = newUser()) != null){
			TamagochiUI ui = new TamagochiUI(username);
			ui.startGame();
		}

    }

	private static String newUser() {
		// TODO Auto-generated method stub
		return null;
	}
}

















