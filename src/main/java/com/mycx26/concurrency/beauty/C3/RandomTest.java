package com.mycx26.concurrency.beauty.C3;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 5; ++i) {
            System.out.println(random.nextInt(5));
        }
    }
}
