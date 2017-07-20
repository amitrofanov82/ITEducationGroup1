package example23.train;

import java.util.Date;

public class Train {
	private static final long HOUR=3600000L;
	private static final long H24=HOUR*24;
	
	private int[] route;
	private long[] schedule;
	
	Train(int[] route, long[] schedule){
		this.route=route;
		this.schedule=schedule;
	}
	
	Train(String[] cities){
		route= new int [(int) (Math.random()*cities.length+2)];
		schedule=new long [route.length];
		for (int i=0; i<route.length; i++) {
			route[i]= (int) (Math.random()* route.length);
			if (i!=0 && route[i]== route[i-1] ){
				i--;
			}
		}
		schedule[0]=System.currentTimeMillis()+ (int)(Math.random()*H24);
		for (int i=1; i<schedule.length; i++){
			schedule[i]=schedule[i-1]+ (int)(Math.random()*HOUR);
		}
	}

	@Override
	public String toString() {
		String line1 = "";
		String line2 = "";
		for (int i =0; i< route.length; i++){
			line1 = line1 + Main.CITIES[route[i]] + "\t|";
		}
		line1 = line1 + "\n";
		for (int i =0; i< route.length; i++){
			Date d = new Date(schedule[i]);
			line2 = line2 + d.getHours()+":" +d.getMinutes() + "\t|";
		}
		return line1 + line2;
	}
	
	public int[] getRoute() {
		return route;
	}
	public void setRoute(int[] route) {
		this.route = route;
	}
	public long[] getSchedule() {
		return schedule;
	}
	public void setSchedule(long[] schedule) {
		this.schedule = schedule;
	}
	

}
