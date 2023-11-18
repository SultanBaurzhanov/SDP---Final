// Notification Preferences (Chain of Responsibility)
class NotificationPreferences {
    private boolean emailNotifications;
    private boolean appNotifications;

    public NotificationPreferences(boolean emailNotifications, boolean appNotifications) {
        this.emailNotifications = emailNotifications;
        this.appNotifications = appNotifications;
    }

    public boolean isEmailNotificationsEnabled() {
        return emailNotifications;
    }

    public boolean isAppNotificationsEnabled() {
        return appNotifications;
    }
}

// Notification Handler (Chain of Responsibility)
abstract class NotificationHandler {
    protected NotificationHandler successor;

    public void setSuccessor(NotificationHandler successor) {
        this.successor = successor;
    }

    public abstract void handleNotification(Task task, NotificationPreferences preferences);
}

// Email Notification Handler (Example handler)
class EmailNotificationHandler extends NotificationHandler {
    @Override
    public void handleNotification(Task task, NotificationPreferences preferences) {
        if (preferences.isEmailNotificationsEnabled()) {
            // Implement email notification logic here
            System.out.println("Sending email notification for task: " + task.getTaskTitle());
        } else if (successor != null) {
            successor.handleNotification(task, preferences);
        }
    }
}

// App Notification Handler 
class AppNotificationHandler extends NotificationHandler {
    @Override
    public void handleNotification(Task task, NotificationPreferences preferences) {
        if (preferences.isAppNotificationsEnabled()) {
            // Implement app notification logic here
            System.out.println("Sending app notification for task: " + task.getTaskTitle());
        } else if (successor != null) {
            successor.handleNotification(task, preferences);
        }
    }
}
