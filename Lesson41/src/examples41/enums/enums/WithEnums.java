package examples41.enums.enums;

public class WithEnums {

	public static void main(String[] args) {
		reactOnWeather4(SeasonEnum.SPRING);
	}

	public static void reactOnWeather4(SeasonEnum yearSeason) {
		if (yearSeason.equals(SeasonEnum.SPRING)) {
			System.out.println("dozdlivo");
			return;
		}
		for (SeasonEnum season : SeasonEnum.values()){
			if (yearSeason.equals(SeasonEnum.SPRING)) {
				System.out.println("Вы перадали мне весну");
			} 
		}
	}
	
	public static void examplesWithEnumAdditionaMethods(SeasonEnum yearSeason) {
		SeasonEnum.valueOf("SPRING");
		//Один абсолютно бесполезный метода
		SeasonEnum.valueOf(SeasonEnum.class, "SPRING");
		SeasonEnum.values();
		
		SeasonEnum someSeason = SeasonEnum.AUTUMN;
		SeasonEnum otherSeason = SeasonEnum.SPRING;
		someSeason.compareTo(otherSeason); //AUTUMN>SPRING
		someSeason.equals(otherSeason);//false
		someSeason.name();//"AUTUMN"
		someSeason.toString();//тоже самое что name
		someSeason.ordinal(); //2, номер в перечислении с нуля

		String weather = someSeason.sayWeather();
		System.out.println(weather);
		
		
		
		
		
	}
	
}
