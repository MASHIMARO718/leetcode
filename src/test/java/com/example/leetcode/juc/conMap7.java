package com.example.leetcode.juc;

import org.junit.jupiter.api.Test;

/**
 * @ClassName conMap7
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/25 10:47
 * @Version 1.0
 */
public class conMap7 {
    @Test
    public void test(){
        int hash = "testabc".hashCode();
        int j = (hash >>> 28) & 15;
    }
}
