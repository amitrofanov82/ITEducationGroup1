package evroOpt.com.hornsAndHooves.sailPoint;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	Print print = new Print();
	Store evroopt = new Store(3, 10, print);
	evroopt.start();
	//evroopt.start();
	System.out.println(evroopt.getStatus());
	
	for (int i = 0; i < 100; i++) {
	    evroopt.customerCameIn();
	}
    }
}














