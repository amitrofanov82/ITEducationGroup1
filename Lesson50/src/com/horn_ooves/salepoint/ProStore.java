package com.horn_ooves.salepoint;

import java.util.ArrayList;
import java.util.List;

public class ProStore {
	private List<CashBox> cashBoxes;
	private Stock stock;
	
	public ProStore(){
		stock = new Stock();
		cashBoxes = new ArrayList<>(3);
		for (int i =0; i<4; i++){
			CashBox c = new CashBox();
			cashBoxes.add(c);
			c.start();
		}
		System.out.println("Магазин открылся");
	}
	
	public void newCustomerReadyToBuy(Customer cust) throws Exception {
		cust.chooseGoods(stock);
		cust.chooseCashBox(cashBoxes);
		/*for (CashBox c : cashBoxes) {
			c.service();
		}*/
	}

	public boolean isEmpty() {
		return true;
	}

	public String getStatus() {
		return "Not ready";
	}
	
}
