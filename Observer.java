// Observer pattern
interface Observer {
    void update(String taskId);
}

class User implements Observer {
    private String name;
    private Notification notificationPreference;

    public User(String name) {
        this.name = name;
    }

    public void setNotificationPreference(Notification notificationPreference) {
        this.notificationPreference = notificationPreference;
    }

    public void update(String taskId) {
        System.out.println("Dear " + name + ", task " + taskId + " has been updated.");
        if (notificationPreference != null) {
            notificationPreference.notify(name, taskId);
        }
    }

    public String getName() {
        return name;
    }
}
