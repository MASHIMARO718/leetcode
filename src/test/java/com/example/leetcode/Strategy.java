package com.example.leetcode;

public interface Strategy<T> {
    boolean equals(T t1,T t2);
    int compare(T t1,T t2);
}
