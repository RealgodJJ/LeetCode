package com.company.twosum_1;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        for (int i = 0;i<result.length;i++)
            System.out.println(result[i]);
    }
}
