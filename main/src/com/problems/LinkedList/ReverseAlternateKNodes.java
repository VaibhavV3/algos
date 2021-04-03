package com.problems.LinkedList;

import com.algorithms.LinkedList.SinglyLinkedList;
import com.algorithms.LinkedList.SinglyNode;

/**
 * Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way. Give the complexity of your algorithm.
 */
public class ReverseAlternateKNodes {
    public SinglyNode reverseKNodes(SinglyNode head,int k) {
        head = reverseKNodesWithFlag(head,k,true);
        return head;
    }

    private SinglyNode reverseKNodesWithFlag(SinglyNode node, int k, boolean b) {
        if(node==null)
            return null;
        if(b){
            SinglyNode prev=null,curr=node,next=null;
            int tk=k;
            while(tk>0 && curr!=null){
                next=curr.getNext();

                curr.setNext(prev);
                prev=curr;
                curr=next;
                tk--;
            }
            node.setNext(reverseKNodesWithFlag(curr,k,!b));
            return prev;
        }else{
            int tk=k;
            SinglyNode curr=node;
            while(tk>1 && curr!=null){
                curr=curr.getNext();
                tk--;
            }
            curr.setNext(reverseKNodesWithFlag(curr.getNext(),k,!b));
            return node;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.print();

        list.setHead(new ReverseAlternateKNodes().reverseKNodes(list.getHead(),3));

        list.print();
    }
}
