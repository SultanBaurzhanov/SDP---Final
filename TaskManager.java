import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TaskManager {
    private Map<String, Task> tasks;
    private List<Observer> observers;

    public TaskManager() {
        this.tasks = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String taskId) {
        for (Observer observer : observers) {
            observer.update(taskId);
        }
    }

    public void createTask(Task task) {
        tasks.put(task.getTaskId(), task);
        System.out.println("Task created: " + task.getTaskId());
        notifyObservers(task.getTaskId()); // Notify observers upon task creation
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
