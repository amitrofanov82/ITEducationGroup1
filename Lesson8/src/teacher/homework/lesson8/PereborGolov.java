package teacher.homework.lesson8;

public class PereborGolov {

	public static void main(String[] args) {
		int headsNum = 100; //головы
		long maxPower = -9999999L; // power
		for (int heads1 = 1; heads1<headsNum-2; heads1 ++ ){ //цикл по первой голове
			for (int heads2 = 1; heads2<headsNum-2; heads2 ++ ){ //цикл по второй головек		
				for (int heads3 = 1; heads3<headsNum-2; heads3 ++ ){ //цикл по третьей голове (рассм-ем все комюбинации)
					if (heads1 + heads2 + heads3 == headsNum){ // можно удалить по третье голове написать 3=общее-1-2
						if (heads1*heads2*heads3>maxPower){
							maxPower = heads1*heads2*heads3; //обновляем максимум
							
						}
					}
				}
			}
		}
	}

}
