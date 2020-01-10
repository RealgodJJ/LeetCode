package com.company.sort.swapsort;

public class QuickSort {
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

    public void newQuickSort(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 1 || left >= right) return;

        int l = left, r = right, key = nums[l];
        while (l < r) {
            while (nums[r] >= key && l < r)
                r--;

            nums[l] = nums[r];
            nums[r] = key;

            while (nums[l] <= key && l < r)
                l++;

            nums[r] = nums[l];
            nums[l] = key;
        }

        newQuickSort(nums, left, l - 1);
        newQuickSort(nums, l + 1, right);
    }

    //二分查找递归方法
    int halfSearch(int[] nums, int left, int right, int target) {
        if (nums == null || nums.length == 0 || left > right)
            return -1;

        int middle = (left + right) / 2;

        if (target == nums[middle])
            return middle;
        else if (target > nums[middle])
            return halfSearch(nums, middle + 1, right, target);
        else
            return halfSearch(nums, left, middle - 1, target);
    }

    int halfSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        int middle;

        while (left <= right) {
            middle = (left + right) / 2;
            if (target == nums[middle])
                return middle;
            else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

}
