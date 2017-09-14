package examples33.zoopark.domain;

public abstract class Beast {
	@Override
	public int hashCode() {
		if (name == null){
			return -1;
		} 
		return this.name.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beast other = (Beast) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String name;
	
	public Beast(String name){
		this.name=name;
	}
	
	public Beast(){
		this.name="Аноним";
	}
	
	public String getName(){
		return name;
	}

}
