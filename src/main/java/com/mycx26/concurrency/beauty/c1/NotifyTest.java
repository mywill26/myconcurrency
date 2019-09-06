package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-27.
 */
public class NotifyTest {

    private static volatile Object r1 = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (r1) {
                System.out.println("threadA get r1 lock");

                try {
                    System.out.println("threadA begin wait");
                    r1.wait();
                    System.out.println("threadA end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (r1) {
                System.out.println("threadB get r1 lock");

                try {
                    System.out.println("threadB begin wait");
                    r1.wait();
                    System.out.println("threadB end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (r1) {
                System.out.println("threadC get r1 lock");

                System.out.println("threadC begin notify");
                r1.notifyAll();
                System.out.println("threadC end notify");
            }
        });

        threadA.start();
        threadB.start();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");
    }
}
