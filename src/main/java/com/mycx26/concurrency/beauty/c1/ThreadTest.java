package com.mycx26.concurrency.beauty.c1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by mycx26 on 2019-06-26.
 */
public class ThreadTest {

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        MyThread myThread1 = new MyThread();
//        myThread.start();
//        myThread1.start();

//        MyRunnable runnable = new MyRunnable();
//        new Thread(runnable).start();
//        new Thread(runnable).start();

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(this.getName() + " is running");
            System.out.println(this.getName());
            System.out.println(this.getName());
        }
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " runnable thread is running");
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " callable thread is running");

            Thread.sleep(2000);

            return "abc";
        }
    }
}
