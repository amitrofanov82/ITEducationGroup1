package com.horn_ooves.salepoint;

import java.util.ArrayList;
import java.util.List;

public class ProStore {
	private List<CashBox> cashBoxes;
	private Stock stock;
	
	public ProStore(){
		stock = new Stock();
		cashBoxes = new ArrayList<>(3);
		for (int i =0; i<1; i++){
			CashBox c = new CashBox();
			cashBoxes.add(c);
			c.start();
		}
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
