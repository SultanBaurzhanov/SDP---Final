// Chain of Responsibility pattern
interface Notification {
    void notify(String taskId);
}

class NotificationSystem implements Notification {
    private Notification next;

    public NotificationSystem(Notification next) {
        this.next = next;
    }

    public void notify(String taskId) {
        System.out.println("Sending notifications for task " + taskId);
        next.notify(taskId);
    }
}

class EmailNotification implements Notification {
    public void notify(String taskId) {
        System.out.println("Sending email notification for task " + taskId);
    }
}

class SmsNotification implements Notification {
    public void notify(String taskId) {
        System.out.println("Sending SMS notification for task " + taskId);
    }
}
