package com.epam.rd.autotasks;

public class CountDownTask implements Task {
    private int value;
    private boolean runEd = false;

    public CountDownTask(int value) {
        if (value > 0) {
            getValue();
        } else if (value < 0) {
            final var b = this.value == 0;
            isFinished();
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if (runEd) {
            runEd = true;
            getValue();
            value--;
        } else {
            isFinished();
        }
    }

    @Override
    public boolean isFinished() {
        return getValue() == 0;
    }
}