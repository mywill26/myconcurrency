package com.mycx26.concurrency.beauty.c7.test;

import java.util.PriorityQueue;

/**
 * Created by mycx26 on 2020/4/28.
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer("贵树");
        priorityQueue.offer("明理");
        priorityQueue.offer("花苗");

        priorityQueue.forEach(System.out::println);     // 先出最小的
//        System.out.println(priorityQueue);

        System.out.println("==============");

        for (int i = 0; i < 10; i++) {
//            System.out.println(priorityQueue.peek());
            System.out.println(priorityQueue.poll());
        }

        System.out.println(priorityQueue);
    }
}
