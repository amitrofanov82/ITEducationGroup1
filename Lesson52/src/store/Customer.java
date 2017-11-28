package store;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Customer extends Thread {
    private static int ids = 0;
    private final long decisionMaking = (long) (Math.random() * 3000 + 500);
    private final int maxWeight = (int) (Math.random() * 20 + 10);
    private final double cash = Math.random() * 100;
    private int id = ++ids;
    private Map<Product, Integer> range;
    private List<CashBox> boxes;
    private Map<Product, Integer> goods = new HashMap<Product, Integer>();
    private CashBox chosenBox;

    public Customer (Stock stock, List<CashBox> boxes) {
	range = stock.getStock();
	this.boxes = boxes;
    }

    @Override
    public void run () {
	chooseGoods();
	try {
	    Thread.sleep(decisionMaking);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	chooseCashBox();
    }

    private void chooseGoods () {
	double amount = Math.random() * range.size();
	for (int i = 0; i < amount; i++) {
	    try {
		Thread.sleep(decisionMaking);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    getRandomProduct();
	}
    }

    private void getRandomProduct () {
	int amount = (int) (Math.random() * 5 + 1);
	int randomIndex = (int) (Math.random() * range.size());

	Iterator<Product> it = range.keySet().iterator();
	for (int i = 0; i < randomIndex; i++) {
	    it.next();
	}
	Product result = it.next();
	int number = range.get(result);

	while (!buyerIsAble(result, amount)) {
	    amount--;
	}
	if (amount < 1) return;

	if (number < amount) {
	    range.remove(result);
	    goods.put(result, number);
	} else {
	    range.put(result, number - amount);
	    goods.put(result, amount);
	}
    }

    private boolean buyerIsAble (Product result, int amount) {
	if (cash < result.getPrice() * amount) { return false; }
	if (maxWeight < result.getWeigth() * amount) { return false; }
	return true;
    }

    private void chooseCashBox () {
	int min = 0;
	for (int i = 1; i < boxes.size(); i++) {
	    if (boxes.get(i).getQueueSize() == 0) {
		boxes.get(i).addCustomerToQueue(this);
		return;
	    }
	    if (boxes.get(i).getQueueSize() + 2 < boxes.get(min).getQueueSize()) min = i;
	}
	chosenBox = boxes.get(min);
	chosenBox.addCustomerToQueue(this);
    }

    @Override
    public String toString () {
	return "№: " + id + ". Items in the cart: " + itemsInCart();
    }

    public int itemsInCart () {
	Collection<Integer> amount = goods.values();
	int sum = 0;
	for (Integer i : amount) {
	    sum += i;
	}
	return sum;
    }

    public long getId () {
	return id;
    }

    public Map<Product, Integer> getGoods () {
	return goods;
    }
}