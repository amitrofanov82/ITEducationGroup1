package multithrading.scheduler;

public class ForexPlatform {
	
	public static void main(String[] args) {
		Action a = new ForexCalculationAction();
		final Scheduler scheduler = new Scheduler(a);
		
		new Thread(){
			@Override
			public void run() {
				scheduler.executeTaskEvery10Sec();
			}
		}.start();
		
		
		scheduler.sayStatus();
		
		
		
		
		Thread t = Thread.currentThread();
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
