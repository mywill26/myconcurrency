package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class JoinTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 end");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 start");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread2 end");
        });

        thread1.start();
        thread2.start();

        System.out.println("start wait child thread");

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end wait child thread");
    }
}
