package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/7 13:13
 * @Version 1.0
 */
public class Sort {


    /**
     * 冒泡排序
     */
    @Test
    public void bubble(){
        int[] arr = {5,8,9,4,1,2,9};
        for (int i = 0;i<arr.length;i++) {
            for(int j = 0;j<arr.length-i-1;j++){
                int temp = arr[j+1];
                if(temp < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     */
    @Test
    public void fast(){
        int[] arr = {5,8,9,4,1,2,9};
        for (int i = 0;i<arr.length;i++) {
            int min = i;
            for(int j = i;j< arr.length-1;j++){
                if(arr[j+1] < arr[min]) min = j+1;
            }
            switchNum(arr,i,min);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSort(){
        int[] arr = {5,8,9,4,1,2,9};
        for(int i = 1;i<arr.length;i++){
            int temp = arr[i];
            int in = i;
            for(;in>0 && arr[in-1]>=temp;in--){
                arr[in] = arr[in-1];
            }
            arr[in] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
    @Test
    public void bitSort(){
        int[] arr = {5,4,1,2};
        byte[] bytes = new byte[2];
        byte bit = 0;
        System.out.println(1<<2);
        for(int i=0;i<arr.length;i++){
            bit = (byte)(bit | (1 << arr[i]));
            System.out.println(Integer.toBinaryString(bit));
        }

    }
    public void switchNum(int[] arr,int i1,int i2){
        int temp = arr[i2];
        arr[i2] = arr[i1];
        arr[i1] = temp;
    }
}
