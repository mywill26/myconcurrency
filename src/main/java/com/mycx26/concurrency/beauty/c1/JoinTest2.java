package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class JoinTest2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 start");

            for(;;) {

            }
        });

        Thread mainThread = Thread.currentThread();

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 start");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainThread.interrupt();
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("main thread" + e);
        }
    }
}
