package com.company.similartree_100;


public class SimilarTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
           return false;
        }
    }


    public static void main(String[] args) {
        TreeNode first = new TreeNode(3);
        first.left = new TreeNode(1);
        first.right = new TreeNode(3);
        TreeNode second = new TreeNode(12);
        second.left = new TreeNode(3);
        second.right = new TreeNode(1);
        boolean isSame = isSameTree(first, second);
        System.out.println(isSame);
    }
}
