package todo.entity;

import db.Entity;
import db.Trackable;
import java.util.Date;

public class Task extends Entity implements Trackable {
    private String title;
    private String description;
    private Date dueDate;
    private Status status;
    private Date creationDate;
    private Date lastModificationDate;

    public enum Status{
        NotStarted, InProgress, Completed
    }

    public Task(String title, String description, Date dueDate){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        //حالت پیش فرض
        this.status = Status.NotStarted;
    }

    // methods

    @Override
    public int getEntityCode(){
        return 15;
    }

    @Override
    public Task copy(){
        Task copyTask = new Task(title, description, dueDate);
        copyTask.id = id;
        copyTask.status = status;
        copyTask.creationDate = creationDate;
        copyTask.lastModificationDate = lastModificationDate;
        return copyTask;
    }

    @Override
    public  void setCreationDate(Date date){
        this.creationDate = date;
    }

    @Override
    public Date getCreationDate(){
        return creationDate;
    }

    @Override
  public  void setLastModificationDate(Date date){
        this.lastModificationDate = date;
    }

    @Override
    public Date getLastModificationDate(){
        return lastModificationDate;
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
