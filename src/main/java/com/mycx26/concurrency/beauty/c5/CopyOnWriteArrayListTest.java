package com.mycx26.concurrency.beauty.c5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by mycx26 on 2019/9/5.
 */
public class CopyOnWriteArrayListTest {

    private static volatile CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        list.add("hello");
        list.add("world");
        list.add("welcome");
        list.add("to");
        list.add("hangzhou");

        Thread thread1 = new Thread(() -> {
            list.set(1, "abc");
            list.remove(2);
            list.remove(3);
        });

        Iterator<String> itr = list.iterator();

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
