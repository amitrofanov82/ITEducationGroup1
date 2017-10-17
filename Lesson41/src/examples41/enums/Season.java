package examples41.enums;

public class Season {
	//int seasonId; sposob1
	//String seasonAsString; sposob2
	
	public final static Season SPRING = new Season(0);
	public final static Season SUMMER = new Season(1);
	public final static Season AUTUMN = new Season(2);
	public final static Season WINTER = new Season(3);
	
	static String[] seasonNames = {"spring", "summer",
			"autumn","winter"};
	
	int uniqueIdentifier;
	
	private Season(int arrayIndex){
		uniqueIdentifier = arrayIndex;
	}
	
	
	
}
