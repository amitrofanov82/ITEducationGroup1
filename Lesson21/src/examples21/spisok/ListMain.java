package examples21.spisok;

public class ListMain {

    public static void main(String[] args) {
	List my = new List();

	my.print();

	for (int i = 0; i < 10; i++) {
	    my.add(i);
	}
	my.print();

	my.addFirst(177);
	my.print();

	my.addToPosition(56, 8);
	my.print();

	System.out.println("Element №5: " + my.get(5));

	my.set(17, 5);
	my.print();

	my.deleteByPosition(12);
	my.print();

	my.deleteByValue(6);
	my.print();

	System.out.println("Length: " + my.length());

	int[] array = my.toArray();
	Print.printArrayInt(array);

	String stroka = my.toString();
	Print.printString(stroka);

	my.sort();
	my.print();

	my.clear();
	my.print();
    }
}



























