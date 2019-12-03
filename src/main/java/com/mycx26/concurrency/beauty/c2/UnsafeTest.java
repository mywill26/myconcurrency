package com.mycx26.concurrency.beauty.c2;

import sun.misc.Unsafe;

/**
 * Created by mycx26 on 2019-07-04.
 */
public class UnsafeTest {

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    private volatile long state = 0;

    private static long stateOffset;

    static {
        try {
            stateOffset = unsafe
                    .objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeTest unsafeTest = new UnsafeTest();

        Boolean flag = unsafe.compareAndSwapInt(unsafeTest, stateOffset, 0, 1);
        System.out.println(flag);
    }
}
