package com.mycx26.concurrency.beauty.c1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class SleepTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            lock.lock();
            System.out.println("threadA sleep");
            try {
                Thread.sleep(1000);

                System.out.println("threadA awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            System.out.println("threadB sleep");
            try {
                Thread.sleep(1000);

                System.out.println("threadB awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();
    }
}
