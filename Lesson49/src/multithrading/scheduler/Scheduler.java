package multithrading.scheduler;

public class Scheduler {
	AsyncTask task;
	
	public void executeTaskEvery10Sec(){
		System.out.println("планировщик стартовал");
		while(true){
			task.execute();
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				//do nothing
			}
		}
	}
	
	public void sayStatus(){
		System.out.println("I'm ok, что-то делаю");
	}
	
	public Scheduler(Action a){
		this.task = new AsyncTask(a);
	}
	
	private static class AsyncTask {
		Action task;
		
		void execute(){
			new Thread(){
				@Override
				public void run() {
					task.execute();
				}
			}.start();
		}
		
		AsyncTask(Action task){
			this.task = task;
		}
		
	}
}
