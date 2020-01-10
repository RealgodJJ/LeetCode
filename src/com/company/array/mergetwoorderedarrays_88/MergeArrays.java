package com.company.array.mergetwoorderedarrays_88;

import java.util.Arrays;

public class MergeArrays {

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        //暴力解法（先合并再排序）
        //时间复杂度：O((m + n)log(m + n))
        //空间复杂度：O(1)
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    private static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        //采用双指针（两个数组从前往后遍历）
        //时间复杂度：O(n + m)
        //空间复杂度：O(m)
        //复制nums1中有效数据段[0, m]
        int[] nums1_copy = new int[m];
        for (int i = 0; i < m; i++)
            nums1_copy[i] = nums1[i];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n)
            nums1[k++] = nums1_copy[i] <= nums2[j] ? nums1_copy[i++] : nums2[j++];

        //添加nums2中还未遍历到的元素
        while (j < n) {
            nums1[k++] = nums2[j++];
        }

        //添加nums1_copy中还未遍历到的元素
        while (i < m) {
            nums1[k++] = nums1_copy[i++];
        }
    }

    private static void merge_2(int[] nums1, int m, int[] nums2, int n) {
        //采用双指针（两个数组从后往前遍历）
        //时间复杂度：O(n + m)
        //空间复杂度：O(1)
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums2[j] >= nums1[i])
                nums1[k--] = nums2[j--];
            else
                nums1[k--] = nums1[i--];
        }

        //添加nums2中还未遍历到的元素
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int[] nums2 = {0, 2, 5, 6};
        merge_1(nums1, nums1.length - nums2.length, nums2, nums2.length);
        for (int num : nums1)
            System.out.println(num);
    }
}
