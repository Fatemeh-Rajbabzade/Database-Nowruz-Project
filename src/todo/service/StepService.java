package todo.service;

import db.Database;
import db.exception.InvalidEntityException;
import todo.entity.Step;

public class StepService {

    public static void saveStep(int taskRef, String title) throws InvalidEntityException {
        if (title == null || title.isEmpty())
            throw new InvalidEntityException("Title Cannot  be null or empty.");

        Step newStep = new Step(title, taskRef);
        newStep.setStatus(Step.Status.NotStarted);
        Database.add(newStep);
    }

    public static void setStepAsCompleted(int stepId) throws InvalidEntityException {
        Step step = (Step) Database.get(stepId);
        step.setStatus(Step.Status.Completed);
        Database.update(step);
    }

    public static void setStepAsInProgress(int stepId) throws InvalidEntityException {
        Step step = (Step) Database.get(stepId);
        step.setStatus(Step.Status.NotStarted);
        Database.update(step);
    }

    public static void deleteStep(int stepId) throws InvalidEntityException {
        Step step = (Step) Database.get(stepId);
        Database.delete(stepId);
    }
    }



