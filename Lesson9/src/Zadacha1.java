//вывести на экран все четные числа в массиве
public class Zadacha1 {
	
	public static void main(String[] args) {
		int peremena[]={1, 2, 3, 4, 257, 374, 7654, 2, 87, 13 };
		
		for(int i=0; i < peremena.length; i++ ){
			if (peremena[i]%2==0){
				System.out.println(peremena[i]);
			}
		}
		
	}
}
