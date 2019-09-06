package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-27.
 */
public class NotifyWaitTest {

    private static Object r1 = new Object();

    private static Object r2 = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
           synchronized (r1) {
               System.out.println("threadA get 1 lock");

               System.out.println("threadA try get 2 lock...");

               synchronized (r2) {
                   System.out.println("threadA get 2 lock");

                   System.out.println("threadA release 1 lock");
                   try {
                       r1.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        });

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (r1) {
                System.out.println("threadB get 1 lock");

                System.out.println("threadB try get 2 lock...");

                synchronized (r2) {
                    System.out.println("threadB get 2 lock");

                    System.out.println("threadB release 2 lock");
                    try {
                        r2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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

        System.out.println("over");
    }
}
