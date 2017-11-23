package evroOpt.com.hornsAndHooves.sailPoint;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

public class CashBox extends Thread {
	private final long SPEED = (long) (Math.random() * 5000 + 500);
	private final long SLEEP_TIME = (long) (Math.random() * 3000 + 3000);
	private static int ids = 0;
	private int id = ++ids;
	private Queue<Customer> queue = new LinkedList<>();
	private Store store;
	private Print print;
	private int countOfBuyers = 0;

	public CashBox(Store store, Print print) {
		this.print = print;
		this.store = store;
	}

	@Override
	public void run() {
		while (!this.isInterrupted()) {
			Customer cust = queue.poll();
			if (cust != null)
				service(cust);
			else {
				print.println("Free cash " + id + "!");
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getQueueSize() {
		return queue.size();
	}

	public void addCustomerToQueue(Customer customer) {
		queue.add(customer);
	}

	public void removeCustomerFromQueue(Customer customer) {
		queue.remove(customer);
	}

	public void service(Customer cust) {
		print.println("Box " + id + " serves the buyer № " + cust.getId() + ". Не нas " + cust.itemsInCart()
				+ " goods. After him in the queue  are " + queue.size() + " buyers");
		Map<Product, Integer> goods = cust.getGoods();
		Set<Entry<Product, Integer>> set = goods.entrySet();
		for (Map.Entry<Product, Integer> me : set) {
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			double earnings = me.getKey().getPrice() * me.getValue();
			store.revenue = store.revenue + earnings;
		}
		store.getCustomers().remove(cust);
		++countOfBuyers;
	}

	@Override
	public String toString() {
		return "№: " + id + ". Queue: " + getQueueSize();
	}

	public int getCountOfBuyers() {
		return countOfBuyers;
	}

	public long getId() {
		return id;
	}
}


















