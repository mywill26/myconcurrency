package com.mycx26.concurrency.asynctool.callback;

/**
 * Created by mycx26 on 2021/3/5.
 */
public class Bootstrap {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();

        Worker worker = bootstrap.newWorker();

        Wrapper wrapper = new Wrapper();
        wrapper.setParam("hello");
        wrapper.setWorker(worker);
        wrapper.setListener(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        bootstrap.doWork(wrapper);

        System.out.println(Thread.currentThread().getName());
    }

    private Worker newWorker() {
        return object -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            return object + " world";
        };
    }

    private Wrapper doWork(Wrapper wrapper) {
        new Thread(() -> {
            Worker worker = wrapper.getWorker();
            String result = worker.action(wrapper.getParam());
            wrapper.getListener().callback(result);
        }).start();

        return wrapper;
    }
}
