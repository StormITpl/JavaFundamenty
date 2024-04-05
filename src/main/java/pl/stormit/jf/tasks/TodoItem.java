package pl.stormit.jf.tasks;

public class TodoItem {
	private String task;
	private boolean isCompleted;

	public TodoItem(String task) {
		this.task = task;
	}

	public TodoItem(String task, boolean isCompleted) {
		this.task = task;
		this.isCompleted = isCompleted;
	}

	public void setCompleted(boolean completed) {
		isCompleted = completed;
	}

	public String getTask() {
		return task;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	@Override
	public String toString() {
		return "TodoItem{" +
				"task='" + task + '\'' +
				", isCompleted=" + isCompleted +
				'}';
	}
}
