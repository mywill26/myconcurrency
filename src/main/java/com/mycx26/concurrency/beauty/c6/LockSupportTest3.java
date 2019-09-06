package com.mycx26.concurrency.beauty.c6;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by mycx26 on 2019/9/6.
 */
public class LockSupportTest3 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park");

            while (!Thread.currentThread().isInterrupted()) {
                LockSupport.park();
                System.out.println("unpack");
            }

            System.out.println("child thread end park");
        });

        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread start unpack");

//        thread.interrupt();
        LockSupport.unpark(thread);
    }
}
