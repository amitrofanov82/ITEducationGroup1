package examples26.generics;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListMain {
	
	private static class Elephant {
		public int hobot = (int) (Math.random()*50);

		@Override
		public String toString() {
			return "I'm Elephant with size = " + hobot + ". ";
		}

	}
	
	private static class ElephantComparator 
	      implements Comparator<Elephant> {
		
		private int order  = 1;
		
		public ElephantComparator(int order) {
			this.order = order;
		}

		@Override
		public int compare(Elephant o1, Elephant o2) {
			if (o1.hobot > o2.hobot ) {
				return 1*order;
			} else if (o1.hobot == o2.hobot) {
				return 0;
			} else {
				return -1*order;
			}
		}

	}
	
	public static void main(String[] args) {
		List<Elephant> stado = new LinkedList<Elephant>();
		for (int i=0; i<10; i++) {
			stado.add(new Elephant());
		}
		stado.sort(new ElephantComparator(-4));
		System.out.println(stado);
	}
	
	static int hobotSum(Iterable<? extends Elephant> stado) {
		
		
		return 0;
	}	
}
