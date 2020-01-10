package com.company.sort.swapsort;

public class BubbleSort {
    public long bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        long startTime = System.currentTimeMillis();
        boolean flag = true;
        for (int i = 0; i < nums.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
