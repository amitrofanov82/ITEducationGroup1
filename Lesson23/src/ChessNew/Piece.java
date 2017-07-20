package ChessNew;

public abstract class Piece {
	public static final boolean WHITE = true;
	public static final boolean BLACK = false;
	
	private final String name;
	private final boolean color;
	

	public String getName() {
		return name;
	}
	
	public Piece(String name, boolean color) {
		this.name = name;
		this.color = color;
	}
	
	public Piece(){
		name="";
		color = true;
	};
	
	public abstract boolean checkMove(int startX, int intintstartY, 
			int finishX, int finihY, Board board);

	public boolean isColor() {
		return color;
	}
	
}
