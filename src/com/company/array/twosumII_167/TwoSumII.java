package com.company.array.twosumII_167;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
//    private static int[] twoSum(int[] numbers, int target) {
//        //时间复杂度O(n^2)
//        //暴力解法
//        int[] result = new int[2];
//        for (int i = 0; i < numbers.length; i++) {
//            int another = target - numbers[i];
//            for (int j = 0; j < numbers.length; j++) {
//                if (numbers[j] == another) {
//                    result[0] = i + 1;
//                    result[1] = j + 1;
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    private static int[] twoSum_1(int[] numbers, int target) {
        //时间复杂度O(NlogN)
        //二分查找
        if (numbers.length < 2)
            throw new IllegalArgumentException("Illegal argument numbers");
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No solution!");
    }

    private static int binarySearch(int[] nums, int l, int r, int target) {
        if (l < 0 || l > nums.length)
            throw new IllegalArgumentException("l is out of bound");

        if (r < 0 || r > nums.length)
            throw new IllegalArgumentException("r is out of bound");

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    private static int[] twoSum_2(int[] numbers, int target) {
        //时间复杂度O(n^2)
        //利用Map映射(get方法的时间复杂度是O(n)，因为需要遍历map来寻找key)
        assert numbers.length >= 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No solution!");
    }

    private static int[] twoSum_3(int[] numbers, int target) {
        //时间复杂度O(n)
        //双指针：一个指针指向数组头部，一个指针指向数组尾部，根据指针两个数的和，决定指针如何变换位置
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target)
                return new int[]{l + 1, r + 1};
            else if (numbers[l] + numbers[r] > target)
                r--;
            else
                l++;
        }

        throw new IllegalArgumentException("No solution!");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum_2(nums, target);
        for (int i1 : result)
            System.out.println(i1);
    }
}
