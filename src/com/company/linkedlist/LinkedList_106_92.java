package com.company.linkedlist;

import java.util.LinkedList;

public class LinkedList_106_92 {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }


    //反转链表1（有新链表作为空间辅助）
    static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) return head;

        Node reHead = null;//新链表
        Node cur = head;
        while (cur != null) {
            Node reCur = cur;
            cur = cur.next;
            reCur.next = reHead;
            reHead = reCur;
        }
        return reHead;
    }

    //反转链表2（没有新链表作为额外空间）
    private static Node reverseLinkedListNew(Node head) {
        if (head == null || head.next == null) return head;

        Node dummyHead = new Node(0);
        dummyHead.next = head;
        while (head.next != null) {
            //1.删除第二个元素
            Node cur = head.next;
            head.next = head.next.next;
            //2.添加到dummyHead之后
            cur.next = dummyHead.next;
            dummyHead.next = cur;
        }
        return dummyHead.next;
    }

    //反转链表3（有新链表作为空间辅助）
    private static Node reverseLinkedListNew2(Node head) {
        if (head == null || head.next == null) return head;

        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node cur = head.next;
        //找到原链表的尾节点
        while (cur.next != null) {
            cur = cur.next;
        }
        Node tail = cur;

        //判断原尾节点是否到了头节点
        while (dummyHead.next != tail) {
            //1.将头节点的元素删除
            cur = dummyHead.next;
            dummyHead.next = cur.next;
            //2.将头节点插入到原尾结点之后
            cur.next = tail.next;
            tail.next = cur;
        }
        return dummyHead.next;
    }

    //反转链表4（没有新链表作为额外空间）
    private static Node reverseLinkedListNew3(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    //92.反转链表的一部分
//    private static Node reverseBetween(Node head, int m, int n) {
//        if (head == null || head.next == null) return head;
//
////        int length = n - m + 1;
//        m--;
//        n--;
//
//        Node newHead = null;
//        Node cur = head;
//    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        cur.next = new Node(2);
        cur = cur.next;
        cur.next = new Node(3);
        cur = cur.next;
        cur.next = new Node(4);
        cur = cur.next;
        cur.next = new Node(5);

        Node result = reverseLinkedListNew3(head);

//        Node newResult = reverseBetween(result, 3, 5);

        //创建指针遍历打印
        Node temp = result;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        //创建指针遍历打印
//        Node newTemp = newResult;
//        while (newTemp != null) {
//            System.out.println(newTemp.val);
//            newTemp = newTemp.next;
//        }
    }
}
