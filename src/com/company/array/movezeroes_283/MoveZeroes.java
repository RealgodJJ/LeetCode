package com.company.array.movezeroes_283;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {
    private static void moveZeroes_1(int[] nums) {
        //时间复杂度O(n)
        //空间复杂度O(n)
        List<Integer> newArrary = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                //将非零元素添加到新数组中
                newArrary.add(num);
            }
        }

        //非零元素放回原数组
        for (int i = 0; i < newArrary.size(); i++)
            nums[i] = newArrary.get(i);

        //原数组后面放零
        for (int i = newArrary.size(); i < nums.length; i++)
            nums[i] = 0;
    }

    private static void moveZeros_2(int[] nums) {
        //时间复杂度O(n)
        //空间复杂度O(1)
        int k = 0; // 标记在完成前移后的非零元素的后面（用[0, k)的区间保存非零元素）
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                //直接将非零元素向前移
                nums[k++] = nums[i];
        }

        for (int i = k; i < nums.length; i++)
            nums[i] = 0;
    }

    private static void moveZeros_3(int[] nums) {
        //时间复杂度O(n)
        //空间复杂度O(1)
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //将0和非零元素进行交换
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }

    private static void moveZeros_4(int[] nums) {
        //时间复杂度O(n)
        //空间复杂度O(1)
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {   //判断数组是不是全都是非零元素
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                    k++;
                } else
                    k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 13};
        moveZeros_4(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
