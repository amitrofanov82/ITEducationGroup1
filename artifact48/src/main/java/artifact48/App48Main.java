package artifact48;

public class App48Main {
	
	public static void main(String[] args) throws InterruptedException {
		final Thread t2 = new Thread2();
		t2.start();
		
		Thread t3 = new Thread(new Runnable(){
			public void run() {
				while(true) {
					if (Math.random()<1/*0.00000005*/){
						System.out.println("3 alive");
						t2.start();
					}
				}
			}
		});
		t3.start();
		
		Thread t4 = new Thread(new MyRunnable());
		while(true) {
			if (Math.random()<100/*0.00000005*/){
				System.out.println("Main thread alive");
				t4.start();
			}
		}
		
		
	}
}
