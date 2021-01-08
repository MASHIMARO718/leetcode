package com.example.leetcode.juc;

/**
 * @ClassName AbstractQueuedSynchonizerDemo
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/24 16:46
 * @Version 1.0
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread {
    private Lock lock;
    public MyThread(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    public void run () {
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + " running");
        } finally {
            lock.unlock();
        }
    }
}
public class AbstractQueuedSynchonizerDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        MyThread t1 = new MyThread("t1", lock);
        MyThread t2 = new MyThread("t2", lock);
        t1.start();
        t2.start();
    }
}
