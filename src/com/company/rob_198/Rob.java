package com.company.rob_198;

public class Rob {
    private static int rob(int[] nums) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sumEven += nums[i];
                sumEven = Math.max(sumOdd, sumEven);
            } else {
                sumOdd += nums[i];
                sumOdd = Math.max(sumOdd, sumEven);
            }
        }
        return Math.max(sumOdd, sumEven);
    }

    //自底向上的动态规划
    private static int rob_1(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int[] nums_1 = {1, 10, 1, 1, 10, 3, 3, 10};
        System.out.println(rob(nums));
        System.out.println(rob_1(nums_1));
    }
}
