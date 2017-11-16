package multithrading.scheduler;

public class ForexCalculationAction extends Action {

	@Override
	public void execute() {
		System.out.println("Считаю курс доллара...");
		try {
			Thread.sleep((long) (Math.random()*12000));
		} catch (InterruptedException e) {
			//nothing
		}
		System.out.println("Доллар сейчас = " + Math.random());
	}

}
