package com.mycx26.concurrency.asynctool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by mycx26 on 2021/3/2.
 */
public class FutureTest {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new Task1());
        new Thread(task).start();

        boolean done = task.isDone();
        System.out.println(done);
        System.out.println("main thread end");
    }
}

class Task1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return "success";
    }
}
