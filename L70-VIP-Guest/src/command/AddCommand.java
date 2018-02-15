package command;

import java.util.List;

public class AddCommand extends Command {

	private String string;
	
	public AddCommand(List<String> strings, String string) {
		super(strings);
		this.string = string;
	}
	
	@Override
	public void execute() {
		if (strings != null) {
			strings.add(string);
		}
	}

}
