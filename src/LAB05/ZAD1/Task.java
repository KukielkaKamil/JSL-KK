package LAB05.ZAD1;

import java.util.Date;

public class Task {
    private String title;
    private String description;
    private String priority;
    private String expDate;

    public Task(String title, String description, String priority, String expDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.expDate = expDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    @Override
    public String toString(){
        return title;
    }
}
