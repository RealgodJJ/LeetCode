package com.company.sort.insertsort;

public class InsertSort {

    public long insertSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        long startTime = System.currentTimeMillis();
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && temp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
