package com.company.flipbinarytree_226;

public class FlipBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTreeWithRecursion(TreeNode root) {
        TreeNode temp;

        if (root != null) {
            temp = invertTreeWithRecursion(root.right);
            root.right = invertTreeWithRecursion(root.left);
            root.left = temp;
        }

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;



        return root;
    }

    public static void main(String[] args) {

    }
}
