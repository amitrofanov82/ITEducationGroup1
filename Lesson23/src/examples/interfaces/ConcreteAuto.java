package examples.interfaces;

import java.util.LinkedList;
import java.util.List;

public class ConcreteAuto implements IAuto, SolidBody{

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		List s = new LinkedList();
		
		
	}

	@Override
	public boolean isBroken() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFriver(String driverName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getWieght() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

}
