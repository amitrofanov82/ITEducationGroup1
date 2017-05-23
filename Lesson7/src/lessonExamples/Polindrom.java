package lessonExamples;

public class Polindrom {

	
	public static void main(String[] args){
		int polindrom = 123321;
		int notPolindrom = 123121;
		
		System.out.println(digitsInNumber(polindrom));
		System.out.println(findDititByIndex(polindrom, 
					5, digitsInNumber(polindrom))
				);
		
		
		
		
		
		//определить число цифр - готово
		//цикл:
			//сравнить i-ую справа и i-ую слева
		    //если всегда были равны, то полиндром (нужен флаг)
		    //если не равны - конец цикла, ответ отрицательный
	}
	
	
	private static int digitsInNumber(int number){
		int counter = 0;
		if (number == 0) {
			return 1;
		}
		while (number !=0) {
			number = number/10;
			counter++;
		}
		
		return counter;
	}
	
	private static int findDititByIndex(int number ,
			              int index, int digitsNumber){
		number = number / (int) (Math.pow(10, index));
		
		return number % 10;
	}
	
	

}
