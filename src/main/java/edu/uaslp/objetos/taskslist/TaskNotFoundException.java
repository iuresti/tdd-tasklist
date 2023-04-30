package edu.uaslp.objetos.taskslist;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException (String message){
        super("Task with title '"+message+"' not found");
    }
}
