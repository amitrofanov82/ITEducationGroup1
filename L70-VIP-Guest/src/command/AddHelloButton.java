package command;

import java.util.List;

public class AddHelloButton {

	private Command command;
	
	public AddHelloButton(List<String> strings) {
		command = new AddCommand(strings, "Hello");
		
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void click(){
		command.execute();
	}
}
