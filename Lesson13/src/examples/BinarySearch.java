package examples;

public class BinarySearch {
	
	public static void main(String[] args) {
		int findMe = 8;
		int stepsCount = 0;
		int[] intArray = {1,2,3,4,5,6,7,9,10,11,12,13,14,15};
		int answer = -1;
		//boolean notFound = true;
		int index = (intArray.length-1)/2;
		System.out.println("First index = " + index);
		while(true) {
			stepsCount++;
			int newIndex = -1;
			if (findMe == intArray[index]){
				answer = index;
				break;
			}
			if (findMe < intArray[index]) {
				//уходим левее
				newIndex = index - (int)
						((intArray.length-1)/Math.pow(2, stepsCount+1));
				if (newIndex == index){
					newIndex--;
				}
				
			} else {
				//уходим правее
				newIndex = index + (int)
						((intArray.length-1)/Math.pow(2, stepsCount+1));
				if (newIndex == index){
					newIndex++;
				}
			}
			index = newIndex;
			System.out.println("New index = " + index);
		}
		System.out.println(answer);
		
	}
}
