package examples33.zoopark;

import examples33.zoopark.domain.Beast;

public interface BeastSet<T extends Beast> {
	
	void add (T element);
	void remove (T element);
	boolean contains (T element);
	T next();
	int getSize();

}
