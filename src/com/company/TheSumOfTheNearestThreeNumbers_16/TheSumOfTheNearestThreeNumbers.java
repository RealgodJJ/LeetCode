package com.company.TheSumOfTheNearestThreeNumbers_16;

import java.util.Arrays;

public class TheSumOfTheNearestThreeNumbers {
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int threeSum = nums[left] + nums[right] + nums[i];
                    if (Math.abs(result - target) > Math.abs(threeSum - target)) {
                        result = threeSum;
                    }

                    if (threeSum < target) left++;
                    else if (threeSum > target) right--;
                    else return target;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int[] nums_1 = {0, 0, 0};
        int[] nums_2 = {4, -1, -4, 4};
        int[] nums_3 = {0, 2, 1, -3};
        int[] nums_4 = {1, 2, 4, 8, 16, 32, 64, 128};
        int[] nums_5 = {-1, 0, 1, 1, 55};

        System.out.println(threeSumClosest(nums, 1));
        System.out.println(threeSumClosest(nums_1, 1));
        System.out.println(threeSumClosest(nums_2, 1));
        System.out.println(threeSumClosest(nums_3, 1));
        System.out.println(threeSumClosest(nums_4, 82));
        System.out.println(threeSumClosest(nums_5, 3));
    }
}
