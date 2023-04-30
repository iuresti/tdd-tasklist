package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskList {
    private final ArrayList<Task> list;

    public TaskList(){
        list = new ArrayList<>();
    }

    public void add(Task newTask){
        list.add(newTask);
    }

    public void remove(Task badTask){
        list.remove(badTask);
    }

    public Task find(String neededTask) throws TaskNotFoundException {
        Task returnTask = null;
        for (Task item : list){
            if (neededTask.equals(item.getTitle())){
                returnTask = item;
            }
        }
        validateTaskNotFoundException(returnTask, neededTask);
        return returnTask;
    }

    public void markAsDone(String doneTask){
        for (Task item : list){
            if (doneTask.equals(item.getTitle())){
                item.setDone(true);
            }
        }
    }

    public void  markAsNotDone(String undoneTask){
        for (Task item : list){
            if (undoneTask.equals(item.getTitle())){
                item.setDone(false);
            }
        }
    }

    public Task getNextTask(){
        Task nextTask = new Task();
        nextTask.setDueDate(LocalDateTime.now().plusYears(100));
        for (Task item : list){
            LocalDateTime itemDate = item.getDueDate();
            if (!item.isDone() && itemDate.isBefore(nextTask.getDueDate())){
                nextTask = item;
            }
        }
        return nextTask;
    }

    public ArrayList<Task> getNextTasks(){
        ArrayList<Task> returnList = new ArrayList<>();
        for (Task item : list){
            if (!item.isDone()){
                returnList.add(item);
            }
        }

        returnList.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getDueDate().compareTo(o2.getDueDate());
            }
        });

        return returnList;
    }

    /*
    private void sortList(ArrayList<Task> list){
        int n = list.size();
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (list[i].)
            }
        }

    }
*/

    public int getSize() {
        return list.size();
    }

    private void validateTaskNotFoundException(Task validate, String taskTitle){
        if(validate == null){
            throw new TaskNotFoundException(taskTitle);
        }
    }
}
