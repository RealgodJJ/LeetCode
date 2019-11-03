package com.company.sort;

class QuickSort {
    long quickSort(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 1 || left >= right)
            return 0;

        long startTime = System.currentTimeMillis();
        int middle = partion(nums, left, right);
        quickSort(nums, left, middle);
        quickSort(nums, middle + 1, right);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    int partion(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (temp <= nums[right] && left < right) {
                right--;
            }

            if (left < right) {
                nums[left] = nums[right];
                left++;
            }

            while (temp >= nums[left] && left < right) {
                left++;
            }

            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = temp;
        return left;
    }
}
