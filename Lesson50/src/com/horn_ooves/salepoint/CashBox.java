package com.horn_ooves.salepoint;

import java.util.LinkedList;
import java.util.Queue;

public class CashBox extends Thread {
	private static long idGenerator = 0;
	private long id = idGenerator++; 
	private double revenue = 0;
	private Queue<Customer> queue = new LinkedList<>();
	
	public int getQueueSize(){
		return queue.size();
	} 
	
	public void addCustomerToQueue(Customer c){
		queue.add(c);
	} 
	
	@Override
	public void run() {
		while (true) {
			Customer cust = queue.poll();
			if (cust == null) {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
				}
			} else {
				service(cust);
			}
		}
	}
	
	private void service(Customer c){
		System.out.println("box " + id + ": "
				+ "Обслуживаю покупателя: "
				+ "размер корзины = " 
				+ c.getGoods().size()
				+ "cust.id=" + c.id
				+ "В очереди за ним " + queue.size()
				+ " покупателей");
	}
}
