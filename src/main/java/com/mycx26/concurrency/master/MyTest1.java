package com.mycx26.concurrency.master;

/**
 * Created by mycx26 on 2019/12/2.
 */
public class MyTest1 {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        synchronized (obj) {
            obj.wait();
        }
    }
}
