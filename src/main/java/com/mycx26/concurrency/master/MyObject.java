package com.mycx26.concurrency.master;

/**
 * Created by mycx26 on 2019/12/3.
 */
public class MyObject {

    private int counter = 0;

    public synchronized void increase() throws InterruptedException {
        while (counter != 0) {
            wait();
        }
        counter++;
        System.out.println(counter);
        notify();
    }

    public synchronized void decrease() throws InterruptedException {
        while (counter != 1) {
            wait();
        }
        counter--;
        System.out.println(counter);
        notify();
    }

    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        new Thread(() -> {
            while (true) {
                try {
                    myObject.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    myObject.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
