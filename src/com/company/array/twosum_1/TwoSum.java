package com.company.array.twosum_1;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        //时间复杂度：O(n^2)——暴力解法
        //空间复杂度：O(1)
        int[] two = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    two[0] = i;
                    two[1] = j;
                }
            }
        }
        return two;
    }


    private static int[] twoSum_2(int[] nums, int target) {
        //时间复杂度：O(n)——利用HashMap的映射方案
        //空间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution!");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] nums1 = {3, 2, 4};
        int target1 = 6;

        int[] result = twoSum(nums, target);
        for (int i1 : result)
            System.out.println(i1);

        int[] result1 = twoSum_2(nums1, target1);
        for (int i2 : result1)
            System.out.println(i2);
    }
}
