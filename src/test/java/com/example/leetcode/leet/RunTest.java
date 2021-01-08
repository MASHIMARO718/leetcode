package com.example.leetcode.leet;

import org.junit.jupiter.api.Test;

/**
 * @ClassName LeetRun
 * @Description TODO
 * @Author mhJiang
 * @Date 2021/1/6 17:25
 * @Version 1.0
 */
public class RunTest {
    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2,n1);
        ListNode n3 = new ListNode(3,n2);
        ListNode n4 = new ListNode(4,n3);
        ListNode n5 = new ListNode(5,n4);
        ListNode n6 = new ListNode(6,n5);
        ListNode h = swapPairs(n6);
        System.out.println(h);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }
    public void merge(ListNode n1,ListNode n2){
        ListNode res = new ListNode(0);
        ListNode p1 = n1;
        ListNode p2 = n2;
        ListNode p = new ListNode(Math.max(n1.val,n2.val));
        res.next = p;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode pre = new ListNode(0);
        int index = 1;
        while (p != null){
            if(index % 2 == 0){
                swap(pre,p,p.next);
            }
            pre = p;
            p = p.next;
            index ++;
        }
        return head;
    }
    public ListNode swap(ListNode pre,ListNode n1,ListNode n2){
        if(null != pre){
            pre.next = n2;
            if(null != n2)n2.next = n1;
            return n1;
        }
        return null;
    }
}

