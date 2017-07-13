package examples21.spisok;

public class List {
	
	static private class Element {
	    public int value;
	    public Element next;
		public int get() {
			return value;
		}
		public void set(int value) {
			this.value = value;
		}
		public Element getNext() {
			return next;
		}
		public void setNext(Element next) {
			this.next = next;
		}
	}
	
	private int numbersOElements;
	private Element first = new Element();

	public int get(int position) {
		if (position < 0 || position > numbersOElements) {
			System.err.println("Wrong index");
			return -1;
		}

		Element current = first;
		for (int i = 1; i < position; i++) {
			current = current.getNext();
		}

		return current.value;
	}

	public boolean set(int value, int position) {
		if (position < 1 || position > numbersOElements) {
			return false;
		}

		Element current = first;
		for (int i = 1; i < position; i++) {
			current = current.next;
		}

		current.set(value);
		return true;
	}

	public boolean deleteByPosition(int position) {
		if (position < 1 || position > numbersOElements) {
			return false;
		}

		if (position == 1) {
			first = first.next;
			return true;
		}

		Element previous = first;

		for (int i = 1; i < position - 1; i++) {
			previous = previous.getNext();
		}

		Element current = previous.getNext();
		previous.setNext(current.getNext());
		numbersOElements--;
		return true;
	}

	public boolean deleteByValue(int value) {
		if (first.get() == value) {
			first = first.next;
			return true;
		}

		Element previous = first;
		while (previous.getNext() != null) {
			if (previous.getNext().get() == value) {
				break;
			}
			previous = previous.getNext();
		}

		if (previous.getNext() != null) {
			Element current = previous.getNext();
			previous.setNext(current.getNext());
			numbersOElements--;
			return true;
		}

		return false;
	}

	public void addFirst(int value) {
		if (numbersOElements == 0) {
			first.set(value);
			numbersOElements++;
			return;
		}
		Element current = new Element();

		current.set(value);
		current.setNext(first);
		first = current;
		numbersOElements++;
	}

	public void add(int value) {
		if (numbersOElements == 0) {
			first.set(value);
			numbersOElements++;
			return;
		}

		Element previous = first;
		Element current = new Element();
		while (previous.getNext() != null) {
			previous = previous.getNext();
		}
		previous.setNext(current);
		current.set(value);
		numbersOElements++;
	}

	public void addToPosition(int value, int position) {
		if (position < 0 || position > numbersOElements) {
			return;
		}

		if (numbersOElements == 0) {
			first.set(value);
			numbersOElements++;
			return;
		}

		Element previous = first;
		Element current = new Element();
		for (int i = 1; i < position - 1; i++) {
			previous = previous.getNext();
		}
		current.setNext(previous.getNext());
		previous.setNext(current);
		current.set(value);
		numbersOElements++;
	}

	public void print() {
		Element current = first;
		int counter = 0;
		System.out.print("[ ");
		while (current != null && numbersOElements != 0) {
			System.out.print(current.get());
			current = current.getNext();
			if (current != null) {
				System.out.print(" | ");
			}
			counter++;
			if (counter % 19 == 0) {
				System.out.println();
			}
		}
		System.out.print(" ]\n");
	}

	public void clear() {
		first = null;
		numbersOElements = 0;
	}

	public int length() {
		return numbersOElements;
	}

	public int[] toArray() {
		int[] array = new int[numbersOElements];
		Element current = first;

		for (int i = 0; i < array.length; i++) {
			array[i] = current.get();
			current = current.getNext();
		}

		return array;
	}

	public String toString() {
		String stroka = new String();
		Element current = first;

		for (int i = 0; i < numbersOElements; i++) {
			stroka += current.get();
			current = current.getNext();
		}

		return stroka;
	}

	public void sort() {
		int[] array = toArray();

		for (int j = 0; j < array.length - 1; j++) {
			int min = j;
			for (int i = j + 1; i < array.length; i++) {
				if (array[i] < array[min]) {
					min = i;
				}
			}
			// если j-ый элемент и так миимальный
			if (min != j) {
				int change = array[min];
				array[min] = array[j];
				array[j] = change;
			}
		}

		Element current = first;
		for (int i = 0; i < array.length; i++) {
			current.set(array[i]);
			current = current.getNext();
		}
	}
}