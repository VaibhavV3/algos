package com.algorithms.tree;

public class BST {
    private TreeNode root=null;
    public TreeNode insert(int val){
        if(root==null){
            root = new TreeNode(val);
        }else{
            TreeNode temp = root;
            while(true){
                if(temp.val>val){
                    if(temp.left==null) {
                        temp.left = new TreeNode(val);
                        break;
                    }
                    temp=temp.left;
                }else{
                    if(temp.right==null) {
                        temp.right = new TreeNode(val);
                        break;
                    }
                    temp=temp.right;
                }
            }
        }
        return root;
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
        System.out.println(root);
    }
}
