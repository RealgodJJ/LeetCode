package com.company.longestrising_300;

public class LongestRising {
    //该算法的复杂度为O(n^2)
    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;//子序列就是本身
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;//以A[j]结尾的最长上升子序列的长度，加上A[i]
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //概算法的复杂度为O(n*lgn)
    private static int newLengthOfLIS(int[] nums) {
        /*
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         */
        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int low = 0, high = maxL;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (dp[mid] < num)
                    low = mid + 1;
                else
                    high = mid;
            }
            dp[low] = num;
            if (low == maxL)
                maxL++;
        }
        return maxL;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int num = newLengthOfLIS(nums);
        System.out.println(num);
    }
}
