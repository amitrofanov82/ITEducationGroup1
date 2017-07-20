package example23.train;

import java.util.Date;

public class Main {
	public final static String[] CITIES = {"A", "B", "C", "D"}; 
	
	public final static int[][] DISTANCE_MATRIX 
	  = {{0,3,4,5},
		 {3,0,7,8}, 
		 {4,7,0,2},
		 {5,8,2,0}}; 
	
	public static final int NUM_OF_TRAINS = 5; 
	
	public static Train[] trains = new Train[NUM_OF_TRAINS];

	public static void main(String[] args){
		//Train testTrain = new Train(CITIES);
		//System.out.println(testTrain);
		for (int i = 0; i < NUM_OF_TRAINS; i++) {
			trains[i] = new Train(CITIES);
		}
		//Данные подготовлены. Ниже решаем задачу нахождения нужного поезда. 

	}
	

	
}
