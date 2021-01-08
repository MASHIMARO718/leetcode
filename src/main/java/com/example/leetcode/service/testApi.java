package com.example.leetcode.service;

public interface testApi {
    default String get(){
        return "123";
    }
    default String get2(){
        return "2";
    }
}
