package com.mycx26.concurrency.beauty.c7.test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by mycx26 on 2020/4/29.
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        queue.offer("a");
        queue.offer("c");
        queue.offer("b");

        for (int i = 0, size = queue.size(); i < size; i++) {
            System.out.println(queue.poll());
        }
    }
}
