package com.company.productofarray_238;

public class ProductOfArray {
    private static int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int j = len - 1; j >= 0; j--) {
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 4};
        int[] newNums = productExceptSelf(nums);
        for (int num : newNums)
            System.out.println(num);
    }
}
