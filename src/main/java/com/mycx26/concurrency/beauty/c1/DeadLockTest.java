package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class DeadLockTest {

    private static Object r1 = new Object();

    private static Object r2 = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (r1) {
                System.out.println("threadA get r1 lock");

                synchronized (r2) {
                    System.out.println("threadA get r2 lock");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (r2) {
                System.out.println("threadB get r2 lock");

                synchronized (r1) {
                    System.out.println("threadB get r1 lock");
                }
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");
    }
}
