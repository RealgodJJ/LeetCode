package com.company.removeduplicates_26;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int length = 1;
            int temp = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != temp) {
                    temp = nums[i];
                    nums[length] = nums[i];
                    length++;
                }
            }
            return length;
        }
    }
}
