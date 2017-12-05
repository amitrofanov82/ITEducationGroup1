package lesson54.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=100; i++){
			list.add(i);
		}
		System.out.println(list);
		
		
		
		//-------
		Stream<Integer> stream = list.stream();
		//stream.forEach((a) -> System.out.println(a+1));
		stream = stream.map((i) -> i+1);
		//stream.forEach((a) -> System.out.println(a));//ошибка бфла без верхнего присваивания
		//System.out.println(list); //нинчего не поменялось
		Stream<Soldat> strSold = stream.map((i)-> {
			Soldat newSold = new Soldat();
			newSold.nomer = i;
			return newSold;
		});
		strSold.forEach(System.out::println);
		//strSold.forEach(System.out::println); ошибка
		
		
		//Воссоздать лист солдат со случайными номерами, 
		//и из солдат обратно лист интеджеров:
		
		Stream<Integer> strInt = list.stream().map((i)->new Soldat())
		    .peek((s) -> s.nomer=(int) (Math.random()*102))
		    .map((s)->s.nomer);
		
		List<Integer> newList = list.stream()
			.map((i)->new Soldat())
		    .peek((s) -> s.nomer=(int) (Math.random()*102))
		    .map((s)->s.nomer)
			//.forEach(System.out::println);
		    .collect(Collectors.toList());
		
		
	
	}
}
