package com.horn_ooves.salepoint;

public class Product {
	public int barCode;
	public double price;
	
	public Product(){
		barCode = (int )(Math.random()*100);
		price=barCode*"Svetlana".length()+0.5;
	}

}
