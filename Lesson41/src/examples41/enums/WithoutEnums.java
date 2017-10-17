package examples41.enums;

public class WithoutEnums {
	


	public static void main(String[] args) {
		reactOnWeather1("zima");
		reactOnWeather2(SeasonConstants.WINTER); //sposob 2
		reactOnWeather2("wesna"); //sposob 2 не страхует от такой ошибки
		reactOnWeather3(SeasonConstants.SPRINGI); //sposob 3 
		reactOnWeather3(101); //тоже самое
		reactOnWeather4(Season.SUMMER); //Best sposob
		
	}
	
	public static void reactOnWeather1(String yearSeason){ 
		if (yearSeason.equals("vesna")){
			System.out.println("dozdlivo");
			return;
		}
		if (yearSeason.equals("vesna")){
			System.out.println("zharko");
			return;
		}		
		if (yearSeason.equals("vesna")){
			System.out.println("syro");
			return;
		}
		if (yearSeason.equals("vesna")){
			System.out.println("I wanna die");
			return;
		}		
	}

	public static void reactOnWeather2(String yearSeason){ 
		if (yearSeason.equals(SeasonConstants.SPRING)){
			System.out.println("dozdlivo");
			return;
		}
		if (yearSeason.equals(SeasonConstants.SUMMER)){
			System.out.println("zharko");
			return;
		}		
		if (yearSeason.equals(SeasonConstants.AUTUMN)){
			System.out.println("syro");
			return;
		}
		if (yearSeason.equals(SeasonConstants.WINTER)){
			System.out.println("I wanna die");
			return;
		}		
	}
	
	public static void reactOnWeather3(int yearSeason){ 
		if (yearSeason == SeasonConstants.SPRINGI){
			System.out.println("dozdlivo");
			return;
		}
		if (yearSeason==SeasonConstants.SUMMERI){
			System.out.println("zharko");
			return;
		}		
		if (yearSeason==SeasonConstants.AUTUMNI){
			System.out.println("syro");
			return;
		}
		if (yearSeason==SeasonConstants.WINTERI){
			System.out.println("I wanna die");
			return;
		}		
	}
	
	public static void reactOnWeather4(Season yearSeason){ 
		if (yearSeason.equals(Season.SPRING)){
			System.out.println("dozdlivo");
			return;
		}
		//.....
	}
}
