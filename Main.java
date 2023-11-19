import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        // Create users and set up notification preferences
        taskManager.addObserver(user);

        System.out.println("Welcome to Task Planner!");
        while (true) {
            System.out.println("\n1. Create a Task");
            System.out.println("2. Assign Task");
            System.out.println("3. Unassign Task");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 0:
                    System.out.println("Exiting Task Planner. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("\nEnter Task details:");
                    System.out.print("Task ID: ");
                    String taskId = scanner.nextLine();
                    System.out.print("Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Assignee: ");
                    String assignee = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    TaskBuilder taskBuilder = new TaskBuilder();
                    Task task = taskBuilder.setTaskId(taskId)
                            .setTaskName(taskName)
                            .setAssignee(assignee)
                            .setDescription(description)
                            .build();


                // Asking the user about notification preferences
                System.out.println("\nSelect notification preference:");
                System.out.println("1. Email");
                System.out.println("2. SMS");
                System.out.print("Enter your choice: ");
                int notificationChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                Notification notificationPreference;
                switch (notificationChoice) {
                    case 1:
                        notificationPreference = new EmailNotification();
                        break;
                    case 2:
                        notificationPreference = new SmsNotification();
                        break;
                    default:
                        System.out.println("Invalid choice. Setting default notification preference to Email.");
                        notificationPreference = new EmailNotification();
                        break;
                }

                user.setNotificationPreference(notificationPreference);

                CreateTaskCommand createTaskCommand = new CreateTaskCommand(task, taskManager);
                createTaskCommand.execute();
                System.out.println("Task created. Undo option available. Press 'u' to undo.");

                char choice2 = scanner.next().charAt(0);
                if (choice2 == 'u') {
                    createTaskCommand.undo();
                    System.out.println("Task creation undone.");
                }
                break;

                case 2:
                    // Request information about the assignment of the task
                    System.out.println("\nEnter Task Assignment details:");
                    System.out.print("Task ID: ");
                    String taskIdForAssignment = scanner.nextLine();
                    System.out.print("Assignee: ");
                    String assigneeForTask = scanner.nextLine();

                    // // Creating the Assign Task Command and performing the operation
                    AssignTaskCommand assignTaskCommand = new AssignTaskCommand(taskIdForAssignment, assigneeForTask, taskManager);
                    assignTaskCommand.execute();
                    System.out.println("Task assigned. Undo option available. Press 'u' to undo.");

                    char assignmentChoice = scanner.next().charAt(0);
                    if (assignmentChoice == 'u') {
                        assignTaskCommand.undo();
                        System.out.println("Task assignment undone.");
                    }
                    break;
                case 3:
                    // Request information to cancel task assignment
                    System.out.println("\nEnter Task Unassignment details:");
                    System.out.print("Task ID: ");
                    String taskIdForUnassignment = scanner.nextLine();

                    // Creating the UnassignTaskCommand command and performing the operation
                    AssignTaskCommand unassignTaskCommand = new AssignTaskCommand(taskIdForUnassignment, null, taskManager);
                    unassignTaskCommand.undo();
                    System.out.println("Task unassigned. Redo option available. Press 'r' to redo.");

                    char unassignmentChoice = scanner.nextLine().charAt(0);
                    if (unassignmentChoice == 'r') {
                        unassignTaskCommand.redo();
                        System.out.println("Task unassignment redone.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
