public class DragonBlankForItStep {
	private static int healthD;

	public final static int DRAGON_INIT_HEALTH = 200; 
	private static int atackD = 5;
	private static int healthK;
	private static int atackK;
	private static int B; 
	private static int D;
	
	
	public static void main(String[] args) {

		int turns = 0; //номер раунда
		int actionNumber;
		
		printCurrentstat(turns, healthD, atackD, healthK, atackK);
		boolean end = false;
		while (!end){

			switch (choosedAction()) {
			case 1: //выбрана атака\
				System.out.println("выбрана атака");
				healthK = healthK - atackD;
				break;
			case 2: //лечиться
				System.out.println("выбрана ...");
				healthD = DRAGON_INIT_HEALTH;
				break;
			case 3:
				System.out.println("выбрана ...");
				buff();
				break;
			case 4:	
				System.out.println("выбрана ...");
				debuff();
				break;
			default: //необязателен
				//"так, по задумке автора, не должно быть");
				//break; бессмысленен он здесь
			}
			//проверить не конец ли:
			if (healthK <=0) {
				System.out.println("Рыцарь живее всех живых");
				break;
			}

			knightAtack();
			
			if (turns > 2000) {
				System.out.println("Рыцарь отступил и вернулся к маме");
				break;
			}
			
		}
		//вывести результат
	}

	
	private static void knightAtack() {
		healthD = healthD - atackK;
	}


	private static int choosedAction() {
		return ((int) (Math.random() * 4)) + 1;
	}

	private static int buff() {
		//...
		return 0;	
	}

	private static int debuff() {
		//...
		return 0;	
	}
	
	private static void printCurrentstat(int turns, int healthD, int atackD, int healthK, int atackK) {
		//...
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}