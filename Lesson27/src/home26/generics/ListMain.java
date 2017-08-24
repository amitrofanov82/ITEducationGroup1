package home26.generics;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListMain {
	
	private static class Elephant implements Comparator<Elephant> {
		public int hobot = (int) (Math.random()*50);

		@Override
		public String toString() {
			return "I'm Elephant with size = " + hobot + ". ";
		}

		@Override
		public int compare(Elephant o1, Elephant o2) {
			if (o1.hobot > o2.hobot ) {
				return 1;
			} else if (o1.hobot == o2.hobot) {
				return 0;
			} else {
				return -1;
			}
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
		/*Comparator<Elephant> c = new Comparator<Elephant>(){

			@Override
			public int compare(Elephant o1, Elephant o2) {
				return (int) (Math.random()*10) - 5;
			}
			
		};*/
		stado.sort(new Comparator<Elephant>(){
			private int order = (int) (Math.random()*10) - 5;
			
			{
				
			}
			
			/*static {
				
			}*/
			
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
			
		});
		
		stado.sort( (o1, o2) -> {
			if (o1.hobot > o2.hobot ) {
				return 1;
			} else if (o1.hobot == o2.hobot) {
				return 0;
			} else {
				return -1;
			}	
		});
		
		
		System.out.println(stado);
	}
	
	static int hobotSum(Iterable<? extends Elephant> stado) {
		
		
		return 0;
	}	
}



























