// Command pattern
interface Command {
    void execute();
    void undo();
}

class CreateTaskCommand implements Command {
    private Task task;
    private TaskManager taskManager;

    public CreateTaskCommand(Task task, TaskManager taskManager) {
        this.task = task;
        this.taskManager = taskManager;
    }

    public void execute() {
        taskManager.createTask(task);
    }

    public void undo() {
        taskManager.deleteTask(task);
    }
}

class AssignTaskCommand implements Command {
    private String taskId;
    private String assignee;
    private TaskManager taskManager;

    public AssignTaskCommand(String taskId, String assignee, TaskManager taskManager) {
        this.taskId = taskId;
        this.assignee = assignee;
        this.taskManager = taskManager;
    }

    public void execute() {
        taskManager.assignTask(taskId, assignee);
    }

    public void undo() {
        taskManager.unassignTask(taskId);
    }
}
