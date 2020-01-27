package com.company.search.theintersectionoftwoarrays_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {

    private static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num1 : nums1) {
            if (!numMap.containsKey(num1))
                numMap.put(num1, 1);
            else
                numMap.put(num1, numMap.get(num1) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int num2 : nums2) {
            if (numMap.containsKey(num2)) {
                res.add(num2);
                numMap.put(num2, numMap.get(num2) - 1);
                if (numMap.get(num2) == 0)
                    numMap.remove(num2);
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);

        return ret;
    }

    private static int[] intersect_1(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                // 从 list1 除去已匹配的数值(如果不转换成Integer，会以为是采用删除对应序号的元素)
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[list2.size()];
        int i = 0;
        for (int num : list2) {
            res[i++] = num;
        }
        return res;
    }

    //先将两个数组进排序，再使用双指针同时遍历两个数组
    private static int[] intersect_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};


        int[] result = intersect_2(nums1, nums2);
        for (int res :result) {
            System.out.println(res);
        }
    }
}
