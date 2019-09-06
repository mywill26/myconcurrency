package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class SleepTest2 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("threadA sleep");
            try {
                Thread.sleep(5000);
                System.out.println("threadA awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do other thing");
        });

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
