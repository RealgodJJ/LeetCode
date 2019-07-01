package com.company.thesumofthethreenumbers_15;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                //两个指针分别从小、从大集中进行遍历
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
//                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                    } else {
//                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    }
                }
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
    }
}
