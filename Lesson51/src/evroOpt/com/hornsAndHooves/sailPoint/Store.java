package evroOpt.com.hornsAndHooves.sailPoint;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {
	private List<CashBox> boxes;
	private Print print;
	private Stock sklad;
	private List<Customer> customers;
	private boolean weHaveCustomers = false;
	public double revenue = 0;

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while (true) {
			if (!weHaveCustomers && customers.size() > 0) {
				weHaveCustomers = true;
			}
			if (weHaveCustomers && customers.size() == 0) {
				for (CashBox c : boxes) {
					print.println("CashBox №" + c.getId() + " has " + c.getCountOfBuyers() + " buyers");
					c.interrupt();
				}
				revenue *= 1000;
				revenue = Math.round(revenue);
				print.println("total revenue: " + revenue / 1000.0);
				print.println("Store closed");
				print.println(getStatus());
				break;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param cashBoxAmount
	 *            - Количество касс
	 * @param rangeVariety
	 *            - разнообразие ассортимента в единицах
	 * @param print
	 */
	public Store(int cashBoxAmount, int rangeVariety, Print print) {
		this.print = print;
		boxes = new ArrayList<>();
		for (int i = 0; i < cashBoxAmount; i++) {
			CashBox box = new CashBox(this, print);
			boxes.add(box);
			box.start();
		}
		sklad = new Stock(rangeVariety);
		customers = new ArrayList<>();
	}

	public void customerCameIn() {
		Customer c = new Customer(sklad, boxes);
		customers.add(c);
		c.start();
	}

	public boolean isEmpty() {
		return sklad.isEmpty();
	}

	public String getStatus() {
		String out = "Customers:\n" + customers.toString() + "\n";
		out += "CashBoxes:\n" + boxes.toString() + "\n";
		return out + "\n" + sklad.toString();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<CashBox> getBoxes() {
		return boxes;
	}

	public Stock getRange() {
		return sklad;
	}
}




















