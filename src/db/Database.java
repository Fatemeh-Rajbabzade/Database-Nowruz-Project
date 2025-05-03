package db;

import db.exception.EntityNotFoundException;
import db.exception.InvalidEntityException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static int currentId = 1;
    private static HashMap<Integer, Validator> validators = new HashMap<>();

    private Database() {
    }

    //method for validator
    public static void registerValidator(int entityCode, Validator validator) {
        if(validators.containsKey(entityCode)){
            throw new IllegalArgumentException("This validator already registered with entity code: " + entityCode);
        }
        validators.put(entityCode, validator);
    }

    //methods
    //e موجودیت است
    public static void add(Entity e) throws InvalidEntityException{
        //موجودیت رو اعتیار سنجی کند
        Validator validator = validators.get(e.getEntityCode());
        if (validator != null) {
            validator.validate(e);
        }
        e.id = currentId++;
        //Date for e
        if (e instanceof Trackable){
            Date currentDate = new Date();
            Trackable trackable = (Trackable) e;
            trackable.setCreationDate(currentDate);
            trackable.setLastModificationDate(currentDate);
        }

        //کپی کردن entity
        Entity copyEntity = e.copy();
        entities.add(copyEntity);
    }

    public static Entity get(int id) throws EntityNotFoundException {
        for (Entity e : entities) {
            if (e.id == id)
                return e.copy();
        }
        throw new EntityNotFoundException(id);

    }

    public static void delete(int id) throws EntityNotFoundException {
        int entitiesLength = entities.size();
        for (int i = 0 ; i < entitiesLength ; i++){
            if (entities.get(i).id == id){
                entities.remove(i);
                return;
            }
        }
        throw new EntityNotFoundException(id);
    }

    public static void update(Entity e) throws EntityNotFoundException , InvalidEntityException{
        //کپی کردن
        Entity copyEntity = e.copy();
        // ولیدیتور برای موجودیت
        Validator validator = validators.get(e.getEntityCode());
        if (validator != null) {
            validator.validate(e);
        }

        //updated Date for e
        if (e instanceof Trackable){
            Date currentDate = new Date();
            Trackable trackable = (Trackable) e;
            //we need only updated time
            trackable.setLastModificationDate(currentDate);
        }

        int entitiesLength = entities.size();
        for (int i = 0; i < entitiesLength; i++) {
            if (entities.get(i).id == copyEntity.id) {
                entities.set(i, copyEntity);
                return;
            }
        }
        throw new EntityNotFoundException(e.id);
    }
}