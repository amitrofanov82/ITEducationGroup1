package examples41.enums.enums;

public class WithoutEnums {

	public static void main(String[] args) {

	}

	public static void reactOnWeather4(SeasonEnum yearSeason) {
		if (yearSeason.equals(SeasonEnum.SPRING)) {
			System.out.println("dozdlivo");
			return;
		}
		// .....
	}
}
