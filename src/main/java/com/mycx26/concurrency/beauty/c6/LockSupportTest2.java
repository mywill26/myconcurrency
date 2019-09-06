package com.mycx26.concurrency.beauty.c6;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by mycx26 on 2019/9/6.
 */
public class LockSupportTest2 {

    public static void main(String[] args) {
        System.out.println("begin park");

        LockSupport.park();

        LockSupport.unpark(Thread.currentThread());

        System.out.println("end park");
    }
}
