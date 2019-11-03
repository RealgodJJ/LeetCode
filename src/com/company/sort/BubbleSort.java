package com.company.sort;

class BubbleSort {
    long bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
