package com.example.leetcode.java8;

/**
 * @ClassName interfaceTest
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/29 10:19
 * @Version 1.0
 */
public interface InterfaceTest {
    void test();
    default void test2(){
        System.out.println("love");
    }
    default void test22(){
        System.out.println("love");
    }
}
