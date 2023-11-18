import java.util.ArrayList;
import java.util.List;

// Observer
interface Observer {
    void update(Task task);
}

class TaskSubject {
    private List<Observer> observers;
    private Task task;

    public TaskSubject() {
        this.observers = new ArrayList<>();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

class UserObserver implements Observer {
    private String name;

    public UserObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Task task) {
        System.out.println("Hello, " + name + "! Task has been updated. New details: " + task);
    }
}
