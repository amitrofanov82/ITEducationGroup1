package specialtasks.edinorog;

public class TaskResolver {

	public static String resolveOneCase(String caseInput) {
		//e.g. caseInput = 6 2 0 2 0 2 0
		String[] inputAsArray = caseInput.split(" ");
		int N = Integer.parseInt(inputAsArray[0]); //кол-во единорогов
		int R = Integer.parseInt(inputAsArray[1]); //кол-во красногривых
		int O = Integer.parseInt(inputAsArray[2]); //кол-во оранжевогривых
		int Y = Integer.parseInt(inputAsArray[3]); //кол-во желтогривых
		int G = Integer.parseInt(inputAsArray[4]); //кол-во зеленогривых
		int B = Integer.parseInt(inputAsArray[5]); //кол-во голубогривых
		int V = Integer.parseInt(inputAsArray[6]); //кол-во фиолетовогривых
		
		String answer = resolveTask(N, R, O, Y, G, B, V);
		
		return answer;
	}

	private static String resolveTask(int N, int R, int O, 
			int Y, int G, int B, int V) {
		//
		char stoilo[] = new char[N];
		if (R>=Y && R>=B){
			stoilo[0]='R';
			R--;}
		else if (Y>R && Y>=B) {
			stoilo[0]='Y';
			Y--;
		} else{
			stoilo[0]='B';
			B--;
		} 
	
		for (int i=1; i<stoilo.length; i++){
			if (stoilo[i-1]=='R') {
				if (Y>B) {
					stoilo[i]='Y';
					Y--;
				} else {
					stoilo[i]='B';
					B--;
				}
				
			} else if (stoilo[i-1]=='Y') {
				if (R>B) {
					stoilo[i]='R';
					R--;
				} else {
					stoilo[i]='B';
					B--;
				}
				
			} else {
				if (R>Y) {
					stoilo[i]='R';
					R--;
				} else {
					stoilo[i]='Y';
					Y--;
				}
				
			} 
			if (R<0 || B<0 || Y<0){
				return "IMPOSSIBLE";
			}
		}
		if (stoilo[stoilo.length-1] == stoilo[0]) {
			char temp = stoilo[stoilo.length-1];
			stoilo[stoilo.length-1] = stoilo[stoilo.length-2];
			stoilo[stoilo.length-2] = temp;
			if (stoilo[stoilo.length-2] == stoilo[stoilo.length-3]){
				return "IMPOSSIBLE";
			}
		}
		
		if (stoilo[0] == stoilo[stoilo.length-1]) {
			return "IMPOSSIBLE";
		}
			
		String result = new String(stoilo); 
		
		return result;
		
		
	}

}








































