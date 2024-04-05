package pl.stormit.jf.tasks;

import java.util.Objects;

public enum TasksCommand {
	ADD("a"), COMPLETE("c"), EXIT("e"), DELETE("d"), LIST("l"), HELP("h");

	String command;

	TasksCommand(String command) {
		this.command = command;
	}

	public static TasksCommand fromString(String userInput) {
		for(TasksCommand tasksCommand : values()){
			if(Objects.equals(tasksCommand.command, userInput)){
				return tasksCommand;
			}
		}

		throw new RuntimeException("Nieznana komenda: "+userInput);
	}
}
