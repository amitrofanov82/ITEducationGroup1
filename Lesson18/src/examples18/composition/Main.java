package examples18.composition;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class Main {
	
	public static void main(String[] s) {
		/*Wheel wheel = new Wheel("Kvadratnoe koleso", true);
		Wheel wheel2 = new Wheel();
		
		System.out.println(wheel.tireOnThisWheel.description);
		if (wheel2.tireOnThisWheel != null){
			System.out.println(wheel2.tireOnThisWheel.description);
		} else {
			System.out.println("Koleso " + wheel2.description + " goloe");
		}*/
		
		Person p = new Person("Alexey");
		
		p.buyAuto("Alexey's car", true);
		
		System.out.println(p.auto.wheelOnThisCar[2].description);
		
	}
}






















