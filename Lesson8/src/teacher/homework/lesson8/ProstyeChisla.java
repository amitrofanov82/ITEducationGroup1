package teacher.homework.lesson8;
///prostye chisla do N
public class ProstyeChisla {
	
	public static void main(String[] args) {
		int N = 41;
		
		for (int chisloKandidat = 2; chisloKandidat<=N; chisloKandidat++){
			boolean isKandidatSimple = true; //talk about memory
			for (int delitelDlaKandidata = 2; 
					delitelDlaKandidata < chisloKandidat; 
					delitelDlaKandidata++) {
				if (chisloKandidat % delitelDlaKandidata == 0) {
					isKandidatSimple = false;
					break; //kandidatov bolshe ne nado perebirat';
				} 
			}
			if (isKandidatSimple) {
				System.out.println(chisloKandidat);
			}
		}
		
		
		
	}

}
