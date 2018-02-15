package command;

import java.util.List;

public class DeleteCommand extends Command {

	public DeleteCommand(List<String> strings) {
		super(strings);
	}

	@Override
	void execute() {
		strings.remove(strings.size() - 1);
	}
	
	

}
