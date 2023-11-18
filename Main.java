public class Main {
    public static void main(String[] args) {
        TaskBuilder taskBuilder = new TaskBuilder();
        Task task = taskBuilder.setTaskId("T1")
                .setTaskName("Design a system")
                .setAssignee("John")
                .setDescription("Design a system with various components")
                .build();

        TaskManager taskManager = new TaskManager();

        // Create users and set up notification preferences
        User tom = new User("Tom");
        User jane = new User("Jane");

        // Add users as observers to the TaskManager
        taskManager.addObserver(tom);
        taskManager.addObserver(jane);

        // Assign a notification preference for users
        tom.setNotificationPreference(new EmailNotification());
        jane.setNotificationPreference(new SmsNotification());

        CreateTaskCommand createTaskCommand = new CreateTaskCommand(task, taskManager);
        createTaskCommand.execute();

        // Simulate task update
        task.setAssignee("Bob");
        taskManager.updateTask(task);

        // Undo the task creation
        createTaskCommand.undo();
    }
}
