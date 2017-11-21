package com.horn_ooves.salepoint;

public class SalesPointAdministrationApp {
	
	public static void main(String[] args) throws Exception {
		ProStore store = new ProStore();
		for (int i = 0; i < 100; i++) {
			Customer cust = new Customer();
			store.newCustomerReadyToBuy(cust);
			Thread.sleep(500);
		}
		while(!store.isEmpty()){
			Thread.sleep(1000L);
			System.out.println(store.getStatus());
		}
		System.out.println(store.getStatus());
	}
	
}
