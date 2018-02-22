

import java.util.*;

public class LinkedListGame implements Runnable{

	private int position = 0;
	private int size = 2;
	private int jumpPosition = 0;
	private int lastPosition = 0;
	private Object IterPosition = null;
	private LinkedList<Integer> ListPosition = new LinkedList<Integer>();
	private Iterator<Integer> iter = ListPosition.iterator();
	private Iterator<Integer> deIter = ListPosition.descendingIterator();

	LinkedListGame(int size, int position) {
		this.size = size;
		this.position = position;
		for (int i = 0; i <= size; i++) {
			ListPosition.add(i);
		}

	}

	public void jumpLeft() {
		lastPosition = position;
		lastPosition--;
		while (deIter.hasNext()) {
			IterPosition = deIter.next();
			if (IterPosition.equals(ListPosition.get(lastPosition))) {
				jumpPosition++;
				if (jumpPosition == 2) {
					jumpPosition = 0;
					ListPosition.remove(lastPosition);
					ListPosition.remove(position);
					break;
				}
			}
		}
		if (lastPosition < 0) {
			System.out.println("Net hoda v levo!");
		}else if (lastPosition < 0 && ListPosition.size()>size) {
			System.out.println("Hodov bolshe net!");
			position=-100;
		}
	}

	
	
	public void jumpRight() {
		lastPosition = position;
		lastPosition++;
		while (iter.hasNext()) {
			IterPosition = iter.next();
			if (IterPosition.equals(ListPosition.get(lastPosition))) {
				jumpPosition++;
				if (jumpPosition == 2) {
					jumpPosition = 0;
					ListPosition.remove(lastPosition);
					ListPosition.remove(position);
					break;
				}
			}
		}
		if (lastPosition < 0) {
			System.out.println("Net hoda v levo!");
		}else if (lastPosition < 0 && ListPosition.size()>size) {
			System.out.println("Hodov bolshe net!");
			position=-100;
		}
	}

	public int currentPosition() {
		return position;
	}

	
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
