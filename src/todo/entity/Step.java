package todo.entity;

import db.Entity;

public class Step extends Entity {
    private String title;
    private Status status;
    private int taskRef;

    public enum Status{
        NotStarted, Completed
    }

    public Step(String title, int taskRef){
        this.title = title;
        this.taskRef = taskRef;
        this.status = Status.NotStarted;
    }

    public void setTaskRef(int taskRef){
        this.taskRef = taskRef;
    }

    public int getTaskRef(){
        return taskRef;
    }
    @Override
    public int getEntityCode(){
        return 16;
    }

    @Override
    public Step copy(){
        Step copyOfStep = new Step(title, taskRef);
        copyOfStep.id = id;
        copyOfStep.status = status;
        return copyOfStep;
    }

    //setter & getter
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Status getStatus(){
        return status;
    }
}
