package l53;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.HashSet;

public class Product implements Serializable /*Externalizable*/ {
	private static final long serialVersionUID = 12345663543L;
	
	private static HashSet<Integer> codes = new HashSet<>();
    private int vendorCode;
    transient private double price;
    private double weigth;
    transient String s;

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


	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(new byte[100]);
		//out.close();
	}


	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		int i = in.readInt();
		//....
		
	}
}