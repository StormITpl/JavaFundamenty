package pl.stormit.jf.tasks;

import java.io.IOException;
import java.util.Scanner;

public class TasksApp {

	public static void main(String[] args) throws IOException {
		TasksManager taskManager = new TasksManager();

		try (Scanner scanner = new Scanner(System.in)) {
			taskManager.load();
			taskManager.help();

			while (true) {
				try {
					String userInput = scanner.nextLine();
					TasksCommand command = TasksCommand.fromString(userInput);

					switch (command) {
						case ADD -> {
							String task = scanner.nextLine();
							taskManager.addTask(task);
						}

						case DELETE -> {
							int taskIndex = Integer.parseInt(scanner.nextLine());
							taskManager.removeTask(taskIndex);
						}

						case COMPLETE -> {
							int taskIndex = Integer.parseInt(scanner.nextLine());
							taskManager.completeTask(taskIndex);
						}

						case LIST -> taskManager.showTasks();

						case HELP -> taskManager.help();

						case EXIT -> throw new ExitException();
					}
				} catch (ExitException ee) {
					throw ee;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (ExitException e) {
			System.out.println("Exit");
		}

		taskManager.save();
	}
}
