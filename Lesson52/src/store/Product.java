package store;

import java.util.HashSet;

public class Product {
    private static HashSet<Integer> codes = new HashSet<>();
    private int vendorCode;
    private double price;
    private double weigth;

    public Product() {
	do {
	    vendorCode = (int) (Math.random() * 1000000);
	} while (!codes.add(vendorCode));
	
	price = (int)((Math.random() * 10 + 0.5) * 100) / 100.0;
	weigth = Math.random() * 10 + 0.1;
    }
    
    public int getVendor() {
	return vendorCode;
    }
    
    public double getPrice() {
	return price;
    }
    
    public double getWeigth() {
	return weigth;
    }

    @Override
    public String toString () {
	return "Product № " + vendorCode + ". Price: " + price;
    }
}