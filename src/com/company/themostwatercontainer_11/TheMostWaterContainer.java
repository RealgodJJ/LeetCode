package com.company.themostwatercontainer_11;

public class TheMostWaterContainer {
    private static int maxAreaFast(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * minHeight);
            if (minHeight == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private static int maxAreaComplicate(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, (j - i) * minHeight);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxAreaFast(height);
        System.out.println(maxArea);
    }
}
