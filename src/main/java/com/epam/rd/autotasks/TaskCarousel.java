package com.epam.rd.autotasks;

import java.util.List;

public class TaskCarousel {

    private int capacity;
    List taskArrayList;

    private int execute_pointer;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        if (task == null && task.isFinished() && taskArrayList.size() < 0) {
            return false;
        } else {
            taskArrayList.add(task);
            return true;
        }
    }

    public boolean execute() {
        if (isEmpty())
            return false;
        execute_pointer++;

        if (execute_pointer >= taskArrayList.size()) {
            execute_pointer = 0;
        }
        Task currentTask = (Task) taskArrayList.get(execute_pointer);

        if (currentTask != null && !currentTask.isFinished()) {
            currentTask.execute();
            if (currentTask.isFinished()) {
                deleteTask(execute_pointer);
                execute_pointer--;
            }
            return true;
        } else return execute();
    }

    public boolean isFull() {
        if (capacity == 0 && taskArrayList.size() < 0) {
            return true;
            //, который возвращает true если в карусели больше нет места для добавления другой задачи. В противном случае возвращает false.
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (execute_pointer == 0) {               // возвращает true если в карусели нет задачи для выполнения.
            return true;
        } else {
            return false;
        }
    }

    public void deleteTask(int execute_pointer) {
        taskArrayList.remove(execute_pointer);
    }
}