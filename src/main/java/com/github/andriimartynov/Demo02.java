package com.github.andriimartynov;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        Thread t = Thread.startVirtualThread(Thread::dumpStack);
        t.join();
    }
}
