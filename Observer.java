import java.util.ArrayList;
import java.util.List;

// Observer
interface Observer {
    void update(Task task);
}

// Notification Manager (Subject)
class NotificationManager {
    private List<Observer> observers;

    public NotificationManager() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }
}
