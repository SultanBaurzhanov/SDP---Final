import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create tasks using the builder pattern
        Task task1 = new TaskBuilder()
                .setTaskTitle("Complete Assignment")
                .setTaskDescription("Finish the project assignment")
                .setDueDate(new Date())
                .build();

        Task task2 = new TaskBuilder()
                .setTaskTitle("Meeting Preparation")
                .setTaskDescription("Prepare for the team meeting")
                .setDueDate(new Date())
                .build();

        Task task3 = new TaskBuilder()
                .setTaskTitle("Write Report")
                .setTaskDescription("Compile the progress report")
                .setDueDate(new Date())
                .build();

        // Create a task list and add tasks
        TaskList taskList = new TaskList();
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        // Create a notification manager
        NotificationManager notificationManager = new NotificationManager();

        // Create observers (users) for task updates
        Observer user1 = new Observer() {
            @Override
            public void update(Task task) {
                System.out.println("User 1: Notification for task update - " + task.getTaskTitle());
            }
        };

        Observer user2 = new Observer() {
            @Override
            public void update(Task task) {
                System.out.println("User 2: Notification for task update - " + task.getTaskTitle());
            }
        };

        // Add observers to the notification manager
        notificationManager.addObserver(user1);
        notificationManager.addObserver(user2);

        // Notify observers of a task update (for task1)
        notificationManager.notifyObservers(task1);

        // Example of handling notification preferences using Chain of Responsibility
        NotificationHandler emailNotificationHandler = new EmailNotificationHandler();
        NotificationHandler appNotificationHandler = new AppNotificationHandler();

        // Set the chain of responsibility
        emailNotificationHandler.setSuccessor(appNotificationHandler);

        // Define user preferences for task3
        NotificationPreferences userPreferences = new NotificationPreferences(true, true);

        // Notify based on user preferences for task3
        emailNotificationHandler.handleNotification(task3, userPreferences);
    }
}
