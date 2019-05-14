package com.company.maxsubsequencesum_53;

public class MaxSubsequenceSum {
    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static int maxSubArray_1(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum + num <= num) {
                sum = num;
            } else {
                sum += num;
            }

            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums ={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray_1(nums));
    }
}
