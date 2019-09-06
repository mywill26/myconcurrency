package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class YieldTest {

    public static void main(String[] args) {
        new YieldThread();
        new YieldThread();
        new YieldThread();
    }
}

class YieldThread implements Runnable {

    YieldThread() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            if (0 == i % 5) {
                System.out.println(Thread.currentThread() + " yield cpu");
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread() + " end");
    }
}
