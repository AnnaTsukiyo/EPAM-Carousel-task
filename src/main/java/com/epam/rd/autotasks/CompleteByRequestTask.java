package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    Task currentTask;
    private int execute_pointer;

    public CompleteByRequestTask() {
    }

    @Override
    public void execute() {
        if (currentTask != null && !currentTask.isFinished()) {
            currentTask.execute();
        } else {
            complete();
        }
    }

    @Override
    public boolean isFinished() {
        if (currentTask == null) {
            return true;
        } else {
            execute_pointer++;
            return false;
        }
    }

    public void complete() {
        if (currentTask.isFinished() == true) {
            currentTask.isFinished();
        }
    }
}