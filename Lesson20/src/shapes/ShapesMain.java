package shapes;

public class ShapesMain {
	public static void main(String[] args) {
		//Treugolnik tr = new Treugolnik();
		//Kvadrat kv = new Kvadrat();
		//Krug kr = new Krug();
		//Shape sh = new Shape();
		
		//sh.print();
		//kv.print();
		//kr.print();
		
		Shape[] shapes = new Shape[5];
		for (int i=0; i < shapes.length; i++){
			shapes[i] = Math.random()>0.5 ? new Kvadrat()
										  : new Krug();
		}
		for (int i=0; i < shapes.length; i++){
			shapes[i].print();
			if (shapes[i].getName().equals("krug")){
				System.out.println(((Krug) shapes[i]).getR());
			}
		}
		
		Shape s = new Krug();
		((Krug) s).getR(); //ok
		s = Math.random()>0.5 ? new Kvadrat()
				  : new Krug();
		((Krug) s).getR();
		
		
	}
}
