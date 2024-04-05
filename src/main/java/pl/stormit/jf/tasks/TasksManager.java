package pl.stormit.jf.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TasksManager {
	private List<TodoItem> items = new ArrayList<>();

	public void load() {
		try {
			Path path = Path.of("./tasks.txt");

			if (Files.exists(path)) {
				Stream<String> lines = Files.lines(path);
				lines.forEach(line -> {
					String[] split = line.split(";");
					items.add(new TodoItem(split[0], Boolean.valueOf(split[1])));
				});
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void save() throws IOException {
		Path path = Path.of("./tasks.txt");

		String content = items.stream()
				.map(item -> item.getTask() + ";" + item.isCompleted())
				.collect(Collectors.joining("\n"));

		Files.write(path, content.getBytes());
	}

	public void showTasks() {
		System.out.println("Twoje zadania: ");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(i + 1 + " " + items.get(i));
		}
	}

	public void addTask(String task) {
		items.add(new TodoItem(task));
		System.out.println("Zadanie dodane");
	}

	public void removeTask(int index) {
		if (index >= 1 && index <= items.size()) {
			items.remove(index - 1);
			System.out.println("Zadanie usunięte");
		} else {
			System.out.println("Nie ma zadania o takim indeksie");
		}
	}

	public void completeTask(int index) {
		if (index > 0 && index <= items.size()) {
			items.get(index - 1).setCompleted(true);
			System.out.println("Zadanie zamknięte");
		} else {
			System.out.println("Nie ma zadania o takim indeksie");
		}
	}

	public void help() {
		System.out.println("Pomoc tasks managera");
		System.out.println("Dostępne komendy: ");
		System.out.println("1. a <task name> – dodanie zadania");
		System.out.println("2. c <task index> – zakończenie zadania");
		System.out.println("3. d <task index> – usunięcie zadania");
		System.out.println("4. l – wyświetlenie zadań");
		System.out.println("5. e – exit, zamknięcie programu");
	}
}
