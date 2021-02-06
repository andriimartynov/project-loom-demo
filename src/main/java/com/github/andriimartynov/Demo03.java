package com.github.andriimartynov;

import java.util.concurrent.ThreadFactory;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        ThreadFactory factory = Thread
                .builder()
                .name("worker-", 0)
                .factory();
    }
}
