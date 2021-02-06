package com.github.andriimartynov;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        Thread t = Thread.startVirtualThread(() -> System.out.println("Hello, Loom!"));
        t.join();
    }
}
