package edu.chess.simulator.randomise;

import java.io.Serializable;

import edu.chess.simulator.interfaces.IPlayer;

public class RandomPlayer implements IPlayer,Serializable {

	private static final long serialVersionUID = -5198483400570042147L;
	private String name; 
	
	public RandomPlayer() {
		String temp= "";
		while(temp.length()<6) {
			int tmpInt = (int)(Math.random()*1000);
			if(tmpInt>96 && tmpInt <123) {
				temp += (char)tmpInt;	
			}
			 
		}
		
		//this.name = temp;
		this.name = "Player"+((int)(Math.random()*100));
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String setName() {
		return null;
	}

}
