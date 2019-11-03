package com.company.sort;

class SelectSort {
    long selectSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
