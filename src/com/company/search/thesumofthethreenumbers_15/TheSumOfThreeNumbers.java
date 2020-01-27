package com.company.search.thesumofthethreenumbers_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheSumOfThreeNumbers {
//    private static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> resultList = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i == 0 || nums[i] != nums[i - 1]) {
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (nums[i] + nums[j] + nums[k] == 0) {
//                            List<Integer> result = new ArrayList<>();
//                            result.add(nums[i]);
//                            result.add(nums[j]);
//                            result.add(nums[k]);
//                            resultList.add(result);
//                        }
//                    }
//                }
//            }
//        }
//        return resultList;
//    }

    private static List<List<Integer>> threeSum(int[] nums) {
        //时间复杂度：O(n^2)
        if (nums == null || nums.length < 3)
            return Collections.emptyList();

        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                //两个指针分别从小、从大向中间碰撞进行遍历
                int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        //找到一组答案之后，继续向后遍历寻找新的答案
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return resultList;
    }

    private static List<List<Integer>> threeSum_1(int[] nums) {
        if (nums == null || nums.length < 3)
            return Collections.emptyList();

        List<List<Integer>> resultList = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0, posSize = 0, zeroSize = 0;

        //统计正数、负数和零的数量；统计整个数组的最大值和最小值
        for (int num : nums) {
            if (num < minValue)
                minValue = num;
            if (num > maxValue)
                maxValue = num;
            if (num > 0) posSize++;
            else if (num < 0) negSize++;
            else zeroSize++;
        }

        if (zeroSize >= 3)
            resultList.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return resultList;

        //获得适合本数组的最大值和最小值
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;
        int[] map = new int[maxValue - minValue + 1];   //存放所有元素及其对应出现的次数
        int[] negs = new int[negSize];  //存放负数
        int[] poses = new int[posSize]; //存放正数
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize); //正数排序
        Arrays.sort(negs, 0, negSize);  //负数排序

        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int minp = (-negs[i]) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int target = 0 - negs[i] - poses[j];
                if (target >= negs[i] && target <= poses[j]) {
                    if (target == negs[i]) {
                        if (map[negs[i] - minValue] > 1)
                            resultList.add(Arrays.asList(negs[i], poses[j], negs[i]));
                    } else if (target == poses[j]) {
                        if (map[poses[j] - minValue] > 1)
                            resultList.add(Arrays.asList(negs[i], poses[j], poses[j]));
                    } else {
                        if (map[target - minValue] > 0)
                            resultList.add(Arrays.asList(negs[i], poses[j], target));
                    }
                } else if (target < negs[i]) break;
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resultList = threeSum(nums);
        for (List<Integer> integers : resultList)
            for (int j = 0; j < 3; j++)
                System.out.println(integers.get(j));

        List<List<Integer>> resultList1 = threeSum_1(nums);
        for (List<Integer> integers : resultList1)
            for (int j = 0; j < 3; j++)
                System.out.println(integers.get(j));
    }
}
