package com.mycx26.concurrency.firstresult;

import com.mycx26.concurrency.exception.AppException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * simulate login scene
 * <p>
 * Created by mycx26 on 2020/11/3.
 */
public class Client {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        String username = "mycx26";
        String email = "mycx26@test.com";
        String mobile = "00000000000";
        String password = "123456";

        UsernameValidator usernameValidator = new UsernameValidator();
        EmailValidator emailValidator = new EmailValidator();
        MobileValidator mobileValidator = new MobileValidator();

        LoginValidateTask task1 = new LoginValidateTask(usernameValidator, username, password);
        LoginValidateTask task2 = new LoginValidateTask(emailValidator, email, password);
        LoginValidateTask task3 = new LoginValidateTask(mobileValidator, mobile, password);

        List<LoginValidateTask> taskList = Arrays.asList(task1, task2, task3);

        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            String result = executor.invokeAny(taskList);
            System.out.println("=====================> validate success");
        } catch (ExecutionException e) {
            if (e.getCause() instanceof AppException) {
                System.out.println("=====================> validate failure");
            } else {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("main thread end with " + (System.currentTimeMillis() - start) + "ms");
    }
}
