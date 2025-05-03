package todo.service;

import db.Database;
import db.exception.InvalidEntityException;
import todo.entity.Task;


public class TaskService {
    public static void setAsCompleted(int taskId) {
        try {
            Task task = (Task) Database.get(taskId);
            task.setStatus(Task.Status.Completed);
            Database.update(task);
        } catch (InvalidEntityException e) {
            System.err.println("Error: Task with ID " + taskId + " not found.");
        }
    }


        public static void setAsInProgress(int taskId) {
            try {
                Task task = (Task) Database.get(taskId);
                task.setStatus(Task.Status.InProgress);
                Database.update(task);
            } catch (InvalidEntityException e) {
                System.err.println("Error: Task with ID " + taskId + " not found.");

            }
        }

    public static void setAsNotStarted(int taskId) {
        try {
            Task task = (Task) Database.get(taskId);
            task.setStatus(Task.Status.NotStarted);
            Database.update(task);
        } catch (InvalidEntityException e) {
            System.err.println("Error: Task with ID " + taskId + " not found.");

        }
    }
}