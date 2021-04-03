package com.algorithms.LinkedList;

public class SinglyLinkedList {
    private SinglyNode head=null;
    private SinglyNode tail=null;
    public void insert(int val){
        if(head==null){
            head=new SinglyNode(val);
            tail=head;
        }else{
            tail.setNext(new SinglyNode(val));
            tail=tail.getNext();
        }
    }

    public SinglyNode getHead(){
        return head;
    }

    public void print(){
        SinglyNode temp = head;
        while(temp!=null){
            System.out.print(temp.getValue()+"  ");
            temp=temp.getNext();
        }
        System.out.println();
    }

    public void setHead(SinglyNode newHead) {
        head=newHead;
    }
}
