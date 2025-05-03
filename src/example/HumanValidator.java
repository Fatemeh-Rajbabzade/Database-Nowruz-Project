package example;

import db.exception.InvalidEntityException;
import db.Validator;
import db.Entity;

public class HumanValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        // Code for human validation

        if (! (entity instanceof Human))
            throw new IllegalArgumentException("Type of Entity must be Human!");

        Human human = (Human) entity;
        if(human.name == null || human.name.isEmpty())
            throw new InvalidEntityException("Name Cannot be null or empty.");

        if (human.age < 0)
            throw new InvalidEntityException("Age Cannot be negative.");

    }
}