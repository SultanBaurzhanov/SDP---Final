import java.util.ArrayList;
import java.util.List;

// Command
interface Command {
    void execute();
    void undo();
}

// CreateTaskCommand
class CreateTaskCommand implements Command {
    private Task task;
    private TaskList taskList;

    public CreateTaskCommand(Task task, TaskList taskList) {
        this.task = task;
        this.taskList = taskList;
    }

    public void execute() {
        taskList.addTask(task);
    }

    public void undo() {
        taskList.removeTask(task);
    }
}

// TaskList
class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}