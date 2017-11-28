package store;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Stock {
	private Map<Product, Integer> stock;

	public Stock(int amount) {
		stock = new Hashtable<Product, Integer>();
		for (int i = 0; i < amount; i++) {
			stock.put(new Product(), (int) (Math.random() * 900) + 100);
		}
	}

	public boolean isEmpty() {
		return stock.isEmpty();
	}

	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		Set<Entry<Product, Integer>> set = stock.entrySet();
		for (Map.Entry<Product, Integer> me : set) {
			out.append(me.getKey() + ". Amount: ");
			out.append(me.getValue() + "\n");
		}
		return out.toString();
	}

	public Map<Product, Integer> getStock() {
		return stock;
	}
}