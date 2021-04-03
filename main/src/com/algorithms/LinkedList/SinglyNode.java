package com.algorithms.LinkedList;

public class SinglyNode {
    private int value;
    private SinglyNode next;
    SinglyNode(int value,SinglyNode next){
        this.value = value;
        this.next = next;
    }
    SinglyNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyNode getNext() {
        return next;
    }

    public void setNext(SinglyNode next) {
        this.next = next;
    }
}
