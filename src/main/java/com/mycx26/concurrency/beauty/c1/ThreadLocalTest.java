package com.mycx26.concurrency.beauty.c1;

/**
 * Created by mycx26 on 2019-06-28.
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + ":" + threadLocal.get());
//        if ("threadB".equals(str)) {
            threadLocal.remove();
//        }
    }

    public static void main(String[] args) {
        threadLocal.set("ABC");

        Thread threadA = new Thread(() -> {
            threadLocal.set("A");
            print("threadA");
            System.out.println("threadA get: " + threadLocal.get());
        });

        Thread threadB = new Thread(() -> {
            threadLocal.set("B");
            print("threadB");
            System.out.println("threadB get: " + threadLocal.get());
        });

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadLocal.get());
    }
}
