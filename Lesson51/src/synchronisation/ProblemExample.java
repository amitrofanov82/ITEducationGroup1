package synchronisation;

public class ProblemExample extends Thread{
	
	static /*volatile*/ long sharedResource = 0;
	public static final Object GUARDIAN1 = new Object();
	public static final Object GUARDIAN2 = new Object();
	
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		Thread t1 = new ProblemExample();
		t1.start();
		Thread t2 = new ProblemExample();
		t2.start();
		for (long i=0; i<60000000L; i++){
			synchronized(GUARDIAN1){
				sharedResource++;
			}
		}
		t1.join();
		t2.join();
		System.out.println(sharedResource);
	}
	
	@Override
	public void run() {
		for (long i=0; i<50000000L; i++){
			//synchronized(GUARDIAN1){
			synchronized(GUARDIAN2){
				sharedResource++;
			}
			//sharedResource++;
		}
	}
}










