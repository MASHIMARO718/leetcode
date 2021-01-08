package com.example.leetcode.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupportDemo
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/24 15:22
 * @Version 1.0
 */
public class LockSupportDemo {
    public void test(){
        LockSupport.park();

    }
}
