package com.company.seekmajority_229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeekMajority {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!resultMap.containsKey(nums[i]))
                resultMap.put(nums[i], 1);
            else
                resultMap.put(nums[i], resultMap.get(nums[i]) + 1);
        }

        for (int key : resultMap.keySet()) {
            if (resultMap.get(key) > nums.length / 3)
                results.add(key);
        }

        return results;
    }

    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> results = new ArrayList<>();
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;

        for(int num : nums) {
            if (count1 == 0 && num2 != num) {
                num1 = num;
            } else if (count2 == 0) {
                num2 = num;
            }

            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            results.add(num1);
        }
        if (count2 > nums.length / 3) {
            results.add(num2);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        SeekMajority seekMajority = new SeekMajority();
        List<Integer> results = seekMajority.majorityElement(nums);
        List<Integer> results1 = seekMajority.majorityElement1(nums);

        for (Integer result : results) {
            System.out.println(result);
        }

        for (Integer result : results1) {
            System.out.println(result);
        }
    }
}
