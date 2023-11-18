import java.util.Stack;

public class Task {
    private int id;
    private String name;
    private String description;
    private String status;

    public Task(TaskBuilder taskBuilder) {
        this.id = taskBuilder.id;
        this.name = taskBuilder.name;
        this.description = taskBuilder.description;
        this.status = taskBuilder.status;
    }

    // getters and setters
}

public class TaskBuilder {
    private int id;
    private String name;
    private String description;
    private String status;

    public TaskBuilder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TaskBuilder description(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder status(String status) {
        this.status = status;
        return this;
    }

    public Task build() {
        return new Task(this);
    }
}
