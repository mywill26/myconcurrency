package com.mycx26.concurrency.firstresult;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mycx26 on 2020/11/3.
 */
public class EmailValidator implements LoginValidator {

    @Override
    public boolean validate(String email, String password) throws Exception {
        long start = System.currentTimeMillis();
        long duration = (long) (Math.random() * 10);
        TimeUnit.SECONDS.sleep(duration);

        System.out.printf("validate by email take [%s] ms\n", System.currentTimeMillis() - start);

        return new Random().nextBoolean();
    }
}
