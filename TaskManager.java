import java.util.HashMap;
import java.util.Map;

class TaskManager {
    private Map<String, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public void createTask(Task task) {
        tasks.put(task.getTaskId(), task);
        System.out.println("Task created: " + task.getTaskId());
    }

    public void deleteTask(Task task) {
        tasks.remove(task.getTaskId());
        System.out.println("Task deleted: " + task.getTaskId());
    }

    public void assignTask(String taskId, String assignee) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setAssignee(assignee);
            System.out.println("Task " + taskId + " assigned to " + assignee);
        } else {
            System.out.println("Task " + taskId + " not found");
        }
    }

    public void unassignTask(String taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setAssignee(null);
            System.out.println("Task " + taskId + " unassigned");
        } else {
            System.out.println("Task " + taskId + " not found");
        }
    }
}
