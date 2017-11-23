package com.horn_ooves.salepoint;

import java.util.LinkedList;
import java.util.Queue;

public class CashBox extends Thread {
	private static long idGenerator = 0;
	private long id = idGenerator++;
	private double revenue = 0;
	private Queue<Customer> queue = new LinkedList<>();

	public int getQueueSize() {
		return queue.size();
	}

	public void addCustomerToQueue(Customer c) {
		queue.add(c);
	}

	@Override
	public void run() {
		try {
			while (true) {
				Customer cust = queue.poll();
				if (cust == null) {

					Thread.sleep(2000L);

				} else {
					service(cust);
				}
			}
		} catch (InterruptedException e) {
		}
	}

	private void service(Customer c) throws InterruptedException {
		Thread.sleep(2000L);
		System.out.println("box " + id + ": " + "Обслуживаю покупателя: " + "размер корзины = " + c.getGoods().size()
				+ "cust.id=" + c.id + "В очереди за ним " + queue.size() + " покупателей");
	}
}
