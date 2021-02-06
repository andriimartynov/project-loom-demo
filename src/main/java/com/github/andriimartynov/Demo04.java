package com.github.andriimartynov;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Demo04 {
    public static void main(String[] args) throws Exception {
        AtomicInteger counter = new AtomicInteger();

        try (ExecutorService executor = Executors.newVirtualThreadExecutor()) {
            IntStream.range(0, 1000000)
                    .forEach(i -> executor.submit(counter::incrementAndGet));

        }
        System.out.println(counter.get());
    }
}
