package lesson54.java8;

import java.util.function.Supplier;

public class Lambda {
	// 1: Лямбда выражения
	// 1.1: Функциональные интерфейсы
	// 1.2: Method Reference...
	//
	// 2: Stream (расширение Collections Framework)
	// 3. Реализация метода интерфейса по умолчанию
	// 4. Прочие мелкие дополнения к библиотеке (прежде всего java.time)
	public static void main(String[] args) {
		Soldat s1 = new Soldat();
		Soldat s2 = new Soldat();
		Soldat s3 = new Soldat();
		Soldat s4 = new Soldat();
		Soldat s5Educated = new Soldat();

		// approach 1:
		s1.executeOrder(new /*Order*/Supplier<String>() {
			@Override
			public String /*execute*/get() {
				return "Order for soldier #1";
			}
		});

		// approach 2:
		/*Order*/ Supplier s2Order = new /*Order*/Supplier<String>() {
			public int orderResult = 0; // бесполезно

			@Override
			public String get() {
				orderResult = 1;
				return "Order for soldier #1";
			}
		};
		/*
		 * Лирическое отступление Order sameOrder = new Order(){ public int
		 * orderResult=0; //бесполезно
		 * 
		 * @Override public String execute() { orderResult=1; return
		 * "Order for soldier #1"; } }; System.out.println( sameOrder.getClass()
		 * .equals(s2Order.getClass())); s2Order. не получится вытащить
		 * результат
		 */
		s2.executeOrder(s2Order);

		// approach 3:
		s3.executeOrder(new InnerOrderImpl());

		// approach 4.1 java8, lambda expression:
		s4.executeOrder(
			() -> {
				return "Lamda Order result 1";
			}
		);
		//-- 4.2
		s4.executeOrder(() -> "Lamda Order result 1");
		//-- 4.3
		/*Order*/ Supplier ooo = () -> "Lamda Order as var";
		s4.executeOrder(ooo);
		
		// approach 5.1 (lambda with parameters):
		int result = s5Educated.helpOfficersSon((a) -> a+a, 3.0);
		System.out.println("Educated soldier result1=" + result);
		
		// approach 6 (method reference):
		s5Educated.helpOfficersSon(Math::sqrt, 3.0);
		Double someDobject;
		//s5Educated.helpOfficersSon(someDobject::doubleValue, 3.0);
		
		
	}

	private static class InnerOrderImpl implements Order, Supplier<String> {
		@Override
		public String execute() {
			return "Order as inner class";
		}

		@Override
		public String get() {
			return execute();
		}
	}
}























