// Builder pattern
class Task {
    private String taskId;
    private String taskName;
    private String assignee;
    private String description;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class TaskBuilder {
    private Task task;

    public TaskBuilder() {
        task = new Task();
    }

    public TaskBuilder setTaskId(String taskId) {
        task.setTaskId(taskId);
        return this;
    }

    public TaskBuilder setTaskName(String taskName) {
        task.setTaskName(taskName);
        return this;
    }

    public TaskBuilder setAssignee(String assignee) {
        task.setAssignee(assignee);
        return this;
    }

    public TaskBuilder setDescription(String description) {
        task.setDescription(description);
        return this;
    }

    public Task build() {
        return task;
    }
}
