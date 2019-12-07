package com.company.binarytree;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //分层遍历二叉树(使用队列)
    private static void levelTraversal(TreeNode root) {
        if (root == null) return;

        //注解：LinkedList实现了队列
        LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode curNode = treeNodeQueue.remove();
            System.out.println(curNode.val);

            if (curNode.left != null) {
                treeNodeQueue.add(curNode.left);
            }
            if (curNode.right != null) {
                treeNodeQueue.add(curNode.right);
            }
        }
    }

    //深度遍历二叉树(使用栈，递归)
    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        if (root.left != null) {
            preOrderTraversal(root.left);
        }

        if (root.right != null) {
            preOrderTraversal(root.right);
        }
    }

    //深度遍历二叉树(使用栈，迭代)
    private static void preOrderTraversalNew(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>(); // 辅助stack
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();  // 出栈栈顶元素
            System.out.println(cur.val);
            // 关键点：要先压入右孩子，再压入左孩子，这样在出栈时会先打印左孩子再打印右孩子
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
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

        levelTraversal(root);
        System.out.println();

        preOrderTraversal(root);
        System.out.println();

        preOrderTraversalNew(root);
        System.out.println();
    }
}
