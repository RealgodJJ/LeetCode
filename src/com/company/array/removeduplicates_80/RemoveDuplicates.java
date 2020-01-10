package com.company.array.removeduplicates_80;

public class RemoveDuplicates {
    private static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        else if (nums.length < 3) return nums.length;
        else {
            int length = 1;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[length - 1]) {
                    length++;
                    nums[length] = nums[i];
                }
            }

            return length + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++)
            System.out.println(nums[i]);
    }
}
