package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class InterruptTest4 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("child thread isInterrupt1: "
                    + Thread.currentThread().isInterrupted());
            while (!Thread.interrupted()) {     // 当前线程
            }

            System.out.println("child thread isInterrupt: "
                    + Thread.currentThread().isInterrupted());
        });

        thread.start();
        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");
    }
}
