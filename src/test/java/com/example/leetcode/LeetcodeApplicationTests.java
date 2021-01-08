package com.example.leetcode;

import com.example.leetcode.java8.InterfaceTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

class LeetcodeApplicationTests {
    @Test
    void contextLoads() {
    }

    /*
     * 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        int[] t = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i  = 0;i<nums.length;i++) {
            if(map.containsKey(nums[i])){
                t[0] = map.get(nums[i]);
                t[1] = i;
            }
            map.put(target - nums[i],i);
        }
        return t;
    }
    /*
     * 两数相加
     */
    public ListNode addTwoNumber(ListNode l1, ListNode l2){
        ListNode node = new ListNode(0);
        addTwoNumbers(node,l1,l2,0);
        return node.next;
    }
    /*
     * 两数相加
     */
    public void addTwoNumbers(ListNode nl,ListNode l1, ListNode l2,int up) {

        if(null == l1 && null == l2 && up == 0){
            return;
        }
        if(null == l1) l1 = new ListNode(0);
        if(null == l2) l2 = new ListNode(0);
        int ups = (l1.val+l2.val+up)/10;
        nl.next = new ListNode((l1.val+l2.val+up)%10);

        addTwoNumbers(nl.next,l1.next,l2.next,ups);
    }
    /*
     * 旋转矩阵
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /*
     * 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int start = 0;
        StringBuilder str = new StringBuilder("");
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            for (int j = i;j<chars.length;j++) {
                if (str.indexOf(String.valueOf(chars[j])) < 0) {
                    str.append(chars[j]);
                } else {
                    max = Math.max(max, str.length());
                    start = str.indexOf(String.valueOf(chars[j]));
                    str.delete(0,str.length());break;
                }
                max = Math.max(max, str.length());
            }
            i+=start;
        }
        return max;
    }

    /**
     * 最长回文
     */
    @Test
    public void huiWen(){
        String str = "babad";
        int max = 0;
        String maxHuiWen = "";
        int size = str.length();
        for (int i = 0;i<size;i++) {
            for(int j = 0;j<size-i && j<= i;j++){
                if(!isHuiWen(str.substring(i-j,i+j+1)))break;
                if(max < 2*j+1){
                    max = 2*j+1;
                    maxHuiWen = str.substring(i-j,i+j+1);
                }
            }
        }
        System.out.println(maxHuiWen);
    }
    private boolean isHuiWen(String str){
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder newStr = new StringBuilder("");
        for(int i = 0;i<str.length();i++){
            newStr.append(stack.pop());
        }
        return str.equals(newStr.toString());
    }

    /**
     * Z字形变换
     */
    @Test
    public void convert() {
        String s = "AADFSGSDFEREWFDVGFHFSSDFADSADASDADASD";
        int numRows = 5;
        int r = numRows - 1;
        int l = s.length();
        if(numRows<=1) return ;
        int cols = (s.length()/(2*numRows - 2)+1)*(numRows-1);
        char[][] arr = new char[numRows][cols];
        int index = 0;
        for(int j = 0;j<cols;j++){
            for(int i = 0;i<numRows && index<l;i++){
                if(j%r == 0){
                    arr[i][j] = s.charAt(index);index++;
                }else if( r-i == j%r){
                    arr[i][j] = s.charAt(index);index++;break;
                }
            }
        }
        StringBuilder newChar = new StringBuilder();
        for (char[] ints : arr) {
            for (char anInt : ints) {
                if(anInt != 0)newChar.append(anInt);
            }
        }
        System.out.println(newChar);
    }
    public String convert(String s, int numRows) {
        int cols = (s.length()/(2*numRows - 2)+1)*(numRows-1);
        char[][] arr = new char[numRows][cols];
        int index = 0;
        for(int j = 0;j<cols;j++){
            for(int i = 0;i<numRows && index<s.length();i++){
                if(j%(numRows-1) == 0){
                    arr[i][j] = s.charAt(index);index++;
                }else if(numRows-1-i == j%(numRows-1)){
                    arr[i][j] = s.charAt(index);index++;
                }
            }
        }
        StringBuilder newChar = new StringBuilder();
        for (char[] ints : arr) {
            for (char anInt : ints) {
                if(anInt != 0)newChar.append(anInt);
            }
        }
        return newChar.toString();
    }

    /**
     * 盛最多水的容器
     */
    @Test
    public void maxArea() {
        int[] height = {1,2,3,4,11,3,4,5,6,7,9};
        int max = 0;
        int start = 0,end = height.length-1;
        for (int i = 0;i<height.length && start<end;i++){
            max = Math.max(max,Math.min(height[start],height[end]) * (end-start));
            if(start == end) break;
            if(height[start] >= height[end]){
                end-=1;
            }else {
                start+=1;
            }
        }
        System.out.println(max);
    }
    public String longestCommonPrefix() {
        String[] strs = {"flower","flow","flight"};
        int min = strs[0].length();
        char[][] chars = new char[strs.length][min];
        for (int i = 0;i<strs.length;i++) {
            chars[i]=strs[i].substring(0,min).toCharArray();
        }
        return null;
    }

    /**
     * 三数之和
     */
    @Test
    public void threeSum() {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> sets = new HashSet<>();
        int index = 0;
        for(int i = 0;i<ints.length;i++){
            for(int j = i+1;j<ints.length;j++){
                for(int k = i+2;k<ints.length;k++){
                    if(ints[i]+ints[j]+ints[k] == 0){
                        List<Integer> list = new ArrayList<>();
                    }
                }
            }
        }
    }
    @Test
    public void removeNthFromEnd() {
        ListNode n5 = new ListNode(5,null);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        ListNode h = new ListNode(0,n1);
        int n = 5;
        ListNode t = h;
        Stack<ListNode> stack = new Stack<>();
        while (null != t){
            stack.push(t); t = t.next;
        }
        for(int i = 0;i<n;i++){
            stack.pop();
        }
        ListNode pre = stack.pop();
        pre.next = pre.next.next;
        System.out.println(h.next);
    }
    @Test
    public void isValid() {
        String s = "{[{[()]}])}";
        String[] strs = s.split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(!stack.isEmpty()&& match(stack.peek(),strs[i])){
                stack.pop();
            }else {
                stack.push(strs[i]);
            }
        }
        System.out.println(stack.isEmpty());
    }
    @Test
    public void isValid2() {
        String s = "{[{[()]}])}";
        String[] str = s.split("");
        for(int i = 1;i<s.length();i++){
            if(match(str[i-1],str[i])){

            }
        }
    }
    public boolean match(String n,String s){
        switch (s){
            case "}":return n.equals("{");
            case "]":return n.equals("[");
            case ")":return n.equals("(");
            default:return false;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1 != null){
            nodes.add(h1);h1 = h1.next;
        }
        while (h2 != null){
            nodes.add(h2);h2 = h2.next;
        }
        nodes.sort(Comparator.comparingInt(o -> o.val));
        if(nodes.size() == 0) return null;
        for (int i = 0;i<nodes.size();i++) {
            if(i == nodes.size() -1) {
                nodes.get(i).next = null;
            }else {
                nodes.get(i).next = nodes.get(i+1);
            }
        }
        return nodes.get(0);
    }
    @Test
    public void syncABC(){
        new Thread(()->printABC(),"Num").start();
        new Thread(()->printABC(),"LETTER").start();
    }
    static final Object lock = new Object();
    public static void printABC(){
        synchronized (lock){
            for(int i = 0;i < 26;i++){
                if(Thread.currentThread().getName().equals("Num")){
                    System.out.print(i+1);
                }else if(Thread.currentThread().getName().equals("LETTER")){
                    System.out.print((char) ('A'+i));
                }
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Test
    public void tes(){
        Instant instant1 = Instant.now();
        System.out.println(instant1.getEpochSecond());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}

