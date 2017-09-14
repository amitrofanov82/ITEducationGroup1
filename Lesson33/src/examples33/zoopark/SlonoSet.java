package examples33.zoopark;

import examples33.zoopark.domain.Slon;

public class SlonoSet implements BeastSet<Slon> {
	
	private Slon[] stado = new Slon[1000];
	private int lastReturndSlonIndex = -1;
	private int size = 0;

	@Override
	public void add(Slon element) {
		if (contains(element)){
			System.out.println("Клонирвание слонов не поддерживается");
			return;
		}
		for (int i=0; i<stado.length; i++) {
			if (stado[i] == null){
				stado[i] = element;
				size++;
				return;
			}
		}
		System.out.println("Столько слонов в одну клетку не влазит");
	}

	@Override
	public void remove(Slon element) {
		if (element == null) {
			return;
		}
		for (int i=0; i<stado.length; i++) {
			if (stado[i] != null && stado[i].equals(element)) { // element.equals(s);
				stado[i] = null;
				size--;
				return;
			}
		}
	}

	@Override
	public boolean contains(Slon element) {
		if (element == null) {
			return true;
		}
		for (Slon s : stado) {
			if (s != null && s.equals(element)) { // element.equals(s);
				return true;
			}
		}
		return false;
	}

	@Override
	public Slon next() {
		//currentSlonIndex
		for (int i = lastReturndSlonIndex+1; i<stado.length; i++){
			if (stado[i] != null) {
				lastReturndSlonIndex = i;
				return stado[i];
			}
		}
		for (int i = 0; i<=lastReturndSlonIndex; i++){
			if (stado[i] != null) {
				lastReturndSlonIndex = i;
				return stado[i];
			}
		}
		return null;
	}
	
	public int getSize(){
		return size;
	}

}























