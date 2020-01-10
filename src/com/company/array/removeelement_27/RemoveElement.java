package com.company.array.removeelement_27;

public class RemoveElement {
    private static int removeElement_1(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    private static int removeElement_2(int[] nums, int val) {
        //假设删除的元素较少，可以将待删除的元素与最后一个元素进行交换，然后释放最后一个元素
        int len = 0;
        int n = nums.length;
        while (len < n) {
            if (nums[len] == val) {
                nums[len] = nums[n - 1];
                n--;
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int len = removeElement_2(nums, 2);
        for (int i = 0; i < len; i++)
            System.out.println(nums[i]);
        System.out.println();
    }
}
