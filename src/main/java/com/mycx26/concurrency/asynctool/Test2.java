package com.mycx26.concurrency.asynctool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by mycx26 on 2020/9/18.
 */
public class Test2 {

    public static void main(String[] args) {
        FutureTask<String> task1 = new FutureTask<>(new Task1());
        FutureTask<String> task2 = new FutureTask<>(new Task1());
        FutureTask<String> task3 = new FutureTask<>(new Task1());

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();

        
    }
}

// simulate username
class Task1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(new Random().nextInt(10) * 1000);
        return "success";
    }
}

// simulate mobile
class Task2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(new Random().nextInt(10) * 1000);
        return "success";
    }
}

// simulate email
class Task3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(new Random().nextInt(10) * 1000);
        return "success";
    }
}
