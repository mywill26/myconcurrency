package com.mycx26.concurrency.beauty.c2;

/**
 * Created by mycx26 on 2019-07-04.
 */
public class ReorderTest {

    private static int num = 0;

    private static boolean ready = false;

    public static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
                System.out.println("read thread...");
            }
            System.out.println("read thread end");
        }
    }

    public static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("write thread end");
        }
    }

    public static void main(String[] args) {
        ReadThread readThread = new ReadThread();
        WriteThread writeThread = new WriteThread();

        readThread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writeThread.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        readThread.interrupt();

        System.out.println("main thread end");
    }
}


