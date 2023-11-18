// Chain of Responsibility pattern
interface Notification {
    void notify(String userName, String taskId);
}

class NotificationSystem implements Notification {
    private Notification next;

    public NotificationSystem(Notification next) {
        this.next = next;
    }

    public void notify(String userName, String taskId) {
        System.out.println("Sending notifications for task " + taskId + " to user " + userName);

        if (next != null) {
            next.notify(userName, taskId);
        }
    }
}

class EmailNotification implements Notification {
    public void notify(String userName, String taskId) {
        System.out.println("Sending email notification for task " + taskId + " to user " + userName);
    }
}

class SmsNotification implements Notification {
    public void notify(String userName, String taskId) {
        System.out.println("Sending SMS notification for task " + taskId + " to user " + userName);
    }
}
