package com.example.leetcode;

/**
 * @ClassName SLNode
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/4 15:56
 * @Version 1.0
 */
public class SLNode<T> implements Node<T>{

    private T el;
    private SLNode<T> next;

    public SLNode() {
    }

    public SLNode(T el, SLNode<T> next) {
        this.el = el;
        this.next = next;
    }

    public SLNode<T> getNext(){
        return next;
    }
    public void setNext(SLNode<T> next){
        this.next = next;
    }

    @Override
    public T getData() {
        return this.el;
    }

    @Override
    public void setData(T t) {
        this.el = t;
    }
}
