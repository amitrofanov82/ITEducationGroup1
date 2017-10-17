package examples41.enums.withoutenaums;

public class Season {
	
	public final static Season SPRING = new Season(0);
	public final static Season SUMMER = new Season(1);
	public final static Season AUTUMN = new Season(2);
	public final static Season WINTER = new Season(3);
	
	int uniqueIdentifier;
	
	private Season(int arrayIndex){
		uniqueIdentifier = arrayIndex;
	}
	
	
	
	
}
