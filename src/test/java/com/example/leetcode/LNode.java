package com.example.leetcode;

/**
 * @ClassName LinkList
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/4 14:53
 * @Version 1.0
 */
public class LNode<T> {
    private T data;
    LNode<T> next;
    private int size;
    public LNode(){
        this.data = null;
        this.size = 0;
    }
    public LNode(T t,int size){
        this.data = t;
        this.size = size;
    }
    void add(T t){
        LNode<T> lNode = new LNode<T>(t,0);
        if(size < 1){
            this.data = t;
        }else {
            LNode<T> e = getNode(size - 1);
            e.next = lNode;
        }
        size ++ ;
    }
    LNode<T> getNode(int index){
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) return this;
        LNode<T> t = this;
        for(int i = 1;i<=index;i++){
            t = t.next;
        }
        return t;
    }
    void setData(T t){
        this.data = t;
    }
    public T get(int index){
        return this.getNode(index).data;
    }

    public int getSize() {
        return size;
    }
}
