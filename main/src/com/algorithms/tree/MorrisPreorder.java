package com.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorder {
    public List<Integer> preorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        TreeNode current = root;
        while (current!=null){
            if(current.left==null){
                res.add(current.val);
                current = current.right;
            }else{
                TreeNode preDescendant = findPreDescendant(current);
                if(preDescendant.right==null){
                    preDescendant.right = current;
                    res.add(current.val);
                    current = current.left;
                }else{
                    preDescendant.right=null;
                    current = current.right;
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

        MorrisPreorder morrisPreorder = new MorrisPreorder();
        System.out.println(morrisPreorder.preorder(root));
    }
}
