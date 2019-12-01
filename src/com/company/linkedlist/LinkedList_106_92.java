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

    //92.反转链表的一部分（反转链表4的改进）
    private static Node reverseBetween(Node head, int m, int n) {
        if (head == null || head.next == null) return head;

        if (m > n || m < 1) return head;
        Node cur = head;
        Node top = null, end = null;
        int len = 0;
        // 找到前一个节点 top，和后一个节点 end
        while (cur != null) {
            len++;
            top = (len == (m - 1)) ? cur : top;
            end = (len == (n + 1)) ? cur : end;
            cur = cur.next;
        }

        if (len == 1) return head;
        Node nodeH = top == null ? head : top.next;
        /*Node nodeH;
        if (top == null)
            nodeH = head;
        else
            nodeH = top.next;*/

        Node next;
        len = n - m;    //此处的长度是用来计算两个节点之间的
        // 进行正常的链表反转
        while (len >= 0) {
            next = nodeH.next;
            // 将反转后的链表的最后一个节点链接到 end 上
            nodeH.next = end;
            end = nodeH;
            nodeH = next;
            len--;
        }
        // 将反转后的链表链接到 top 上
        if (top == null) return end;
        else top.next = end;
        return head;
    }

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

        Node newResult = reverseBetween(result, 2, 3);

        //创建指针遍历打印
        Node temp = result;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println();

        //创建指针遍历打印
        Node newTemp = newResult;
        while (newTemp != null) {
            System.out.println(newTemp.val);
            newTemp = newTemp.next;
        }
    }
}
