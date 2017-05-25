package teacher.homework.lesson8;

public class PereborGolov {

	public static void main(String[] args) {
		int headsNum = 202;
		long maxPower = -9999999L;
		for (int heads1 = 1; heads1<headsNum-2; heads1 ++ ){
			for (int heads2 = 1; heads2<headsNum-2; heads2 ++ ){
				for (int heads3 = 1; heads3<headsNum-2; heads3 ++ ){
					if (heads1 + heads2 + heads3 == headsNum){
						if (heads1*heads2*heads3>maxPower){
							maxPower = heads1*heads2*heads3;
							
						}
					}
				}
			}
		}
	}

}
