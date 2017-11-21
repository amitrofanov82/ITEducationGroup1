package com.horn_ooves.salepoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
	private static long idGenerator = 0;
	public long id = idGenerator++; 
	private Map<Product, Integer> goods = new HashMap();

	public void chooseGoods(Stock stock){
		for (int i =0; i<id%10; i++){
			Product choice = stock.getRandomProd();
			goods.put(choice, 1);
		}
	}

	public void chooseCashBox(List<CashBox> cashBoxes) {
		int min = cashBoxes.get(0).getQueueSize();
		for (CashBox c : cashBoxes) {
			if (c.getQueueSize() == 0) {
				c.addCustomerToQueue(this);
				return;
			}
			if (c.getQueueSize() < min) {
				min = c.getQueueSize();
			}
		}
	}

	public Map<Product, Integer> getGoods() {
		return goods;
	}
}
