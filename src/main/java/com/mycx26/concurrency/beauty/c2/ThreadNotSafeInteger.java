package com.mycx26.concurrency.beauty.c2;

/**
 * Created by mycx26 on 2019-07-02.
 */
public class ThreadNotSafeInteger {

    private volatile int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
