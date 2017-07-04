package examples18.playdog.model;

public class Dog {
	public static final int MEAT = 0;
	public static final int FISH = 1;
	public static final int CAT_FLESH = 2;
	public static final int SOUP = 3;
	
	public int dlinaHvosta = (int) (Math.random()*21 + 1);
	private int hungryness = 50;
	public String name;
	private int happiness = 50;
	public String breed;
	
	public Dog(String name) {
		this.name = name;
		happiness = 70;
	}
	
	public Dog() {
	}
	
	public void feed (int foodType, double foodMass){
		
		switch (foodType){
		case MEAT: //мясо
			if (foodMass > 3) {
				foodMass = 3;
			}
			hungryness = hungryness - 100;
			if (hungryness < 0) {
				hungryness = 0;
			}
			happiness = happiness + 40;
			if (happiness > 100) {
				hungryness = 100;
			}
			System.out.println("master, I love you");
			dlinaHvosta++;
			break;
		case FISH: //рыба
			break;
		case CAT_FLESH: //кошка
			break;
		case SOUP: //суп
			hungryness += 10;
			if (hungryness >=100) {
				//смерть 
			}
			happiness -=20;
			System.out.println("master, you don't lave me anymore :(");
			break;
		default:
			System.out.println("Dont know such food type");
		}
	}
	
	public String howAreYou(){
		if (hungryness > 90){
			return "I'm to die soon, feed me please";
		}
		if (happiness < 10){
			return "I hate you bastard";
		}
		return "Not so bad";
	}
	
	public void printStatus(){
		System.out.println("happiness:" + happiness
				+ "hungryness:"  + hungryness );
	}
	
}
