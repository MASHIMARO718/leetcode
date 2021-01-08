package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @ClassName HashMapDemo
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/15 16:47
 * @Version 1.0
 */
public class HashMapDemo {
    public static int a;
    @Test
    public void test(){
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        map.put("S",5);
        map.get("ss");
        int index = 0;
        BlockingQueue queue = new LinkedBlockingQueue(1024);
        for(ConcurrentHashMap<String,Object> f = map;;){
            ConcurrentHashMap<String,Object> pre = f;
            index ++;
            System.out.println(f);
            if(index>20)break;
        }
    }
}


