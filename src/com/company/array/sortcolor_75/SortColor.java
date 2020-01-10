package com.company.array.sortcolor_75;

public class SortColor {
    private static void sortColors_0(int[] nums) {
        //时间复杂度O(n)
        //空间复杂度O(counts.length)
        //(1)遍历数组，统计0、1、2的个数
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }

        //(2)再次遍历将数组填补上0、1、2元素
        int index = 0;
        for (int i = 0; i < counts[0]; i++)
            nums[index++] = 0;

        for (int i = 0; i < counts[1]; i++)
            nums[index++] = 1;

        for (int i = 0; i < counts[2]; i++)
            nums[index++] = 2;
    }

    private static void sortColors_1(int[] nums) {
        //编写计数排序算法
        //时间复杂度O(n+k)
        //空间复杂度O(counts.length)
        //(1)遍历数组，统计0、1、2的个数
        int[] counts = new int[3];
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        for (int num : nums) {
            counts[num]++;
        }

        //(2)再次遍历将数组填补上0、1、2元素
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[--counts[result[i]]] = result[i];
        }
    }

    private static void sortColor_2(int[] nums) {
        //时间复杂度O(n)
        //空间复杂度O(1)
        //使用三路快排，在遍历数组的同时，将0、1、2三种元素的位置进行排序
        int zero = -1;  //保证0元素的位置在[0, zero]的区间中
        int two = nums.length;  //保证2元素的位置在[two, nums.length - 1]的区间中
        for (int i = 0; i < two; ) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2) {
                int temp = nums[--two];
                nums[two] = nums[i];
                nums[i] = temp;
            } else {
                assert nums[i] == 0;
                int temp = nums[++zero];
                nums[zero] = nums[i];
                nums[i++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors_1(nums);

        for (int num : nums)
            System.out.println(num);
    }
}
