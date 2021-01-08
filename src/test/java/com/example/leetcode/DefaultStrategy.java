package com.example.leetcode;

/**
 * @ClassName DefaultStrategy
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/4 16:13
 * @Version 1.0
 */
public class DefaultStrategy<T> implements Strategy<T>{
    @Override
    public boolean equals(T t1, T t2) {
        return t1.equals(t2);
    }

    @Override
    public int compare(T t1, T t2) {
        return t1.hashCode() - t2.hashCode();
    }
}
