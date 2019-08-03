package com.company.removelistnode_203;

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

    private static ListNode removeElementsWithRecursion(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call remove " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }

        ListNode result = removeElementsWithRecursion(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + result);

        ListNode resultNode;
        if (head.val == val) {
            resultNode = result;
        } else {
            head.next = result;
            resultNode = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + resultNode);

        return resultNode;
//        return head.val == val ? head.next : head;

//        int result = = removeElementsWithRecursion(head.next, val);
//        if (head.val == val)
//            return result;
//        else {
//            head.next = result;
//            return head;
//        }
    }

    private static String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
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

        System.out.println("===== 下一个创建链表的方式 =====");
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode1 = new ListNode(nums);

        removeElementsWithDummyHead(listNode1, 6);
        System.out.println(listNode1);

        System.out.println("===== 下一个创建链表的方式2 =====");
        int[] array = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode2 = new ListNode(array);

        removeElementsWithRecursion(listNode2, 6, 0);
        System.out.println(listNode2);


    }
}
