package com.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPostorder {

    private List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;

        TreeNode current=dummy;

        while(current!=null){
            if(current.left==null){
                current=current.right;
            }else{
                TreeNode preDecessor = findPreDescendant(current);
                if(preDecessor.right==null){
                    preDecessor.right=current;
                    current=current.left;
                }else{
                    preDecessor.right=null;
                    TreeNode act = current;
                    current = current.left;
                    TreeNode prev=null,temp=null;

                    while(current!=null){
                        temp=current.right;
                        current.right=prev;
                        prev=current;
                        current=temp;
                    }

                    while(prev!=null){
                        res.add(prev.val);
                        temp=prev.right;
                        prev.right=current;
                        current=prev;
                        prev=temp;
                    }

                    current = act.right;
                }
            }
        }
        return res;
    }

    private TreeNode findPreDescendant(TreeNode node) {
        TreeNode current = node.left;
        while (current.right!=null && current.right!=node)
            current = current.right;
        return current;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(30);
        bst.insert(60);
        bst.insert(40);
        bst.insert(-2);
        bst.insert(6);
        bst.insert(8);
        bst.insert(2);
        bst.insert(-1);
        bst.insert(35);
        bst.insert(45);
        TreeNode root = bst.insert(80);

        MorrisPostorder morrisPostorder = new MorrisPostorder();
        System.out.println(morrisPostorder.postorder(root));
    }
}
