package com.horn_ooves.salepoint;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Stock {
	private Map<Product, Integer> sklad = new HashMap();

	public Map<Product, Integer> getGoods() {
		return sklad;
	}
	
	public Stock(){
		Product p = new Product();
		p.barCode = 1000000;
		p.price = 10.3;
		sklad.put(p, 1000);
	}

	public Product getRandomProd() {
		Set<Product> productSet = sklad.keySet();
		int productsAmt = productSet.size();
		int randomIdx = (int) (Math.random()*productsAmt);
		Iterator<Product> it = productSet.iterator();
		for (int i=0; i<randomIdx; i++){
			it.next();
		}
		Product result = it.next();
		int amount = sklad.get(result);
		amount--;
		if (amount > 0) {
			sklad.put(result, amount);
		} else{
			sklad.remove(result);
		}
		return result;
	}
}
