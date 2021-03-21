package com.algorithms.tree;


public class TreeUtil {
    public static boolean isFullBinaryTree(TreeNode root){
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        if(root.left!=null && root.right!=null)
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        return false;
    }

    public static boolean isPerfectBinaryTree(TreeNode root){
        int d = getDepth(root);
        return isPerfectBinaryTree(root,d,0);
    }

    private static int getDepth(TreeNode root) {
        int d=0;
        while(root!=null){
            d++;
            root=root.left;
        }
        return d;
    }

    private static boolean isPerfectBinaryTree(TreeNode root,int depth, int i) {
        // this case is literally only for root node.. not any other node... analyze to confirm.
        if(root==null)
            return true;

        // leaf node
        if(root.left==null && root.right==null)
            return depth==i+1;
        // a node where left and root doesn't have same depth
        if(root.left==null || root.right==null)
            return false;
        //normal case
        return isPerfectBinaryTree(root.left,depth,i+1) && isPerfectBinaryTree(root.right,depth,i+1);
    }
}
