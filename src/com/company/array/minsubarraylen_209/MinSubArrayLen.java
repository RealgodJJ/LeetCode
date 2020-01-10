package com.company.array.minsubarraylen_209;

public class MinSubArrayLen {
    private static int minSubArrayLen(int s, int[] nums) {
        //时间复杂度：O(n^3)
        //空间复杂度：O(1)
        //暴力解法优化求和部分寻找最短连续子数组
        if (s < 0 || nums == null)
            throw new IllegalArgumentException("Illegal result!");

        int length = nums.length + 1;
        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                int sum = 0;
                for (int i = l; i <= r; i++)
                    sum += nums[i];
                if (sum >= s)
                    length = Math.min(length, r - l + 1);
            }
        }

        if (length == nums.length + 1) return 0;
        return length;
    }

    private static int minSubArrayLen_1(int s, int[] nums) {
        //时间复杂度：O(n^2)
        //空间复杂度：O(1)
        //暴力解法优化，寻找最短连续子数组
        if (s < 0 || nums == null)
            throw new IllegalArgumentException("Illegal result!");

        if (nums.length == 0) return 0;

        //sum[i]存储[0, i]区间所有取值的和
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];

        int length = nums.length + 1;
        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                //获取[l, r]区间的和
                if (sum[r] - sum[l] + nums[l] >= s) {
                    length = Math.min(length, r - l + 1);
                }
            }
        }

        if (length == nums.length + 1) return 0;
        return length;
    }

    private static int minSubArrayLen_2(int s, int[] nums) {
        //时间复杂度：O(NlogN)
        //空间复杂度：O(1)
        //双重循环，求和阶段查找第二坐标位置使用二分查找
        if (s < 0 || nums == null)
            throw new IllegalArgumentException("Illegal result!");

        if (nums.length == 0) return 0;

        //sum[i]存储[0, i]区间所有取值的和
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];

        int length = nums.length + 1;
        for (int l = 0; l < nums.length; l++) {
            // 我们需要自己实现一个基于二分搜索的lowerBound:)
            int r = lowerBound(sum, sum[l] + s - nums[l], l);
            if (r != sum.length)
                length = Math.min(length, r - l + 1);
            else break;
        }

        if (length == nums.length + 1) return 0;

        return length;
    }

    // 在有序数组sum中寻找大于等于target的最小值
    // 如果没有（sum数组中所有值都小于target），则返回nums.length
    private static int lowerBound(int[] sum, int target, int left) {
        if (sum == null)
            throw new IllegalArgumentException("Illegal argument nums in lowerBound.");

        int l = left, r = sum.length;  // 在nums[l...r)的范围里寻找解
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (sum[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private static int minSubArrayLen_3(int s, int[] nums) {
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        //利用滑动窗口寻找最短连续子数组
        if (s < 0 || nums == null)
            throw new IllegalArgumentException("Illegal result!");

        int left = 0, right = -1;   //设定出初始滑动窗口，窗口范围是[left, right]
        int sum = 0;
        int length = nums.length + 1;   //设定初始长度比数组长度大1
        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s)
                sum += nums[++right];
            else
                sum -= nums[left++];

            if (sum >= s)
                length = Math.min(length, right - left + 1);
        }

        if (length == nums.length + 1) return 0;
        return length;
    }

//    private static int minSubArrayLen_4(int s, int[] nums) {
//        //时间复杂度：O(n)
//        //空间复杂度：O(1)
//        //利用双指针对撞寻找最短连续子数组（错误的不成功，会错过最短碰撞应该适合找范围广的）
//        if (s < 0 || nums == null)
//            throw new IllegalArgumentException("Illegal result!");
//
//        int left = 0, right = nums.length - 1;   //设定两个指针位置
//        int sum = 0;
//        int length = nums.length;   //设定初始长度比数组长度大1
//        for (int num : nums) sum += num;
//
//        while (left <= right) {
//            if (sum > s) {
//                if (nums[left] >= nums[right])
//                    sum -= nums[right--];
//                else
//                    sum -= nums[left++];
//                length--;
//            } else {
//                if (length == nums.length)
//                    return 0;
//                else return length;
//            }
//        }
//        return length;
//    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(minSubArrayLen_2(s, nums));

        int[] nums_1 = {2, 3, 1};
        int s1 = 7;
        System.out.println(minSubArrayLen_2(s1, nums_1));

        int[] nums_2 = {};
        int s2 = 100;
        System.out.println(minSubArrayLen_1(s2, nums_2));

        int[] nums_3 = {1, 4, 4};
        int s3 = 4;
        System.out.println(minSubArrayLen_3(s3, nums_3));
    }
}
