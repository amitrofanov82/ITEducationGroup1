import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class amazing1 {
	public static void main(String[] args) {
		
	}
	
	public static List<List<Integer>> findCrates(int cratesNum,  
			List<List<Integer>> crateCoords, int truckCapacity){
		//1. Для каждой пары координат считаем сумму квадратов 
		//	 и сравниваем со следующей. 
		//   Пару координат, что ближе кидаем грузовик  
		//2. Сравниваем М с текущим значением. 
		//3. Повотряем. 
		
		//1. Считаем сумму квадратов координат для всех ящиков. Сортируем.
		
		crateCoords.sort(new CrateComparator());
		return crateCoords.subList(0, truckCapacity);
	}
	
	private static class CrateComparator implements Comparator<List<Integer>> {

		@Override
		public int compare(List<Integer> crate1, List<Integer> crate2) {
			int x1 = crate1.get(0);
			int y1 = crate1.get(1);
			int x2 = crate2.get(0);
			int y2 = crate2.get(1);
			return ((x1*x1+y1*y1) - (x2*x2+y2*y2));
		}
		
	}
}


