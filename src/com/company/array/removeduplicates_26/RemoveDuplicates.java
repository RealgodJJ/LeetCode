package com.company.array.removeduplicates_26;

public class RemoveDuplicates {
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int length = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[length]) {
                    length++;
                    nums[length] = nums[i];
                }
            }
            return length + 1;
        }
    }

    private static int removeDuplicates_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int length = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[length - 1]) {
                    nums[length] = nums[i];
                    length++;
                }
            }
            return length;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int[] nums_1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] newNums = {0};
        int len = removeDuplicates_1(nums_1);
        for (int i = 0; i < len; i++)
            System.out.println(nums_1[i]);
    }
}
