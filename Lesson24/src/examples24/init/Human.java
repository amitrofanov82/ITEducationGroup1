package examples24.init;

public class Human {
	private char sex;
	private String name;
	private Human whoHeLikes;
	
	{
		sex = Math.random()>0.5 ? 'M' : 'F';
		name = (sex == 'M') ? 
				"Vasya" + (int) (Math.random()*10000) 
			  : "Masha" + (int) (Math.random()*10000);
	}
	
	
	static {
		System.out.println("static init");
	}
	
	public Human(){
		/*sex = Math.random()>0.5 ? 'M' : 'F';
		name = (sex == 'M') ? 
				"Vasya" + (int) (Math.random()*10000) 
			  : "Masha" + (int) (Math.random()*10000);*/
		whoHeLikes = null;
	}
	
	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Human getWhoHeLikes() {
		return whoHeLikes;
	}

	public void setWhoHeLikes(Human whoHeLikes) {
		this.whoHeLikes = whoHeLikes;
	}
	
	public void print() {
		if (whoHeLikes == null){
			System.out.println("I'm " 
			          + name + " I love " 
					  + whoHeLikes);
		} else {
			System.out.println("I'm " 
			          + name + " I love " 
					  + whoHeLikes.getName());
		}
		

	}


	
}
