package com.example.leetcode;

/**
 * @ClassName ListSLinked
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/4 16:05
 * @Version 1.0
 */
public class ListSLinked<T> {
    //比较策略
    private Strategy<T> strategy;
    //头节点
    private SLNode<T> head;
    //链表大小
    private int size;

    public ListSLinked() {
        this.strategy = new DefaultStrategy<>();
        this.head = new SLNode<>();
        this.size = 0;
    }

    public ListSLinked(Strategy<T> strategy) {
        this.strategy = strategy;
        this.head = new SLNode<>();
        this.size = 0;
    }

    /**
     * 将数据插入到第i号位置
     * @param i 下标
     * @param t 要插入的数据
     */
    public void insert(int i,T t){
        if(i < 0 || i > size)throw new IndexOutOfBoundsException();
        SLNode<T> pre = this.getPreNode(i);
        SLNode<T> after = pre.getNext();
        SLNode<T> iNode = new SLNode<>(t,after);
        pre.setNext(iNode);
        size++;
    }

    public void add(T t){
        this.insert(size,t);
    }


    public int indexOf(T t){
        int i = -1;
        SLNode<T> p = head.getNext();
        while (p != null){
            i++;
            if(strategy.equals(p.getData(),t))return i;
            p = p.getNext();
        }
        return -1;
    }


    public SLNode<T> getPreNode(int i){
        return this.getNode(i - 1);
    }

    public SLNode<T> getNode(int i){
        if(i < -1 || i > size - 1)throw new IndexOutOfBoundsException();
        SLNode<T> p = head;
        for(int j = -1;j < i; j++){
            p = p.getNext();
        }
        return p;
    }



    public Strategy<T> getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    public SLNode<T> getHead() {
        return head;
    }

    public void setHead(SLNode<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
