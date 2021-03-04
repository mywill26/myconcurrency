package com.mycx26.concurrency.asynctool;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest3 {

    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

//        // 用anyOf合并为一个新的CompletableFuture:
//        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);
//        System.out.println("abc");
//
//        // 两个CompletableFuture执行异步查询:
//        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
//            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
//        });
//        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
//            return fetchPrice((String) code, "https://money.163.com/price/");
//        });
//
//        // 用anyOf合并为一个新的CompletableFuture:
//        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);
//        System.out.println("def");
//
//        // 最终结果:
//        cfFetch.thenAccept((result) -> {
//            System.out.println("price: " + result);
//        });

        CompletableFuture.allOf(cfQueryFromSina, cfQueryFromSina);
        System.out.println("abc");

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    private static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        if ("https://finance.sina.com.cn/code/".equals(url)) {
            return "123";
        } else {
            return "456";
        }
//        return "601857";
    }

    private static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        if ("123".equals(code)) {
            return 100.0;
        } else {
            return 200.0;
        }
//        return 5 + Math.random() * 20;
    }
}