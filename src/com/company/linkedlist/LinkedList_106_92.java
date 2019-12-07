package com.company.linkedlist;

public class LinkedList_106_92 {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }


    //反转链表1（有新链表作为空间辅助）
    private static Node reverseLinkedList(Node head) {
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

    // 反转链表5（利用递归的方式）
    private static Node reverseLinkedListNew4(Node head) {
        if (head == null || head.next == null) return head;

        Node last = reverseLinkedListNew4(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //92.反转链表的一部分（递归的方式，找到反转部分的第一节点和最后节点两两交换，直到两个指针指向最中间位置）
    private static Node reverseBetweenNew(Node head, int m, int n) {
        if (m == 1)
            return reverseN(head, n);

        head.next = reverseBetweenNew(head.next, m - 1, n - 1);
        return head;
    }

    private static Node successor = null;

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    private static Node reverseN(Node head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        Node last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
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

    //将两个链表进行合并排序(递归)
    private static Node mergeListNew(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node resultNode;
        if (list1.val <= list2.val) {
            resultNode = new Node(list1.val);
            list1 = list1.next;
        } else {
            resultNode = new Node(list2.val);
            list2 = list2.next;
        }

        resultNode.next = mergeListNew(list1, list2);
        return resultNode;
    }

    //将两个链表进行合并排序(迭代)
    private static Node mergeList(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node dummyNode = new Node(0);
        Node tempNode = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tempNode.next = new Node(list1.val);
                //TODO: 以下方式改变list1的结构
//                tempNode.next = list1;
                list1 = list1.next;
            } else {
                tempNode.next = new Node(list2.val);
                //TODO: 以下方式改变list2的结构
//                tempNode.next = list2;
                list2 = list2.next;
            }
            tempNode = tempNode.next;
        }

        if (list1 != null) {
            tempNode.next = list1;
        } else {
            tempNode.next = list2;
        }

        return dummyNode.next;
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

        Node newHead = new Node(-3);
        Node newCur = newHead;
        newCur.next = new Node(0);
        newCur = newCur.next;
        newCur.next = new Node(3);
        newCur = newCur.next;
        newCur.next = new Node(6);
        newCur = newCur.next;
        newCur.next = new Node(7);

        Node resultNode = mergeListNew(head, newHead);

//        Node l1 = new Node(1);
//        l1.next = new Node(2);
//        l1.next.next = new Node(4);
//        Node l2 = new Node(1);
//        l2.next = new Node(3);
//        l2.next.next = new Node(4);

        Node result = reverseLinkedList(head);

        //创建指针遍历打印
        Node temp = result;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println();

        //创建指针遍历打印
        Node newTemp = reverseBetweenNew(result, 2, 3);
        while (newTemp != null) {
            System.out.println(newTemp.val);
            newTemp = newTemp.next;
        }

        System.out.println("==========合并链表===========");
        Node tempNode = resultNode;
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }
}
