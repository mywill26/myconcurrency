package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-27.
 */
public class WaitNotifyInterrupt {

    static Object obj = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("child thread start");

            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("child thread end");
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("begin interrupt child thread");

        thread.interrupt();

        System.out.println("end interrupt child thread");
    }
}
