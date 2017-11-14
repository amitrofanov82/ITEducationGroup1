package artifact48;

public class Thread2 extends Thread {

	@Override
	public void run() {
		while(true) {
			if (Math.random()<1/*0.00000005*/){
				System.out.println("2 alive");
			}
		}
	}
	
	
}
