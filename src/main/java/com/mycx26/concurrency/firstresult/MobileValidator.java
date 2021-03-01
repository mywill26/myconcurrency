package com.mycx26.concurrency.firstresult;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mycx26 on 2020/11/3.
 */
public class MobileValidator implements LoginValidator {

    @Override
    public boolean validate(String mobile, String password) throws Exception {
        long start = System.currentTimeMillis();
        long duration = (long) (Math.random() * 10);
        TimeUnit.SECONDS.sleep(duration);

        System.out.printf("validate by mobile take [%s] ms\n", System.currentTimeMillis() - start);

        return new Random().nextBoolean();
    }
}
