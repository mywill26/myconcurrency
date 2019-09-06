package com.mycx26.concurrency.beauty.c6;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by mycx26 on 2019/9/6.
 */
public class LockSupportTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 begin park");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            LockSupport.park();
            System.out.println("thread1 end park");
        });

        thread1.start();

        LockSupport.unpark(thread1);

//        thread1.interrupt();
    }
}
