
public class Massivy {

	public static void main(String[] args) {
		//объявление переменных
		int a, b, c[];
		int[] d, e, f;
		//int[] dvoynoy[];
		//int[][] troynoy[];
		int[][] dvoynoy;
		int dvoynoy2[][];
		int[][][] troynoy;
		
		
		//инициализация
		int[] g = {2, 3, 4, 17};
		int[] h = new int[100000]; //заполнен нулями
		boolean[] i = {true, true, true, false};
		boolean[] boolArray = new boolean[100];
		char[] charArray = new char[100];
		dvoynoy = new int[10][10];
		troynoy = new int[10][10][10];
		dvoynoy2 = new int[10][1];
		
		//чтение:
		System.out.println(g[2]);
		System.out.println(h[2]);
		System.out.println(boolArray[2]);
		System.out.println(charArray[2]);
		//System.out.println(c[2]); //не получиться так, нет массива
		
		//запись:
		h[5000] = 100;
		i[3] = true;
		//i[10] = true; ArrayIndexOutOfBoundsException
		
		//определить его длину
		System.out.println(h.length);
		System.out.println(i.length);
		//System.out.println(c.length); //не получиться так, нет массива
		
		//присваивание:
		g = h; //присваиваются сылки на место в памяти
		g[1]=h[100];
		//g=i; нельзя
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
