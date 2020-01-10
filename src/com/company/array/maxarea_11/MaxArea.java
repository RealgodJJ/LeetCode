package com.company.array.maxarea_11;

public class MaxArea {
    private static int maxArea(int[] height) {
        //时间复杂度O(n^2)
        //暴力解法
        assert height.length >= 2;

        int noZero = 0;
        for (int h1 : height) {
            if (h1 > 0)
                noZero++;
        }
        if (noZero < 2) return 0;

        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = area > maxArea ? area : maxArea;
            }
        }

        return maxArea;
    }

    private static int maxArea_1(int[] height) {
        //时间复杂度O(n)
        //双指针碰撞
        assert height.length >= 2;
        int noZero = 0;
        for (int h1 : height) {
            if (h1 > 0)
                noZero++;
        }
        if (noZero < 2) return 0;

        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = area > maxArea ? area : maxArea;
            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxArea_1(height));
    }
}
