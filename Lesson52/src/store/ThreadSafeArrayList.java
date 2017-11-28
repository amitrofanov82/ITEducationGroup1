package store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ThreadSafeArrayList implements List<Customer> {

	private List innerUnsafeList = new ArrayList<Customer>();
	
	@Override
	public int size() {
		return innerUnsafeList.size();
	}

	@Override
	public boolean isEmpty() {
		return innerUnsafeList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return innerUnsafeList.contains(o);
	}

	@Override
	public Iterator<Customer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Customer e) {
		synchronized (this) {
			return innerUnsafeList.add(e);
		}
	}

	@Override
	public boolean remove(Object o) {
		synchronized (innerUnsafeList) {
			return innerUnsafeList.remove(o);
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Customer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Customer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer set(int index, Customer element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Customer element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Customer> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Customer> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
