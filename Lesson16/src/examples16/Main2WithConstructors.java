package examples16;

public class Main2WithConstructors {
	
	public static void main(String[] args) {
		Auto veryPowerfulAuto, veryWeakAuto;
		veryPowerfulAuto = new Auto("black", 1200);
		veryWeakAuto = new Auto("pink", 35);		
		Auto oneMoreAuto = new Auto();
		Auto autoNr4 = new Auto(veryWeakAuto);
		
		
		//Задача - создать 50 автомобилей со случайн. мощностью,
		//отсортировать и распечатать:
		Auto[] autopark = new Auto[50];
		//new String[50];
		for (int i = 0; i<autopark.length; i++ ){
			autopark[i] = new Auto();
		}
		printAutopark(autopark);
		
		for (int i = 0; i< autopark.length; i++){
			for (int j = i; j< autopark.length; j++){
				if (autopark[i].HorsePower < autopark[j].HorsePower){
					Auto temp = autopark[i];
					autopark[i] = autopark[j];
					autopark[j] = temp;
				}
			}
		}
		printAutopark(autopark);
		
		
		
		
	}

	private static void printAutopark(Auto[] autopark) {
		for (int i = 0; i<autopark.length; i++ ){
			//System.out.print(autopark[i] + " | "); 
			System.out.print(autopark[i].color + ": "
					+ autopark[i].HorsePower + " | ");
		}
		System.out.println();
	}

}
