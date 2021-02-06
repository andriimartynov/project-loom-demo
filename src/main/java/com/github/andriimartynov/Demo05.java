package com.github.andriimartynov;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo05 {

    private static Random random = new Random();

    public static void main(String[] args) throws Exception {

        try (ExecutorService executor = Executors.newVirtualThreadExecutor()) {
            Callable<String> task1 = () -> one();
            Callable<String> task2 = () -> two();

            String result = executor.invokeAny(Arrays.asList(task1, task2));

            System.out.println(result);
        }

    }

    private static String one() throws InterruptedException {
        Thread.sleep(timeout());
        return "one";
    }

    private static String two() throws InterruptedException {
        Thread.sleep(timeout());
        return "two";
    }

    private static long timeout() {
        return random.nextInt(10) * 100L;
    }
}
