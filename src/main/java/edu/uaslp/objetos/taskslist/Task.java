package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;

public class Task{
    //Task task = new Task("Lavar los trastes", "Lavar los trastes sin tirar mucha agua", dateInFuture, false);
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Boolean completed = false;

    public Task(){

    }

    public Task(String newTitle, String newDescription, LocalDateTime newDueDate, Boolean isCompleted){
        title = newTitle;
        description = newDescription;
        dueDate = newDueDate;
        completed = isCompleted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) throws TaskListException{
        validateDueDate(dueDate);
        this.dueDate = dueDate;
    }

    public void setDone(Boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Boolean isDone() {
        return completed;
    }

    public void validateDueDate(LocalDateTime date) throws TaskListException{
        if (date.isBefore(LocalDateTime.now())){
            throw new TaskListException("Due date is set in the past");
        }
    }
}
