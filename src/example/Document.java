package example;

import db.Database;
import db.Entity;
import db.Trackable;
import java.util.Date;

public class Document extends Entity implements Trackable {
    public String content;
    private Date creationDate;
    private Date lastModificationDate;

    public Document(String content){
        this.content = content;
    }

    //methods

    @Override
    public int getEntityCode() {
        return 14;
    }

    @Override
    public Document copy(){
        Document copyOfDocument = new Document(content);
        copyOfDocument.id = id;
        copyOfDocument.creationDate = creationDate;
        copyOfDocument.lastModificationDate = lastModificationDate;
        return copyOfDocument;

    }

    @Override
   public void setCreationDate(Date date){
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



}
