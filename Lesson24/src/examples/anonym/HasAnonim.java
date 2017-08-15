package examples.anonym;

import examples24.innerclass.Human;

public class HasAnonim {
	
	public static void main(String[] args) {
		Human h = new Human(){
			public boolean isDurak; //доступа нет, поле бессмысленное
		};
		
		Object a = new Animal(){

			@Override
			public void sayHello() {
				System.out.println("Gav-gav");
			}
			
		};
		
		((Animal)a).sayHello();
	}

}
