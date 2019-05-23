package com.company.mergetwoorderedarrays_88;

public class MergeArrays {

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums2[j] >= nums1[i]) {
                nums1[k] = nums2[j];
                j--;
                k--;
            } else {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }

        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }

    private static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        m--;
        n--;
        while (p >= 0 && m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        if (n >= 0) {
            while (p >= 0) {
                nums1[p--] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {0, 2, 5, 6};
        merge_1(nums1, nums1.length - nums2.length, nums2, nums2.length);
        for (int num : nums1)
            System.out.println(num);
    }
}
