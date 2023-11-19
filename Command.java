// Command pattern
interface Command {
    void execute();
    void undo();
    void redo();
}

class CreateTaskCommand implements Command {
    private Task task;
    private TaskManager taskManager;
    private boolean executed;

    public CreateTaskCommand(Task task, TaskManager taskManager) {
        this.task = task;
        this.taskManager = taskManager;
        this.executed = false;
    }

    public void execute() {
        taskManager.createTask(task);
        executed = true;
    }

    public void undo() {
        if (executed) {
            taskManager.deleteTask(task);
            executed = false;
        }
    }

    public void redo() {
        if (!executed) {
            taskManager.createTask(task);
            executed = true;
        }
    }
}


class AssignTaskCommand implements Command {
    private String taskId;
    private String assigneeBefore;
    private String assigneeAfter;
    private TaskManager taskManager;
    private boolean executed;

    public AssignTaskCommand(String taskId, String assignee, TaskManager taskManager) {
        this.taskId = taskId;
        this.assigneeAfter = assignee;
        this.taskManager = taskManager;
        this.executed = false;
    }

    public void execute() {
        Task task = taskManager.getTaskById(taskId);
        if (task != null) {
            assigneeBefore = task.getAssignee();
            taskManager.assignTask(taskId, assigneeAfter);
            executed = true;
        } else {
            System.out.println("Task " + taskId + " not found");
        }
    }

    public void undo() {
        if (executed) {
            taskManager.assignTask(taskId, assigneeBefore);
            executed = false;
        }
    }

    public void redo() {
        if (!executed) {
            taskManager.assignTask(taskId, assigneeAfter);
            executed = true;
        }
    }
}
