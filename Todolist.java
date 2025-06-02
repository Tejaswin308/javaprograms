
  import java.util.*;

class  Task{
    private String description;
    private boolean isCompleted;
    private String priority;

    public Task(String description, String priority) {
        this.description = description;
        this.isCompleted = false;
        this.priority = priority;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public void edit(String newDescription, String newPriority) {
        description = newDescription;
        priority = newPriority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getPriority() {
        return priority;
    }

    public String toString() {
        return (isCompleted ? "[✔]" : "[ ]") + " " + description + " (Priority: " + priority + ")";
    }
}

public class Todolist {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== TO-DO LIST ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Edit Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskComplete();
                case 4 -> editTask();
                case 5 -> deleteTask();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();
        tasks.add(new Task(desc, priority));
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\n--- Your Tasks ---");
        int i = 1;
        for (Task task : tasks) {
            System.out.println(i++ + ". " + task);
        }
    }

    private static void markTaskComplete() {
        viewTasks();
        System.out.print("Enter task number to mark complete: ");
        int num = scanner.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.get(num - 1).markAsCompleted();
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void editTask() {
        viewTasks();
        System.out.print("Enter task number to edit: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (num > 0 && num <= tasks.size()) {
            System.out.print("Enter new description: ");
            String newDesc = scanner.nextLine();
            System.out.print("Enter new priority: ");
            String newPriority = scanner.nextLine();
            tasks.get(num - 1).edit(newDesc, newPriority);
            System.out.println("Task updated.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int num = scanner.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}


