package com.mycx26.concurrency.beauty.c2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by mycx26 on 2019-07-04.
 */
public class UnsafeTest2 {

    private static Unsafe unsafe;

    private volatile long state = 0;

    private static long stateOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnsafeTest2.class
                    .getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeTest2 unsafeTest2 = new UnsafeTest2();
        Boolean success = unsafe.compareAndSwapLong(unsafeTest2, stateOffset, 0, 1);
        System.out.println(unsafeTest2.state);
        System.out.println(success);
    }
}
