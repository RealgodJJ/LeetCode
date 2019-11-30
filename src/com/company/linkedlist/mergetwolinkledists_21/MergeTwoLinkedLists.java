package com.company.linkedlist.mergetwolinkledists_21;

public class MergeTwoLinkedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        if (l1 != null)
            current.next = l1;
        else
            current.next = l2;

        return head.next;
    }

    private static ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists_1(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists_1(l1.next, l2);
            return l1;
        }
    }

    public static void main(String[] args) {
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode result = mergeTwoLists_1(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
