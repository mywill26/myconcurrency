package com.mycx26.concurrency.beauty.c4;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mycx26 on 2019/9/5.
 */
public class AtomicLongTest {

//    private static AtomicLong atomicLong = new AtomicLong();

    private static long count = 0;

    private static Integer[] arrayOne = new Integer[]{ 0, 1, 2, 3, 0, 5, 6, 0, 56, 0 };

    private static Integer[] arrayTwo = new Integer[]{ 10, 1, 2, 3, 0, 5, 6, 0, 56, 0 };

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (Integer i : arrayOne) {
                if (0 == i) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    atomicLong.incrementAndGet();
                    count++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (Integer i : arrayTwo) {
                if (0 == i) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    atomicLong.incrementAndGet();
                    count++;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

//        System.out.println(atomicLong.get());
        System.out.println(count);
    }
}
