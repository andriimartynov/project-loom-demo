package com.github.andriimartynov;

import java.util.Random;
import java.util.concurrent.*;

public class Demo07 {

    private static Random random = new Random();

    public static void main(String[] args) throws Exception {

        try (ExecutorService executor = Executors.newVirtualThreadExecutor()) {
            Callable<String> task1 = () -> one();
            Callable<String> task2 = () -> two();

            Future<String> future1 = executor.submit(task1);
            Future<String> future2 = executor.submit(task2);

            Futurs.completed(future1, future2)
                    .map(Future::join)
                    .forEach(str -> System.out.println(str));
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
