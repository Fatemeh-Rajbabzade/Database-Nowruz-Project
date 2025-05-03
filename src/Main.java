import db.Database;
import example.Human;
import db.exception.InvalidEntityException;
import example.HumanValidator;
import example.Document;

package todo;

import todo.service.StepService;
import todo.service.TaskService;
import db.exception.InvalidEntityException;
import db.exception.EntityNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command:");
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                switch (command.toLowerCase()) {
                    case "add task":
                        // افزودن task
                        System.out.println("Enter task title:");
                        String taskTitle = scanner.nextLine();
                        System.out.println("Enter task description:");
                        String taskDescription = scanner.nextLine();
                        System.out.println("Enter task due date (yyyy-MM-dd):");
                        String dueDate = scanner.nextLine();

                        TaskService.saveTask(taskTitle, taskDescription, dueDate);
                        break;

                    case "add step":
                        // افزودن step
                        System.out.println("Enter task ID:");
                        int taskId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter step title:");
                        String stepTitle = scanner.nextLine();

                        StepService.saveStep(taskId, stepTitle);
                        break;

                    case "delete":
                        // حذف موجودیت
                        System.out.println("Enter entity ID to delete:");
                        int entityId = Integer.parseInt(scanner.nextLine());
                        TaskService.deleteEntity(entityId);
                        break;

                    case "update task":
                        // به روز رسانی task
                        System.out.println("Enter task ID:");
                        int updateTaskId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter field to update (e.g., title, due date, status):");
                        String field = scanner.nextLine();
                        System.out.println("Enter new value for " + field + ":");
                        String newValue = scanner.nextLine();

                        TaskService.updateTask(updateTaskId, field, newValue);
                        break;

                    case "update step":
                        // به روز رسانی step
                        System.out.println("Enter step ID:");
                        int updateStepId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter field to update (e.g., status):");
                        String stepField = scanner.nextLine();
                        System.out.println("Enter new value for " + stepField + ":");
                        String stepNewValue = scanner.nextLine();

                        StepService.updateStep(updateStepId, stepField, stepNewValue);
                        break;

                    case "get task-by-id":
                        // دریافت task بر اساس ID
                        System.out.println("Enter task ID:");
                        int getTaskId = Integer.parseInt(scanner.nextLine());
                        TaskService.getTaskById(getTaskId);
                        break;

                    case "get all-tasks":
                        // دریافت تمام task‌ها
                        TaskService.getAllTasks();
                        break;

                    case "get incomplete-tasks":
                        // دریافت task‌های ناقص
                        TaskService.getIncompleteTasks();
                        break;

                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }
            } catch (InvalidEntityException | EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Exiting the program.");
    }
}
