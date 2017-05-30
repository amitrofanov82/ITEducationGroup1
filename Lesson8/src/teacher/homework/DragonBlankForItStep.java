package teacher.homework;

public class DragonBlankForItStep {
	// Ёто будет следующей новой темой. —ейчас не нужно:
	private static int healthD;
	//public static int initHealthD; //так не стоит тут делать
	public final static int DRAGON_INIT_HEALTH = 200; //так не стоит тут делать
	private static int atackD = 5;
	private static int healthK;
	private static int atackK;
	private static int B; 
	private static int D;
	
	
	public static void main(String[] args) {
		System.out.println(Math.PI);
		int atackD = 7;
		System.out.println(atackD);
		for (;true;){
			int atackD = 7;
		}
		/*int healthD = 0; //задать значени€ из задани€
		int atackD = 0;
		int healthK = 0;
		int atackK = 0;
		int B = 0;
		int D = 0;*/
		int turns = 0; //номер раунда
		int actionNumber;
		
		printCurrentstat(turns, healthD, atackD, healthK, atackK);
		boolean end = false;
		while (!end){
			//actionNumber = choosedAction(healthD, atackD, healthK, atackK, B, D);
			/*//ниже было бы удобнее switch(actionNumber){}, но это тоже будет новой темой. — ифами тоже всЄ можно сделать:
			if (actionNumber == 1) { //например 1 значит, что выбран удар по рыцарю. ј 2 - что дракон решил излечитьс€
				//...
			}
			if (actionNumber == 2) {
				//...
			}
			if (actionNumber == 3) {
				//...
			}
			if (actionNumber == 4) {
				//...
			}*/
			
			//switch (actionNumber) {
			switch (choosedAction()) {
			case 1:
				//ударить
				break;
			case 2:
				//лечитьс€
				break;
			case 3:
				//баф
				break;
			case 4:	
				//дебаф
				break;
			default: //необ€зателен
				System.out.println("так, по задумке автора, не должно быть");
				//break; бессмысленен он здесь
			}
			
			//проверить не конец ли...
			//healthD = knightAtack(healthD, atackK);
			knightAtack();
			
			//...
			//if (turns > 2000) break; вдруг у вас зациклитс€, что долго никто не помирает.
		}
		//вывести результат
	}

	/* C++ example:
	 * private static int +(int healthD, int atackK) {
		//...
		return 0;
	}*/

	private static int knightAtack(int healthD, int atackK) {
		//...
		return 0;
	}
	
	private static void knightAtack() {
		//... 
	}


	private static int choosedAction() {
		//...
		return 0;
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
	
	