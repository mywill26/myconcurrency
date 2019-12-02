package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019/12/2.
 */
public class InterruptTest3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
          for(;;) {
          }
        });

        thread1.start();

        thread1.interrupt();

        System.out.println("thread1 is interrupted: " + thread1.isInterrupted());

        System.out.println("thread interrupted: " + thread1.interrupted());

        System.out.println("thread interrupted: " + Thread.interrupted());

        System.out.println("thread1 is interrupted: " + thread1.isInterrupted());

        thread1.join();

        System.out.println("main thread is end");
    }
}
