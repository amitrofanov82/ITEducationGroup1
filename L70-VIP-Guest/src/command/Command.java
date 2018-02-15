package command;

import java.util.List;

public abstract class Command {

	protected List<String> strings;
	
	public Command(List<String> strings){
		this.strings = strings;
	}

	abstract void execute();
}
