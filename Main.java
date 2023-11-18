public class Main {
    public static void main(String[] args) {
        TaskBuilder taskBuilder = new TaskBuilder();
        Task task = taskBuilder.setTaskId("T1")
                .setTaskName("Design a system")
                .setAssignee("John")
                .setDescription("Design a system with various components")
                .build();

        TaskManager taskManager = new TaskManager();
        CreateTaskCommand createTaskCommand = new CreateTaskCommand(task, taskManager);
        createTaskCommand.execute();
        createTaskCommand.undo();

        AssignTaskCommand assignTaskCommand = new AssignTaskCommand("T2", "Jane", taskManager);
        assignTaskCommand.execute();
        assignTaskCommand.undo();

        User user = new User("Tom");
        user.update("T1");

        Notification notificationSystem = new NotificationSystem(new EmailNotification());
        notificationSystem.notify("T1");
    }
}
