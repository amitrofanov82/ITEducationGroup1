

import java.util.*;

public class PlatformerGame {
	private int position = 0;
	private int size = 2;
	private List llist = new LinkedList();
	private ListIterator it;
	
	PlatformerGame(int size, int position) {
		this.size = size;
		this.position = position;
		it = llist.listIterator();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private int отвалившиесяКирпичи = 0;
	public int jumps = 0;
	private int jumpPosition = 0;
	private int lastPosition = 0;
	int[] ListPosition;

	PlatformerGame(int size, int position) {
		this.size = size;
		this.position = position;
		ListPosition = new int[size];
		//ListPosition.put(position, position);
	}
	
	public int currentPosition() {
		return position;
	}

	public void jumpLeft() {
		int jumpsLeft = 2;
		int lastPosition = position;
		while (jumpsLeft!=0) {
			position--;
			if (position<0){
				if (size-отвалившиесяКирпичи<3){
					position=-100;
				} else {
					position = lastPosition;
				}
				jumps++;
				return;
			}
			if (ListPosition[position] == 0) {
				jumpsLeft--;
			}
		}
		ListPosition[lastPosition] = 1; 
		отвалившиесяКирпичи++;
		jumps++;
	}
	
	public void jumpRight() {
		int jumpsLeft = 2;
		int lastPosition = position;
		while (jumpsLeft!=0) {
			position++;
			if (position>=size){
				if (size-отвалившиесяКирпичи<3){
					position=-100;
				} else {
					position = lastPosition;
				}
				jumps++;
				return;
			}
			if (ListPosition[position] == 0) {
				jumpsLeft--;
			}
		}
		ListPosition[lastPosition] = 1; 
		отвалившиесяКирпичи++;
		jumps++;
	}
	
	/*
	private Map<Integer, Integer> ListPosition = new HashMap<Integer, Integer>();
	
	public void jumpLeft() {
		jumps++;
		lastPosition = position;
		while (true) {
			position--;
			if (ListPosition.get(position) == null) {
				jumpPosition++;
				if ((jumpPosition == 2) && position >= 0) {
					jumpPosition = 0;
					ListPosition.put(position, position);
					break;
				} else if (position < 0) {
					jumpPosition = 0;
					position = lastPosition;
					if (ListPosition.size() == size) {
						System.out.println("Больше невозможно прыгать влево и в право!");
						position = -100;
					} else {
						System.out.println("Попробуйте прыгнуть вправо! Остались на месте!");
					}
					break;
				}
			}
		}
	}

	
	public void jumpRight() {
		jumps++;
		lastPosition = position;
		while (true) {
			position++;
			if (ListPosition.get(position) == null) {
				jumpPosition++;
				if (jumpPosition == 2 && position <= size) {
					jumpPosition = 0;
					ListPosition.put(position, position);
					break;
				} else if (position > size) {
					jumpPosition = 0;
					position = lastPosition;
					if (ListPosition.size() == size) {
						System.out.println("Больше невозможно прыгать вправо и влево!");
						position = -100;
					} else {
						System.out.println("Попробуйте прыгнуть влево! Остались на месте!");
					}
					break;
				}
			}
		}
	}*/

}
