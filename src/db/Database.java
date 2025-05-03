package db;

import db.exception.EntityNotFoundException;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static int currentId = 1;

    private Database() {
    }

    //methods
    //e موجودیت است
    public static void add(Entity e) {
        e.id = currentId++;
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

    public static void update(Entity e) throws EntityNotFoundException {
        //کپی کردن
        Entity copyEntity = e.copy();

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