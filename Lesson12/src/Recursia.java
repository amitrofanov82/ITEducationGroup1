
public class Recursia {
	public static void main(String[] args) {
		System.out.println("main pered vyzovom methoda");
		method(5);
		System.out.println("main posle vyzova methoda");

		
		
		/*method(12);
		method(14);
		method2();*/
	}
	
	public static void method(int i){
		System.out.println(i + " v nachale methoda ");
		if(i > 1){
			method(i-1);
		}
		System.out.println(i + " v konce methoda ");
	}
	
	/*public static void method2(){
		method(16);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
