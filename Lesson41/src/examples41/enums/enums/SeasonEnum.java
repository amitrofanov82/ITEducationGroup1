package examples41.enums.enums;

public enum SeasonEnum {

	SPRING("march"), SUMMER("june"), AUTUMN, WINTER;
	
	String pervyjMesjac;

	SeasonEnum(String firstMonth){
		pervyjMesjac=firstMonth;
	}
	
	SeasonEnum(){
		pervyjMesjac="unknown";
	}
	
	public String sayWeather() {
		switch (this) {
		case SPRING:
			return "rainy";
		case SUMMER:
			return "hot";
		case AUTUMN:
			return "terrible";
		case WINTER:
			return "freeze";
		default:
			return "impossible";
		}
	}
	
	
	
	

}
