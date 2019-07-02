package com.company.RemoveListNode_203;

public class RemoveListNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        //数组转换成链表
        ListNode(int[] array) {
            if (array == null || array.length == 0)
                throw new IllegalArgumentException("Array can't be empty.");

            this.val = array[0];
            ListNode current = this;
            for (int i = 1; i < array.length; i++) {
                current.next = new ListNode(array[i]);
                current = current.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            ListNode current = this;
            while (current != null) {
                stringBuilder.append(current.val + " -> ");
                current = current.next;
            }
            stringBuilder.append("NULL");
            return stringBuilder.toString();
        }
    }

    //未使用虚拟头节点
    private static ListNode removeElements(ListNode head, int val) {
        //头元素为目标删除元素
        while (head != null && head.val == val) {
            ListNode deleteNode = head;
            head = head.next;
            deleteNode.next = null;
        }

        if (head == null)
            return null;

        //中间元素为目标删除元素
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode deleteNode = prev.next;
                prev.next = deleteNode.next;
                deleteNode.next = null;
            } else
                prev = prev.next;
        }

        return head;
    }

    private static ListNode removeElementsWithDummyHead(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode deleteNode = prev.next;
                prev.next = deleteNode.next;
                deleteNode.next = null;
            } else
                prev = prev.next;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode prev = listNode;

        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(6);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        listNode = listNode.next;
        listNode.next = new ListNode(6);

//        prev = removeElements(prev, 6);
        prev = removeElementsWithDummyHead(prev, 6);

        while (prev != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode1 = new ListNode(nums);

        removeElementsWithDummyHead(listNode1, 6);
        System.out.println(listNode1);

    }
}
