package todo.validator;

import db.Database;
import db.Entity;
import db.Validator;
import db.exception.InvalidEntityException;
import todo.entity.Step;

public class StepValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEntityException{
        if (! (entity instanceof Step))
            throw new IllegalArgumentException("Entity type must be Step.");

        Step step = (Step) entity;
        if (step.getTitle() == null || step.getTitle().isEmpty())
            throw new InvalidEntityException("Title Cannot be null or empty.");

        try {
            Database.get(step.getTaskRef());
        }
        catch (Exception e){
            throw new InvalidEntityException("Task with id " + step.getTaskRef() + "not found.");
        }
    }

}
