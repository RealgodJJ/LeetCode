package com.company.binarytree.nearestpublicancestorofbinarysearchtree_235;

public class LowestCommonAncestor {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        else if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        } else {
            if (root.val - p.val > 0) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, root.left, root.right);
        System.out.println(lowestCommonAncestor.val);
    }
}
