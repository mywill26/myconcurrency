package com.mycx26.concurrency.beauty.c6;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by mycx26 on 2019/9/6.
 */
public class LockSupportTest4 {

    public void testPark() {
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        LockSupportTest4 test4 = new LockSupportTest4();
        test4.testPark();
    }
}
