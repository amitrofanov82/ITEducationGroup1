package store;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {
	private List<CashBox> boxes;
	private Print print;
	private Stock range;
	private List<Customer> customers;
	private boolean customerInside = false;
	public volatile double revenue = 0;
	private boolean storeOpen = true;

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
		range = new Stock(rangeVariety);
		customers = new ThreadSafeArrayList();
	}

	@Override
	public void run() {
		while (storeOpen) {
			if (customerInside && customers.size() == 0) {
				storeOpen = false;
				revenuePrint();
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
	 * 
	 */
	private void revenuePrint() {
		revenue *= 100;
		revenue = Math.round(revenue);
		print.println("total revenue: " + revenue / 100.0);
	}

	public void customerCameIn() {
		Customer c = new Customer(range, boxes);
		customers.add(c);
		c.start();
		if (!customerInside)
			customerInside = true;
	}

	public boolean isEmpty() {
		return range.isEmpty();
	}

	public String getStatus() {
		String out = "Customers:\n" + customers.toString() + "\n";
		out += "CashBoxes:\n" + boxes.toString() + "\n";
		return out + "\n" + range.toString();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<CashBox> getBoxes() {
		return boxes;
	}

	public Stock getRange() {
		return range;
	}

	public boolean isStoreOpen() {
		return storeOpen;
	}
}