package com.mycx26.concurrency.beauty.c2;

/**
 * Created by mycx26 on 2019-07-02.
 */
public class ThreadNotSafeCount {

    private Long value;

    public synchronized Long getCount() {
        return value;
    }

    public synchronized void inc() {
        ++value;
    }

    public static void main(String[] args) {
        System.out.println("abc");
    }
}
