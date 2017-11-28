package store;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	Print print = new Print();
	Store evroopt = new Store(3, 3, print);
	evroopt.start();
	System.out.println(evroopt.getStatus());
	
	for (int i = 0; i < 10; i++) {
	    evroopt.customerCameIn();
	}
    }
}