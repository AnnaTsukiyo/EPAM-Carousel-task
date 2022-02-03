package com.epam.rd.autotasks;

public class CountDownTask implements Task {
    private int value;

    public CountDownTask(int value) {
        if (value > 0) {
            getValue();
        } else if (value < 0) {
            value = 0;
            isFinished();
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        while (getValue() != 0) {
            value--;
        }
        if (getValue() == 0) {
            isFinished();
        }
    }

    @Override
    public boolean isFinished() {
        return getValue() == 0;
    }
}