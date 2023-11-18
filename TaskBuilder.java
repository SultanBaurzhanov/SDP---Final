import java.util.Date;

// Builder
class TaskBuilder {
    private String taskTitle;
    private String taskDescription;
    private Date dueDate;

    public TaskBuilder setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
        return this;
    }

    public TaskBuilder setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
        return this;
    }

    public TaskBuilder setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Task build() {
        return new Task(taskTitle, taskDescription, dueDate);
    }
}

// Task
class Task {
    private String taskTitle;
    private String taskDescription;
    private Date dueDate;

    public Task(String taskTitle, String taskDescription, Date dueDate) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
    }

    // Getters for task attributes
    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }
}