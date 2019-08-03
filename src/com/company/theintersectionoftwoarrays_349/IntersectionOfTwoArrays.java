package com.company.theintersectionoftwoarrays_349;

import java.util.*;

public class IntersectionOfTwoArrays {
    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num1 : nums1)
            hashSet.add(num1);

        List<Integer> result = new ArrayList<>();
        for (int num2 : nums2) {
            if (hashSet.contains(num2)) {
                hashSet.remove(num2);
                result.add(num2);
            }
        }

        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            ret[i] = result.get(i);

        return ret;
    }

    private static int[] intersection_1(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num1 : nums1) {
            if (!list1.contains(num1)) {
                list1.add(num1);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for (int num2 : nums2) {
            if (list1.contains(num2) && !list2.contains(num2))
                list2.add(num2);
        }

        int[] result = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            result[i] = list2.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
